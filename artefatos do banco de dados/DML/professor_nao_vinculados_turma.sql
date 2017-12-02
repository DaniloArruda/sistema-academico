select 
	* 
from 
	turma t
right join professor p on t.codigo_professor = p.codigo
    and t.ano = year(now())
    and semestre = (
					select case
						when month(now()) > 6 then 2
						else 1 
					end
					)
where
   t.codigo is null;