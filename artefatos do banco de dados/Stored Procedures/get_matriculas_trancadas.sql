DELIMITER $$
drop procedure if exists get_matriculas_trancadas $$
CREATE PROCEDURE get_matriculas_trancadas()
BEGIN
	select a.*, m.codigo as codigo_matricula, m.matricula, m.coeficiente_rendimento, m.situacao, m.codigo_aluno, m.codigo_curso
	from aluno a
	inner join matricula m on a.codigo = m.codigo_aluno
    where m.situacao = 2;
END $$

DELIMITER ;