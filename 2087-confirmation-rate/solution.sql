# Write your MySQL query statement below

with cte as(
        select s.user_id, c.action,
    sum(
        case
        when action = 'confirmed'
        then 1
        else 0
        end
    ) over(partition by s.user_id) as confirmed,
    count(*) over(partition by s.user_id) as total
    from Signups s
    left join Confirmations c
    on s.user_id = c.user_id
)


select distinct user_id,
round(confirmed/total, 2) as confirmation_rate
from cte

