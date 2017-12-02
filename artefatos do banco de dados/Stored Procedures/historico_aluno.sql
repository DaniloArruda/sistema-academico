DELIMITER $$
DROP PROCEDURE IF EXISTS historico_aluno $$
CREATE PROCEDURE historico_aluno (IN p_matricula INT)
BEGIN
	select disciplina.codigo, disciplina.nome, historico_matricula.nota_final
	from matricula
	inner join historico_matricula on matricula.codigo = p_matricula
		and matricula.codigo = historico_matricula.codigo_matricula
	inner join disciplina on historico_matricula.codigo_disciplina = disciplina.codigo
	order by disciplina.periodo;
	
END $$
DELIMITER ;