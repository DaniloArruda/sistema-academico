DELIMITER $$
DROP PROCEDURE IF EXISTS fechar_turma $$
CREATE PROCEDURE fechar_turma(in curso int, in disciplina int, in professor int)
BEGIN
	declare done int default false;
	declare codigo_turma_atual, matricula_aluno, v_ano, v_semestre int;
    
    declare cur1 cursor for ( 
								select codigo_matricula 
								from intencao_disciplina 
								where 
									codigo_curso = curso 
									and codigo_disciplina = disciplina
							);
    
    declare continue handler for not found set done = true;
	
    -- call get_periodo_atual(v_ano, v_semestre);
    set @data_atual = now();
    set @ano = year(@data_atual);
    set @mes = month(@data_atual);
    
    if (@mes <= 6) then
		set @semestre = 1;
	else
		set @semestre = 2;
	end if;
    
    insert into turma (ano, semestre, codigo_professor, codigo_curso, codigo_disciplina) values (@ano, @semestre, professor, curso, disciplina);
    select max(codigo) into codigo_turma_atual from turma;
    
    open cur1;
    loop_intencao_disciplina: loop
		fetch cur1 into matricula_aluno;
        if done then 
			leave loop_intencao_disciplina; 
		end if;
        
        insert into matricula_turma (codigo_turma, codigo_matricula) values (codigo_turma_atual, matricula_aluno);
        insert into desempenho (codigo_matricula, codigo_curso, codigo_disciplina, ano, semestre) 
        values (matricula_aluno, curso, disciplina, @ano, @semestre);
    end loop;    
    
    
    delete from intencao_disciplina
    where 
		codigo_curso = curso
        and codigo_disciplina = disciplina;
END $$
DELIMITER ;