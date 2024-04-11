# Write your MySQL query statement below
select * from(
select r.contest_id, round((count(*)/total_users)*100, 2) as percentage from (
select user_id, count(*) over() as total_users
from Users 
) u 

left join Register r
on u.user_id = r.user_id
group by r.contest_id
) tbl
where contest_id is not null
order by percentage desc, contest_id
