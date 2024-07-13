CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
    with cte as(
        select *, dense_rank() over(order by salary desc) as den_rank
        from Employee
    )
    select distinct salary
    from cte
    where den_rank = N

  );
END
