# Write your MySQL query statement below

with cte as(
    select distinct player_id,
sum(
    case
    when datediff(event_date, first_login_date) in(0,1)
    then 1
    else 0
    end
) over(partition by player_id) as sum_
from (

    select *,
    min(event_date) over(partition by player_id) as first_login_date
    from Activity

) tbl
)

select round(no_of_cons/total,2) as fraction
from (

    select distinct
    sum(
        case
        when sum_>1
        then 1
        else 0
        end
    ) over() as no_of_cons,
    count(*) over() as total

    from cte
    ) tbl2
