function [best_chrome,ite_best,ite_avg,ite_exceed_u2] = my_ga(cases, branch_bus_map,n_sop,iteration)
% mpc�������������ã��ṹ��
% line_number_to_node����һ��map��key����·�ı�ţ�value���Ա�ʾ�ڵ㡣
% n_sop�����Զ�״̬���ظ���
% iteration����������
%% ��ʼ����Ⱥ���Ը�Ⱦɫ����б���
n_chrome = 30; % Ⱦɫ����Ŀ
crossover_rate = 0.8; % �������
mutation_rate = 0.2; % �������
ite_best = zeros(1,iteration);
ite_avg = zeros(1,iteration);
ite_exceed_u2 = ones(1,iteration);
m = n_chrome;
n = branch_bus_map.Count;
chromes = zeros(n_chrome,n+1);% ���ڴ洢ȫ���������һ�����ڴ洢cost
best_chrome = [];
best_f = 10;
% n_sop�����Զ�״̬���ظ���
%% �����ʼ����Ϊÿ��Ⱦɫ�����n_sop�����˿����Զ�״̬����
for i = 1 : m
    rand_numbers = randperm(n); % matlab֮���ɲ��ظ���������� https://blog.csdn.net/yq_forever/article/details/75093433
    chromes(i,rand_numbers(1:n_sop)) = 1;
end

for it = 1 : iteration
    disp(['the ',num2str(it),'th iteration']);
    
    %% ����ÿ��Ⱦɫ�����Ӧ�Ⱥ���
    for i = 1 : m
%         chromes(i,end) = rand;
        chromes(i,end) = 0;
        exceed_u2_sum = 0;
        for j = 1 : size(cases,2)
            [y,exceed_u2] = my_fun(cases(j), chromes(i,1:end-1),branch_bus_map); % ����chromeǰnλ���뺯��
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
    chromes(chromes(:,end)>100,:)=[]; % ɾ����������������·
    %% ѡ��
    chromes = sortrows(chromes,n+1);
    chromes(:,end) = max(chromes(:,end))+0.001 - chromes(:,end); % costԽС����Ӧ��Խ��
    chromes(:,end) = chromes(:,end)/sum(chromes(:,end));% ��һ������Ӧ����Ⱦɫ�屻ѡ�еĸ���
    chromes(:,end) = cumsum(chromes(:,end)); % �������ۼ�
    new_chromes = zeros(m,n+1);
    for i = 1 : m
        new_chromes(i,:) = chromes(find(rand <= chromes(:,end),1,'first'),:);
    end
    chromes = new_chromes;
    %% ����
    for i = 1 : 2 : m-1
        if rand < crossover_rate
            c1 = chromes(i,1:end-1);
            c2 = chromes(i+1,1:end-1);
            % ����c1��c2����Ⱦɫ�壬����������1�ĸ�������
            set1 = find(c1 == 1);
            set2 = find(c2 == 1);
            diff_gene = setxor(set1,set2); % ��ͬ����λ
            same_gene = intersect(set1,set2); % ��ͬ����λ
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
    
    %% ����
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