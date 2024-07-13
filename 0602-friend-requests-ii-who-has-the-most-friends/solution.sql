# Write your MySQL query statement below

with cte as(
    select *
    from RequestAccepted

    union all

    select accepter_id, requester_id, accept_date
    from RequestAccepted
)

select requester_id as id, count(accepter_id) as num
from cte
group by requester_id
order by num desc
limit 1;
