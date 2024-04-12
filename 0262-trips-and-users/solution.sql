# Write your MySQL query statement below
with cte as(
    select users_id as banned_user
    from Users
    where banned = 'Yes'
),
cte2 as(
    select *,
    case
    when client_id = any(select * from cte) or driver_id = any(select * from cte)
    then 'banned'
    else 'unbanned' 
    end as user_status
    from Trips
),

cte3 as(
    select *,
    sum(
        case
        when status in ('cancelled_by_driver', 'cancelled_by_client') and user_status = 'unbanned'
        then 1
        else 0
        end 
    ) over(partition by request_at) as cancelled_rides,
    sum(
        case 
        when user_status = 'unbanned'
        then 1
        else 0
        end
    ) over(partition by request_at) as total_rides
    from cte2
)

select distinct request_at as Day,
round(cancelled_rides/total_rides, 2) as 'Cancellation Rate'
from cte3
where request_at between '2013-10-01' and '2013-10-03' and round(cancelled_rides/total_rides, 2) is not null





-- cte3 as(
--     select request_at as Day,
--     sum(
--         case
--         when status in ('cancelled_by_driver', 'cancelled_by_client') and user_status = 'unbanned'
--         then 1
--         else 0
--         end 
--     ) as cancelled_rides,
--     sum(
--         case 
--         when user_status = 'unbanned'
--         then 1
--         else 0
--         end
--     ) as total_rides
--     from cte2
--     group by request_at
-- )

-- select Day,
-- round(cancelled_rides/total_rides, 2) as 'Cancellation Rate'
-- from cte3
-- where Day between '2013-10-01' and '2013-10-03' and round(cancelled_rides/total_rides, 2) is not null
