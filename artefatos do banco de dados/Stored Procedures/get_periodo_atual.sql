delimiter $$

create procedure get_periodo_atual (out ano int, out semestre int)
begin
	set @data_atual = now();
    set ano = year(@data_atual);
    set @mes = month(@data_atual);
    
    if (@mes <= 6) then
		set semestre = 1;
	else
		set semestre = 2;
	end if;
end $$

delimiter ;