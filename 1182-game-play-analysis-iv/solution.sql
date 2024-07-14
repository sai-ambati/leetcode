# Write your MySQL query statement below

with cte as(
    select player_id, event_date,
    min(event_date) over(partition by player_id) as first_login,
    lead(event_date) over(partition by player_id order by event_date) as next_day
    from Activity
),

cte2 as(
    select count(distinct player_id)
    from Activity
),
cte3 as(
    select count(player_id)
    from cte
    where event_date = first_login and datediff(next_day, first_login) = 1
)

select round((select * from cte3)/(select * from cte2), 2) as fraction;

