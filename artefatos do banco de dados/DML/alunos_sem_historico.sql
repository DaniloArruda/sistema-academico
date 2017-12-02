select aluno.*
from matricula_historico
right join matricula
	on historico_matricula.codigo_matricula = matricula.codigo
inner join aluno on matricula.codigo_aluno = aluno.codigo
where
	historico_matricula.matricula is NULL
order by aluno.nome