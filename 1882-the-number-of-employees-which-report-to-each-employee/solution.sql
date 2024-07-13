# Write your MySQL query statement below

select t2.employee_id, t2.name, count(*) as reports_count, round(avg(t1.age)) as average_age
from Employees t1
join Employees t2
on t2.employee_id = t1.reports_to
group by t2.employee_id, t2.name
order by t2.employee_id;
