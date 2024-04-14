# Write your MySQL query statement below

select product_id, first_year, quantity, price
from(

    select s.*, min(year) over(partition by s.product_id) as first_year, p.product_name
    from Sales s
    join Product p
    on s.product_id = p.product_id
) tbl
where year=first_year

