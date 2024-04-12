# Write your MySQL query statement below
with cte as(
    select *,
    lag(people) over(order by id) as prev_day,
    lag(people, 2) over(order by id) as prev_prev_day,
    lead(people) over(order by id) as next_day,
    lead(people, 2) over(order by id) as next_next_day
    from Stadium
)

select id, visit_date, people
from cte

where prev_prev_day>=100 and prev_day >=100 and people >=100 or
prev_day>=100 and people>=100 and next_day>=100 or
people>=100 and next_day>=100 and next_next_day>=100

order by visit_date

