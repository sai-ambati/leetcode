# Write your MySQL query statement below
with cte as(
    select visited_on, sum(amount) as amount
    from Customer
    group by visited_on
)
select visited_on, amount,
round(average_amount, 2) as average_amount
from (
    select visited_on, sum(amount) over(order by visited_on rows between 6 preceding and current row) as amount,
    avg(amount) over(order by visited_on rows between 6 preceding and current row) as average_amount,
    rank() over(order by visited_on) as rank_
    from cte
) tbl
where rank_>6
order by visited_on
