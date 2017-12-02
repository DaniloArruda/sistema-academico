delimiter $
drop trigger if exists trigger_validar_qtd_maxima_aluno_turma $
create trigger trigger_validar_qtd_maxima_aluno_turma before insert on turma  
for each row
begin
	 
	set @quantidade = (select
							count(*)
						from
							intencao_disciplina
						where 
							codigo_disciplina = new.codigo_disciplina);

    
    if @quantidade > 30 then
		signal sqlstate '45000' set message_text = 'Uma turma deve ter no máximo 30 alunos.';
	end if;
end $
delimiter ;