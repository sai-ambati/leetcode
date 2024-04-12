# Write your MySQL query statement below

select machine_id, round(avg(timestamp-prev_time),3) as processing_time
from(
select *, lag(timestamp) over(partition by machine_id,process_id order by activity_type) as prev_time
from Activity
) tbl
where activity_type = 'end'

group by machine_id

