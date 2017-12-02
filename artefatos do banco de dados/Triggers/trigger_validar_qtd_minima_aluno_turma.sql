delimiter $
create trigger validar_qtd_minima_aluno_turma before insert on turma
for each row
begin
	
	set @quantidade = (select
							count(*)
						from
							intencao_disciplina
						where 
							codigo_disciplina = new.codigo_disciplina);

    
    if @quantidade < 10 then
		signal sqlstate '45000' set message_text = 'Uma turma deve ter no mínimo 10 alunos.';
	end if;
    
end; $
delimiter ;
