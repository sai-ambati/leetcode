# Write your MySQL query statement below

with cte as(
    select e.employee_id
    from Employees e 
    join Salaries s 
    on e.employee_id = s.employee_id
)

select employee_id 
from Employees
where employee_id not in(select * from cte)

union all 

select employee_id 
from Salaries
where employee_id not in(select * from cte)

order by employee_id
