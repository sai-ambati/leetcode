# Write your MySQL query statement below
select u.name,
case 
when tbl.travelled_distance is null then 0
else tbl.travelled_distance end as travelled_distance
from users u 
left join (
select distinct user_id, sum(distance) over(partition by user_id) as travelled_distance
from Rides
) tbl 

on u.id = tbl.user_id

order by travelled_distance desc, u.name


