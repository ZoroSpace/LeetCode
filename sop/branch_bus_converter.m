function map = branch_bus_converter(map,i,j,n_bus)
% 将线路编号和节点关联起来
map(num2str(map.Count+1)) = (i-1)*n_bus+j;
end

