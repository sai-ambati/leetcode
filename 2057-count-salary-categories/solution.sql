# Write your MySQL query statement below

with bankType as(
    select 'Low Salary' as type
    union all
    select 'Average Salary' as type
    union all
    select 'High Salary' as type
),

modifiedAccounts as(
    select account_id,
    case
        when income < 20000 then 'Low Salary'
        when income between 20000 and 50000 then 'Average Salary'
        else 'High Salary'
    end as accountType
    from Accounts
)

select b.type as category,
count(distinct m.account_id) as accounts_count
from modifiedAccounts m
right join bankType b
on b.type = m.accountType
group by b.type
