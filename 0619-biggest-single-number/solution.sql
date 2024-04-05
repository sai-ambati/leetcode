# Write your MySQL query statement below
with tbl1 as(
select *
from MyNumbers 
group by num
having count(*) = 1
)

select 
case
when count(*) over() = 0
then null
else max(num)
end as num

from tbl1
