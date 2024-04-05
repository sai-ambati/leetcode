# Write your MySQL query statement below

with tbl as(
    select *
    from Sales 
    where product_id not in(
        select product_id from Sales 
        where sale_date < '2019-01-01' or sale_date> '2019-03-31'
    )
)

select distinct p.product_id, p.product_name
from Product p 
join tbl s 
on p.product_id = s.product_id





