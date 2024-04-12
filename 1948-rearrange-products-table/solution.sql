# Write your MySQL query statement below
with cte1 as(
    select product_id, 
    'store1' as store,
    store1 as price
    from Products
),

cte2 as(
    select product_id, 
    'store2' as store,
    store2 as price
    from Products
),

cte3 as(
    select product_id, 
    'store3' as store,
    store3 as price
    from Products
),

cte4 as(
    select * from cte1
    union all
    select * from cte2
    union all 
    select * from cte3
)
select * from cte4
where price is not null


