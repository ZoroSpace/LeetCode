function [best_chrome,ite_best,ite_avg,ite_exceed_u2] = my_ga(cases, branch_bus_map,n_sop,iteration)
% mpc：电网基本配置，结构体
% line_number_to_node：是一个map，key是线路的编号，value可以表示节点。
% n_sop：柔性多状态开关个数
% iteration：迭代次数
%% 初始化种群，对各染色体进行编码
n_chrome = 30; % 染色体数目
crossover_rate = 0.8; % 交叉概率
mutation_rate = 0.2; % 变异概率
ite_best = zeros(1,iteration);
ite_avg = zeros(1,iteration);
ite_exceed_u2 = ones(1,iteration);
m = n_chrome;
n = branch_bus_map.Count;
chromes = zeros(n_chrome,n+1);% 用于存储全部基因，最后一列用于存储cost
best_chrome = [];
best_f = 10;
% n_sop：柔性多状态开关个数
%% 基因初始化，为每个染色体分配n_sop个二端口柔性多状态开关
for i = 1 : m
    rand_numbers = randperm(n); % matlab之生成不重复的随机整数 https://blog.csdn.net/yq_forever/article/details/75093433
    chromes(i,rand_numbers(1:n_sop)) = 1;
end

for it = 1 : iteration
    disp(['the ',num2str(it),'th iteration']);
    
    %% 计算每个染色体的适应度函数
    for i = 1 : m
%         chromes(i,end) = rand;
        chromes(i,end) = 0;
        exceed_u2_sum = 0;
        for j = 1 : size(cases,2)
            [y,exceed_u2] = my_fun(cases(j), chromes(i,1:end-1),branch_bus_map); % 仅将chrome前n位传入函数
            chromes(i,end) = chromes(i,end) + y;
            exceed_u2_sum = exceed_u2_sum + exceed_u2;
            
        end
        if ite_exceed_u2(it) > exceed_u2_sum
            ite_exceed_u2(it) = exceed_u2_sum;
        end
        if(chromes(i,end) < best_f)
            best_chrome = chromes(i,:);
            best_f = chromes(i,end);
        end
    end
    ite_avg(it) = mean(chromes(:,end))/size(cases,2);
    chromes(chromes(:,end)>100,:)=[]; % 删除潮流不收敛的线路
    %% 选择
    chromes = sortrows(chromes,n+1);
    chromes(:,end) = max(chromes(:,end))+0.001 - chromes(:,end); % cost越小，适应度越大
    chromes(:,end) = chromes(:,end)/sum(chromes(:,end));% 归一化，对应改行染色体被选中的概率
    chromes(:,end) = cumsum(chromes(:,end)); % 将概率累加
    new_chromes = zeros(m,n+1);
    for i = 1 : m
        new_chromes(i,:) = chromes(find(rand <= chromes(:,end),1,'first'),:);
    end
    chromes = new_chromes;
    %% 交叉
    for i = 1 : 2 : m-1
        if rand < crossover_rate
            c1 = chromes(i,1:end-1);
            c2 = chromes(i+1,1:end-1);
            % 交叉c1和c2两条染色体，并保持其中1的个数不变
            set1 = find(c1 == 1);
            set2 = find(c2 == 1);
            diff_gene = setxor(set1,set2); % 不同基因位
            same_gene = intersect(set1,set2); % 相同基因位
            diff_gene = diff_gene(randperm(size(diff_gene,2)));
            c1 = zeros(size(c1));
            c2 = zeros(size(c2));
            c1(diff_gene(1:(size(diff_gene,2))/2)) = 1;
            c2(diff_gene(size(diff_gene,2)/2+1:end)) = 1;
            c1(same_gene) = 1;
            c2(same_gene) = 1;
            chromes(i,1:end-1) = c1;
            chromes(i+1,1:end-1) = c2;
        end
    end
    
    %% 变异
    for i = 1 : m
        if rand < mutation_rate
            c1 = chromes(i,1:end-1);
            equal_1 = find(c1 == 1);
            equal_0 = find(c1 == 0);
            c1(equal_1(randi(size(equal_1,2)))) = 0;
            c1(equal_0(randi(size(equal_0,2)))) = 1;
            chromes(i,1:end-1) = c1;
        end
    end
    ite_best(it) = best_f;
end
end