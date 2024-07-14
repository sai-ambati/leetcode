# Write your MySQL query statement below

select person_name
from (
    select person_name, turn, sum(weight) over(order by turn) as mov_sum
    from Queue
    order by turn
) tbl
where mov_sum <= 1000
order by turn desc
limit 1;
