# Write your MySQL query statement below
with cte as(
    select *,
    dense_rank() over(partition by departmentId order by salary desc) as den_rank
    from Employee
)

select d.name as Department, c.name as Employee, c.salary as Salary
from Department d 
join cte c 
on d.id = c.departmentId
where c.den_rank = 1 

