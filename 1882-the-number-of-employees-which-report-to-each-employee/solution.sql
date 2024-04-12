# Write your MySQL query statement below

select m.employee_id, m.name, count(*) as reports_count, 
case
when ceil(avg(e.age))-avg(e.age) >0.5
then floor(avg(e.age))
else ceil(avg(e.age)) end as average_age
from Employees e
join Employees m 
on e.reports_to = m.employee_id
group by m.employee_id, m.name
order by m.employee_id
