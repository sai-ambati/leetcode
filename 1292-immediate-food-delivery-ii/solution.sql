# Write your MySQL query statement below

with cte as(
    select *, if(order_date = customer_pref_delivery_date, 'immediate', 'scheduled') as type,
    min(order_date) over(partition by customer_id) as first_order
    from Delivery
)

select round(100*(sum(if(type = 'immediate',1,0))/count(*)), 2) as immediate_percentage
from cte
where order_date = first_order

