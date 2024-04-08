# Write your MySQL query statement below
with cte as(
select distinct p.product_id, p.price, u.units, p.start_date, p.end_date, u.purchase_date
from Prices p 
left join UnitsSold u
on P.product_id = u.product_id
),

cte2 as(
    select *
    from cte
    where purchase_date between start_date and end_date or purchase_date is null
)

select cte2.product_id, 
case 
when units is null then 0
else
round(sum(units*price)/sum(units),2) 
end as average_price
from cte2
group by product_id
-- having purchase_date between start_date and end_date or purchase_date is null

