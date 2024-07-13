# Write your MySQL query statement below

with cte as(
    select d.name as Department, e.name as Employee, e.salary as salary,
    max(salary) over(partition by departmentId) as max_salary
    from Employee e
    join Department d
    on e.departmentId = d.id
)
select Department, Employee, salary
from cte
where salary = max_salary;
