alter table takes add gp INT;
update takes set gp = case
                           when grade = 'A+' then 10
						   when grade = 'A ' then 9
						   when grade = 'A-' then 8
						   when grade = 'B+' then 7
						   when grade = 'B ' then 6
						   when grade = 'B-' then 5
						   when grade = 'C+' then 4
						   when grade = 'C ' then 3
						   when grade = 'C-' then 2
						  end ;

create view cgpa as
select takes.id, course_id, gp, credits, gp*credits as total, student.dept_name
from takes natural join course, student
where takes.id = student.id
order by id;					  