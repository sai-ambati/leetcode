# Write your MySQL query statement below

select id
from(
    select *,
    lag(recordDate) over(order by recordDate) as prevDay,
    lag(temperature) over(order by recordDate) as prevDayTemp
    from Weather
) tbl
where dateDiff(recordDate, prevDay) = 1 and temperature > prevDayTemp;
