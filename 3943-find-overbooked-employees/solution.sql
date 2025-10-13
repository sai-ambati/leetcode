# Write your MySQL query statement below

with cte as(
    select *, week(meeting_date, 1) as week_no
    from meetings
),

cte2 as(
    select employee_id, week_no, sum(duration_hours) as total_hours
    from cte
    group by employee_id, week_no
    having sum(duration_hours) > 20
),

cte3 as(
    select employee_id, count(*) as meeting_heavy_weeks
    from cte2
    group by employee_id
    having count(*) >= 2
)


    select e.*, c.meeting_heavy_weeks
    from cte3 c
    join employees e
    on e.employee_id = c.employee_id
    order by c.meeting_heavy_weeks desc, employee_name
