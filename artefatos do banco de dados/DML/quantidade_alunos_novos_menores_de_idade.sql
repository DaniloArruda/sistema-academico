select 
	a.*
from
	aluno a
inner join matricula m on a.codigo = m.codigo_aluno
left join historico_matricula hm on m.codigo = hm.codigo_matricula
where 
	hm.codigo_matricula is null
    and year(a.data_nascimento) > 2000;