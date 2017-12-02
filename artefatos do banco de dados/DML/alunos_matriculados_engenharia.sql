select aluno.*
from aluno
inner join matricula on aluno.codigo = matricula.codigo_aluno
inner join curso on matricula.codigo_curso = curso.codigo
where
	curso.nome like 'Engenharia%'
order by
	aluno.nome