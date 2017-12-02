delimiter //

create trigger verificar_limite_disciplina_prerequisito before insert on disciplina_pre_requisito
for each row
begin
	
	set @quantidade = (select
							count(id)
						from
							disciplina_pre_requisito dp
						where dp.codigo_disciplina = new.codigo_disciplina);
    
    if @quantidade >= 3 then
		signal sqlstate '45000' set message_text = 'Uma disciplina deve ter no máximo 3 pré-requisitos.';
	end if;
    
end;//
delimiter ;
