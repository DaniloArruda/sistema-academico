select
	d.codigo,
    d.nome
from 
	disciplina d
inner join disciplina_curso dc on d.codigo = dc.codigo_disciplina
left join turma t 
	on dc.codigo_disciplina = t.codigo_disciplina 
    and t.ano = year(now()) 
    and t.semestre = (
						select case
							when month(now()) > 6 then 2
                            else 1 
						end
					)
where
	t.codigo is null;