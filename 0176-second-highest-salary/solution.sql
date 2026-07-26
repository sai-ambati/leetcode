# Write your MySQL query statement below

with cte as(
    select *, dense_rank() over(order by salary desc) as sal_rank
    from Employee
)

select (
    select distinct salary
    from cte
    where sal_rank = 2
)  as SecondHighestSalary
