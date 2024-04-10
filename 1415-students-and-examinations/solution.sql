# Write your MySQL query statement below

select stu.student_id, stu.student_name, sub.subject_name,
-- sum(case when e.subject_name is not null then 1 else 0 end) as attended_exams
-- sum(case when e.student_id is null and e.subject_name is null then 0 else 1 end) as attended_exams
count(e.student_id ) as attended_exams
from Students stu
cross join Subjects sub

left join Examinations e 
on stu.student_id = e.student_id and sub.subject_name = e.subject_name
group by stu.student_id, stu.student_name, sub.subject_name
order by stu.student_id, sub.subject_name
