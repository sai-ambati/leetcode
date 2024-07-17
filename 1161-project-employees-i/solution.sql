# Write your MySQL query statement below

select P.project_id,ROUND(sum(E.experience_years)/count(*),2) AS average_years 
from Project P join Employee E
using (employee_id )
Group by P.project_id 
