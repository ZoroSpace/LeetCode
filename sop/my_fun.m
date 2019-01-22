function [y,exceed_u2] = my_fun(mpc, chrome, branch_bus_map)
% mpc：线路结构
% chrome：染色体，每一位对应一条线路
% branch_bus_map：
% 以下手册均指 Matpower User's Manual，Version 7.0b1，手册封面日期为October 31, 2018
% 当潮流收敛时，y返回正常值，反之，返回节点数
% delta_u2表示所有节点与1偏差的平方和

n_bus = size(mpc.bus,1);
n_branch = size(mpc.branch,1);
n_gen = size(mpc.gen,1);
s_max = 3; % sop容量

if chrome(15) == 1
    y = 3;
    exceed_u2 = 3;
    return;
end
%% 根据chrome修改mpc结构
for i = 1 : size(chrome,2)
    if chrome(i) == 1 % 第i条线路安装了柔开
        from_bus = floor((branch_bus_map(num2str(i))-1)/n_bus) + 1;
        to_bus = branch_bus_map(num2str(i)) - (from_bus-1) * n_bus;
        n_from_bus = size(mpc.bus,1)+1; % from_bus 是第几个bus
        % 在from_bus上引出一个虚拟节点vertual_bus，放置有功、无功电源，并限制vertual_bus到from_bus的视在功率
        % 涉及到修改mpc.bus/branch/gene
        % 在to_bus上引出一个虚拟节点vertual_bus，放置有功、无功电源，并限制vertual_bus到to_bus的视在功率
        
        % branch
        branch_x = 0.1;
        branch_r = 0.1;
        
        mpc.bus = [mpc.bus;
            n_from_bus 2 0 0 0 0 1 1 0 23 1 2 0;
            n_from_bus+1 2 0 0 0 0 1 1 0 23 1 2 0];
        % gen
        % bus Pg Qg Qmax Qmin Vg mBase status Pmax Pmin Pc1 Pc2 Qc1min Qc1max Qc2min Qc2max ramp_agc ramp_10 ramp_30 ramp_q apf
        mpc.gen = [mpc.gen;
            n_from_bus 0 0 s_max/4*3 -s_max/4*3 1 1 1 s_max -s_max 0 0 0 0 0 0 0 0 0 0 0;
            n_from_bus+1 0 0 s_max/4*3 -s_max/4*3 1 1 1 s_max -s_max 0 0 0 0 0 0 0 0 0 0 0]; % 要修改柔开的有功约束和无功约束！！！
        % fbus tbus r x b rateA rateB rateC ratio angle status angmin angmax
        for j = 1 : n_branch
            if (mpc.branch(j,1) == from_bus && mpc.branch(j,2) == to_bus) || (mpc.branch(j,1) == to_bus && mpc.branch(j,2) == from_bus)
                mpc.branch(j,11) = 0; % 将原来的from to线路断开
                branch_x = mpc.branch(j,3);
                branch_r = mpc.branch(j,4);
                break;
            end
        end
        mpc.branch = [mpc.branch;
            n_from_bus from_bus branch_x/2 branch_r/2 0 s_max 0 0 0 0 1 -360 360;
            n_from_bus+1 to_bus branch_x/2 branch_r/2 0 s_max 0 0 0 0 1 -360 360]; % 要修改柔开的视在功率约束！！！
        % gencost
        mpc.gencost = [mpc.gencost;
            2 0 0 0 0 0 0;
            2 0 0 0 0 0 0];
    end
end
%% convert branch impedances from Ohms to p.u.
% [PQ, PV, REF, NONE, BUS_I, BUS_TYPE, PD, QD, GS, BS, BUS_AREA, VM, ...
%     VA, BASE_KV, ZONE, VMAX, VMIN, LAM_P, LAM_Q, MU_VMAX, MU_VMIN] = idx_bus;
% [F_BUS, T_BUS, BR_R, BR_X, BR_B, RATE_A, RATE_B, RATE_C, ...
%     TAP, SHIFT, BR_STATUS, PF, QF, PT, QT, MU_SF, MU_ST, ...
%     ANGMIN, ANGMAX, MU_ANGMIN, MU_ANGMAX] = idx_brch;
% Vbase = mpc.bus(1, BASE_KV) * 1e3;      %% in Volts
% Sbase = mpc.baseMVA * 1e6;              %% in VA

