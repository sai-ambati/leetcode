# Write your MySQL query statement below

with cte as(
    select *,
    sum(Weight) over(order by turn) as Total_weight
    from Queue
)

select person_name from cte
where Total_weight <= 1000
order by Total_weight desc
limit 1
