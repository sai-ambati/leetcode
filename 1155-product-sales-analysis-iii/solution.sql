# Write your MySQL query statement below

with cte as(
    select *, min(year) over(partition by product_id) as first_year
    from Sales
)

select product_id, first_year, quantity, price
from cte
where year = first_year;
