# Write your MySQL query statement below

with cte as(
        select *,
    min(order_date) over(partition by customer_id) as first_order_date,
    case
    when order_date = customer_pref_delivery_date
    then 'immediate' 
    else 'scheduled'
    end as del_type
    from Delivery
),

cte2 as(

    select 
    sum(
        case
        when del_type = 'immediate'
        then 1
        else 0
        end
    ) as immediate_order_count,
    count(*) as total_order_count
    from cte
    where order_date = first_order_date
)

select round((immediate_order_count/total_order_count)*100 , 2) as immediate_percentage
from cte2
