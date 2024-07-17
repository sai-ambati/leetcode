select distinct p.product_id ,p.product_name 
FROM Sales s
JOIN Product p
ON s.product_id = p.product_id
where sale_date  between '2019-01-01' and '2019-03-31' and s.product_id not in(
    select distinct product_id
    from Sales
    where sale_date < '2019-01-01' or sale_date > '2019-03-31'
)
