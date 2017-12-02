DELIMITER $$
drop procedure if exists get_disciplinas_do_periodo $$
CREATE PROCEDURE get_disciplinas_do_periodo (in cpf_aluno int)
BEGIN
	select *
	from aluno a
	inner join matricula m on a.codigo = m.codigo_aluno
	inner join desempenho d on m.codigo = d.codigo_matricula
    where a.cpf = cpf_aluno;
END $$

DELIMITER ;