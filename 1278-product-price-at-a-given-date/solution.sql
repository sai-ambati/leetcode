# Write your MySQL query statement below

with cte as(
    select *, if(change_date <= '2019-08-16' , new_price, 10) as price, 
    max(change_date) over(partition by product_id) as recent_date
    from Products
    where change_date <= '2019-08-16'
),
cte2 as(
    select distinct product_id, 10 as price
    from Products
)

select c2.product_id, if(c1.product_id is null, c2.price,c1.price) as price
from cte c1
right join cte2 c2
on c1.product_id = c2.product_id
where change_date = recent_date or c1.product_id is null

