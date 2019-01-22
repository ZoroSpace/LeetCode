load('switch_3.mat');
H = plot(x);
decorate_figure(H,1.5,gca,18,1.5);
hold on;
load('sop_3.mat');
H = plot(x);
decorate_figure(H,1.5,gca,18,1.5);
load('sop_4.mat');
H = plot(x(1:50));
decorate_figure(H,1.5,gca,18,1.5);
legend('方案②','方案③','方案④')