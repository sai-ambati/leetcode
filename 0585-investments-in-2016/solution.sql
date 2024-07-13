# Write your MySQL query statement below

with cte1 as(
    select distinct i1.pid
    from Insurance i1
    join Insurance i2
    on i1.lat = i2.lat and i1.lon = i2.lon and i1.pid != i2.pid
),

cte2 as(
    select distinct i1.pid
    from Insurance i1
    join Insurance i2
    on i1.tiv_2015 = i2.tiv_2015 and i1.pid != i2.pid
)

select round(sum(tiv_2016), 2) as tiv_2016
from Insurance
where pid in (
    select *
    from cte2
) and pid not in (
    select *
    from cte1
)
