function decorate_figure(line_handle, line_size, axes_handle, axes_size, box_size, legend_handle)
% ��ͼ����ڴ������,�������5��
% �ֱ�Ϊ�������H,������ȴ�С����,��������gca,������̶������ƴ�С,box�Ŀ�ȴ�С����
% ������ò���: decorate_figure(H,1.5,gca,18,1.5); decorate_figure(H,1.5,gca,18,1.5,LE);
if nargin >= 5
    set(line_handle,'LineWidth',line_size);
    set(axes_handle,'FontName','Times New Roman','FontSize',axes_size);%���������������С������
    set(get(axes_handle,'xLabel'),'FontSize',axes_size,'FontName','Times New Roman');%����X������������С������
    set(get(axes_handle,'yLabel'),'FontSize',axes_size,'FontName','Times New Roman');%����Y������������С������
    set(get(axes_handle,'zLabel'),'FontSize',axes_size,'FontName','Times New Roman');%����Z������������С������
    set(axes_handle,'LineWidth',box_size);%���������Ŀ��
end
if nargin > 5
    set(legend_handle,'FontSize',12);
end
end