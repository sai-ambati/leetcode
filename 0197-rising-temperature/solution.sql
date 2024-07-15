# Write your MySQL query statement below
select id from 
(select id ,recordDate,temperature, 
lag(temperature ) over( order by recordDate ) as prev,
lag(recordDate) over (order by recordDate) as prevday
from Weather )  wtr
where temperature>prev and datediff(prevday,recordDate) = -1
