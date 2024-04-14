# Write your MySQL query statement below
with cte as(
    select distinct visited_on, sum(amount) over(partition by visited_on) as amount,
    dense_rank() over(order by visited_on) as den_rank
    from Customer
),
cte2 as(
    select visited_on, den_rank,
    sum(amount) over(order by visited_on rows between 6 preceding and current row) as amount,
    avg(amount) over(order by visited_on rows between 6 preceding and current row) as average_amount
    from cte
)

select visited_on, amount, round(average_amount, 2) as average_amount
from cte2
where den_rank>6
