delimiter $$
drop trigger if exists trigger_limitar_disciplinas_do_aluno_no_periodo $$
create trigger trigger_limitar_disciplinas_do_aluno_no_periodo before insert on matricula_turma
for each row
begin
	declare v_ano, v_semestre int;
    call get_periodo_atual(v_ano, v_semestre);
    
	set @qtd_turmas = (	select count(*) 
						from matricula_turma mt
                        inner join turma t on t.codigo = mt.codigo_turma
						where 
							mt.codigo_matricula = new.codigo_matricula
                            and t.ano = v_ano
                            and t.semestre = v_semestre);
	
    if @qtd_turmas > 7 then
		signal sqlstate '45000' set message_text = 'Um aluno só pode se inscrever em no máximo 7 disciplinas.';
	end if;
    
end $$

delimiter ;