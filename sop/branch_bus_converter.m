function map = branch_bus_converter(map,i,j,n_bus)
% ����·��źͽڵ��������
map(num2str(map.Count+1)) = (i-1)*n_bus+j;
end

