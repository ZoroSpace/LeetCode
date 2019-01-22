function decorate_figure(line_handle, line_size, axes_handle, axes_size, box_size, legend_handle)
% 简化图像后期处理过程,输入参数5个
% 分别为线条句柄H,线条宽度大小设置,坐标轴句柄gca,坐标轴刻度与名称大小,box的宽度大小设置
% 建议采用参数: decorate_figure(H,1.5,gca,18,1.5); decorate_figure(H,1.5,gca,18,1.5,LE);
if nargin >= 5
    set(line_handle,'LineWidth',line_size);
    set(axes_handle,'FontName','Times New Roman','FontSize',axes_size);%设置坐标轴字体大小，字型
    set(get(axes_handle,'xLabel'),'FontSize',axes_size,'FontName','Times New Roman');%设置X坐标标题字体大小，字型
    set(get(axes_handle,'yLabel'),'FontSize',axes_size,'FontName','Times New Roman');%设置Y坐标标题字体大小，字型
    set(get(axes_handle,'zLabel'),'FontSize',axes_size,'FontName','Times New Roman');%设置Z坐标标题字体大小，字型
    set(axes_handle,'LineWidth',box_size);%设置坐标框的宽度
end
if nargin > 5
    set(legend_handle,'FontSize',12);
end
end