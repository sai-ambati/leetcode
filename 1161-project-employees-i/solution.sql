# Write your MySQL query statement below

with tbl1 as(
    select p.project_id, p.employee_id, e.name, e.experience_years
    from Project p 
    join Employee e 
    on p.employee_id = e.employee_id
)

select project_id,
round(avg(experience_years), 2) as average_years
from tbl1
group by project_id
