# Write your MySQL query statement below

select next.id
from Weather next
join Weather current 
where datediff(next.recordDate, current.recordDate) = 1 
and next.temperature > current.temperature;
