select 
	*
from 
	matricula_turma mt
right join matricula m on mt.codigo_matricula = m.codigo
inner join aluno a on m.codigo_aluno = a.codigo
inner join endereco e on a.codigo = e.codigo_aluno
where e.cidade = 'Recife';