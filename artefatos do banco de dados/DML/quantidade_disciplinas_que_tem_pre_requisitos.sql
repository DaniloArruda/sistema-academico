select 
	count(*)
from disciplina d
left join disciplina_pre_requisito dpr on d.codigo = dpr.codigo_disciplina
left join disciplina d2 on dpr.codigo_disciplina_pre_requisito = d2.codigo
where dpr.codigo_disciplina_pre_requisito is not null;