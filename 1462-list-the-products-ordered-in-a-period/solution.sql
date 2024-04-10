# Write your MySQL query statement below

with cte as(
select product_id, year_month_, sum(unit) as unit
from (
select *, date_format(order_date, '%Y-%m') as year_month_
from Orders
) as tbl
group by product_id, year_month_
)

select p.product_name, cte.unit
from Products p 
join cte 
on p.product_id = cte.product_id
where cte.year_month_ = '2020-02' and cte.unit>=100
