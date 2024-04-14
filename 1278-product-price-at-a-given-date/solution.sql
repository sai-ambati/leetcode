# Write your MySQL query statement below

with cte1 as(
        select distinct product_id
    from Products

),

cte2 as(
    select *, dense_rank() over(partition by product_id order by change_date desc) as den_rank
    from Products
    where change_date <= '2019-08-16'
)

select cte1.product_id, ifnull(new_price, 10) as price
from cte1
left join cte2
on cte1.product_id = cte2.product_id and cte2.den_rank = 1
