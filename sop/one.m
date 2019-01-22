cases = get_cases();
y = 0;
exceed_u2 = 0;
% for i = 1 : size(cases,2)
i=2;
    mpc = cases(i);
    [result,is_convergent] = opf(mpc);
    u = result.bus(:,8); % 8   Vm, voltage magnitude (p.u.) 出自：doc caseformat。bus 详细格式见手册 Table B-1: Bus Data (mpc.bus)
    u_max = 1.07;
    u_min = 0.93;
    if is_convergent
        y = y+sum((u - 1).^2);
        exceed_u2 = exceed_u2 + ((u - 1).^2)' * (u > u_max) + ((u - 1).^2)' * (u < u_min);
    else
        y = y+1;
        exceed_u2 = exceed_u2 + 1;
    end
% end
y = y/3;
exceed_u2 = exceed_u2/3;