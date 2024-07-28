# Write your MySQL query statement below

with cte as(
    select *, id-row_number() over(order by id) as rn
    from Stadium
    where people >= 100
),

cte2 as(
    select *, count(*) over(partition by rn) as freq
    from cte
)

select id, visit_date, people
from cte2
where freq>=3
order by visit_date
