# Write your MySQL query statement below
# Write your MySQL query statement below

select u.user_id as buyer_id, u.join_date, count(o.order_id) orders_in_2019
from Users u
left join Orders o on u.user_id = o.buyer_id and date_format(o.order_date, '%Y') = '2019'
group by 1
