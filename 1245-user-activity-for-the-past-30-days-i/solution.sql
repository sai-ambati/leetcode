# Write your MySQL query statement below
select *
from(
select activity_date as day, 
count(distinct user_id) as active_users
from Activity
group by activity_date
having datediff('2019-07-27' , activity_date ) < 30
) tbl
where day <= '2019-07-27'
-- where activity_date <= '2019-07-27'
-- or datediff(activity_date, '2019-07-27') <30