% mpc.branch(:, [BR_R BR_X]) = mpc.branch(:, [BR_R BR_X]) / (Vbase^2 / Sbase);

%% convert loads from kW to MW
% mpc.bus(:, [PD, QD]) = mpc.bus(:, [PD, QD]) / 1e3;

%% 每一个孤岛分配一个平衡节点，即改变柔开的工作模式
N = size(mpc.bus,1);
% N = 10;
my_id = 1:N;
my_size = ones(1,N);
my_count = N;

    function p = find(p)
        while p ~= my_id(p)
            my_id(p) = my_id(my_id(p));
            p = my_id(p);
        end
    end

    function is_connected = connected(p,q)
        is_connected = find(p) == find(q);
    end

    function union(p,q)
        rootP = find(p);
        rootQ = find(q);
        if rootP ~= rootQ
            if my_size(rootP) > my_size(rootQ)
                my_id(rootQ) = rootP;
                my_size(rootP) = my_size(rootP) + my_size(rootQ);
            else
                my_id(rootP) = rootQ;
                my_size(rootQ) = my_size(rootP) + my_size(rootQ);
            end
            my_count = my_count - 1;
        end
    end

for i = 1 : size(mpc.branch,1)
    if mpc.branch(i,11) == 1
        union(mpc.branch(i,1),mpc.branch(i,2));
    end
end

slack_bus = [];
for i = 1 : size(mpc.bus,1)
    if mpc.bus(i,2) == 3
        slack_bus = [slack_bus;mpc.bus(i,1)];
    end
end
for i = size(mpc.gen,1) - 2*sum(chrome) + 1 : size(mpc.gen,1)
    if i < 0
        a = 1;
    end
    is_slack = false;
    for j = 1 : size(slack_bus,1)
        
        if connected(mpc.gen(i,1),slack_bus(j))
            is_slack = true;
        end
    end
    if ~is_slack
        slack_bus = [slack_bus;mpc.gen(i,1)];
        mpc.bus(mpc.gen(i,1),2) = 3;
    end
end

%% 求解
% n_x = bus + bus + gen + gen
n_var = size(mpc.bus,1)*2 + size(mpc.gen,1) * 2;
A = zeros(n_var);
l = ones(n_var,1)*(-inf);
u = ones(n_var,1)*inf;

for i = 1 : sum(chrome) % 对于每个柔开，都有一个约束
    A(size(mpc.bus,1)*2 + n_gen+2*i,size(mpc.bus,1)*2 + n_gen+2*i) = 1;
    A(size(mpc.bus,1)*2 + n_gen+2*i,size(mpc.bus,1)*2 + n_gen+2*i-1) = 1;
    l(size(mpc.bus,1)*2 + n_gen+2*i) = 0;
    u(size(mpc.bus,1)*2 + n_gen+2*i) = 0;
end

A = sparse(A);
N = sparse(eye(n_var));
fparm = ones(n_var,1) * [2,1,0,1];
H = sparse(zeros(n_var));
% Cw = zeros(n_var,1);
% Cw(size(mpc.bus,1)+1:size(mpc.bus,1)*2) = 1;
Cw = [zeros(1,size(mpc.bus,1)) ones(1,n_bus) zeros(1,(size(mpc.bus,1) - n_bus)) zeros(1,size(mpc.gen,1)*2)]';
opt=mpoption('VERBOSE',0,'OUT_ALL',0);
% opt = [];
[result,is_convergent] = opf(mpc, A, l, u, opt, N, fparm, H, Cw);

%% 处理结果
u = result.bus(:,8); % 8   Vm, voltage magnitude (p.u.) 出自：doc caseformat。bus 详细格式见手册 Table B-1: Bus Data (mpc.bus)
u_max = 1.07;
u_min = 0.93;
if is_convergent
    y = sum((u - 1).^2);
    exceed_u2 = ((u - 1).^2)' * (u > u_max) + ((u - 1).^2)' * (u < u_min);
else
    y = 1;
    exceed_u2 = 1;
end
end