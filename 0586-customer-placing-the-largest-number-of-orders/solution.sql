# Write your MySQL query statement below


-- select customer_number 
-- from Orders 
-- where order_number = (
--     select max(order_number)
--     from Orders
-- )


with tbl1 as(
    select distinct customer_number,
    count(*) over(partition by customer_number) as total_orders
    from Orders
),
tbl2 as(
    select *, max(total_orders) over() as max_orders
    from tbl1
)

select customer_number
from tbl2
where total_orders = max_orders

-- select customer_number
-- from Orders
-- group by customer_number
-- having count(*) = max(count(*))

-- select * from tbl2
