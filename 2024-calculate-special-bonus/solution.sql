# Write your MySQL query statement below

select employee_id,
if(employee_id %2 = 1 and lower(name) not like 'm%', salary, 0) as bonus
from Employees
order by employee_id;
