 delimiter //

create trigger gerar_matricula before insert on matricula
for each row
begin
	
	set @data_atual = now();
	set @ano = cast(Year(@data_atual) as char(4));
    set @mes = Month(@data_atual);
    if (@mes >= 1 and @mes <= 6) then
		set @semestre = '1';
	else
		set @semestre = '2';
	end if;
    set new.matricula = concat( @ano, @semestre, (select max(codigo) from matricula) + 1);
end;//
delimiter ;

