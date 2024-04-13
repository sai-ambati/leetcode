# Write your MySQL query statement below
with cte1 as(
    select
    case
    when income < 20000
    then 'Low Salary'
    when income <= 50000
    then 'Average Salary'
    else 'High Salary'
    end as category,
    count(1) as accounts_count
    from Accounts
    group by 1
),
cte2 as(
    select 'Low Salary' as category
    union
    select 'Average Salary'
    union
    select 'High Salary'
)

select cte2.category, ifnull(accounts_count, 0) as accounts_count
from cte2 
left join cte1 
on cte2.category = cte1.category


