# Write your MySQL query statement below

select *
from (
    select distinct employee_id,
    if(primary_flag = 'Y', department_id,
    if((count(*) over(partition by employee_id)) =1, department_id, null)) as department_id
    from Employee
) tbl
where department_id is not null;
