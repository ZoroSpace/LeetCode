chrome = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0];

cases = get_cases();
mpc = cases(1);
branch_bus_map = containers.Map();
for i = 1 : size(mpc.branch,1)
    branch_bus_map = branch_bus_converter(branch_bus_map,mpc.branch(i,1),mpc.branch(i,2),size(mpc.bus,1));
end
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
y = 0;
exceed_u2 = 0;
for i = 1 : size(cases,2)
    mpc = cases(i);
    [a,b] = my_fun(mpc, chrome, branch_bus_map);
    y = y+a;
    exceed_u2 = exceed_u2 + b;
end
y = y/3;
exceed_u2 = exceed_u2/3;