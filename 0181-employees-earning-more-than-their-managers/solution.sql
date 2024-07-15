# Write your MySQL query statement below

select E.name as Employee from  
Employee E left join Employee M 
on E.managerId =M.id 
where E.salary > M.salary

