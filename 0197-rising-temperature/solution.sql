# Write your MySQL query statement below

with cte as(
    select *,
    lag(recordDate) over(order by recordDate) as prev_date,
    lag(temperature) over(order by recordDate) as prev_temp
    from Weather
)

select id from cte
where datediff(recordDate, prev_date) = 1 
and temperature > prev_temp
