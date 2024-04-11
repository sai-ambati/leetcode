# Write your MySQL query statement below
select u.name , t.balance
from Users u 
join (
select account, sum(amount) as balance
from Transactions 
group by account
) t
on u.account = t.account
where balance >10000


