# Write your MySQL query statement below
with cte as(
select *,
count(*) over(partition by employee_id) as emp_count
from Employee
)

select employee_id, department_id
from cte
where emp_count = 1 or primary_flag = 'Y'
-- having count(*) over(partition by employee_id)=1
