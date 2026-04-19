# Write your MySQL query statement below


select a1.machine_id, 

-- a1.process_id, a1.activity_type, a1.timestamp, a2.activity_type, a2.timestamp, 

round(avg(a1.timestamp - a2.timestamp), 3) as processing_time

from Activity a1
join Activity a2 

on a1.machine_id = a2.machine_id and a1.process_id = a2.process_id and 
a1.activity_type = 'end' and a2.activity_type = 'start'

group by a1.machine_id

order by a1.machine_id, a1.process_id
