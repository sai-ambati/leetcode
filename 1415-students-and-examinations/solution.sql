# Write your MySQL query statement below

with cte as(
    select *
    from Students,Subjects
    order by student_id, subject_name
),
cte2 as(
    select *, count(subject_name) as attended_exams
    from Examinations
    group by student_id, subject_name
)

select c1.student_id, c1.student_name, c1.subject_name, ifnull(c2.attended_exams, 0) as attended_exams
from cte c1
left join cte2 c2
on c1.student_id = c2.student_id and c1.subject_name = c2.subject_name
order by c1.student_id, c1.subject_name
