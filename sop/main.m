clear all;
warning('off');
rand('seed',0);
cases = get_cases();
mpc = cases(1);
branch_bus_map = containers.Map();
for i = 1 : size(mpc.branch,1)
    branch_bus_map = branch_bus_converter(branch_bus_map,mpc.branch(i,1),mpc.branch(i,2),size(mpc.bus,1));
end
%% �û��Զ��廹Ҫ������Щ��ѡ��·
branch_bus_map = branch_bus_converter(branch_bus_map,8,21,size(mpc.bus,1));
branch_bus_map = branch_bus_converter(branch_bus_map,9,15,size(mpc.bus,1));
branch_bus_map = branch_bus_converter(branch_bus_map,12,22,size(mpc.bus,1));
branch_bus_map = branch_bus_converter(branch_bus_map,39,43,size(mpc.bus,1));
branch_bus_map = branch_bus_converter(branch_bus_map,44,45,size(mpc.bus,1));
branch_bus_map = branch_bus_converter(branch_bus_map,40,47,size(mpc.bus,1));
branch_bus_map = branch_bus_converter(branch_bus_map,22,38,size(mpc.bus,1));
branch_bus_map = branch_bus_converter(branch_bus_map,16,47,size(mpc.bus,1));
branch_bus_map = branch_bus_converter(branch_bus_map,25,29,size(mpc.bus,1));
branch_bus_map = branch_bus_converter(branch_bus_map,18,33,size(mpc.bus,1));
iteration = 50;
n_sop = 4;
% best_chrome = zeros(n_sop,branch_bus_map.Count);
% ite_best = zeros(n_sop,iteration);
% ite_avg = zeros(n_sop,iteration);

%% ����
for i = n_sop:n_sop
    [v,x,y,z] = my_ga(cases, branch_bus_map,n_sop,iteration);
%     best_chrome(i,:) = v(1:end-1);
%     ite_best(i,:) = x;
%     ite_avg(i,:) = y;
    
end