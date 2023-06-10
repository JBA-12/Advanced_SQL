create view output as
select id, sum(total)/sum(credits) as op
from cgpa
group by id
order by op desc;