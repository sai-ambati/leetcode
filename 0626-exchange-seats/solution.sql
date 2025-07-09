# Write your MySQL query statement below


select t1.id, t2.student
from Seat t1 
join Seat t2
on 
    case
        when t1.id % 2 = 0
        then t1.id = t2.id+1
        when t1.id = (select count(*) from Seat)
        then t1.id = t2.id
        else t1.id = t2.id-1
    end
order by t1.id
