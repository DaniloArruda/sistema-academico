select 
	a.cpf,
    a.nome,
    c.nome as curso,
    c.carga_horaria as carga_horaria_curso,
    sum(dc.carga_horaria) as carga_horaria_cumprida
from
	aluno a
inner join matricula m on m.codigo_aluno = a.codigo
inner join historico_matricula hm on m.codigo = hm.codigo_matricula
inner join disciplina_curso dc on hm.codigo_curso = dc.codigo_curso and hm.codigo_disciplina = dc.codigo_disciplina
inner join curso c on c.codigo = dc.codigo_curso
group by
	a.cpf,
    a.nome,
    c.nome,
    c.carga_horaria
having carga_horaria_cumprida > (c.carga_horaria/3);