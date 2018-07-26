-- Ques.1. Write a SQL query to fetch the count of employees working in project 'P1'.

SELECT COUNT(*) FROM EmployeeSalary WHERE Project = 'P1';

--Write a SQL query to fetch employee names having salary greater than or equal to 5000 and less than or equal 10000.

SELECT ed.fullname FROM EmployeeSalary as es WHERE Salary >=500 and salary <= 10000
LEFT OUTER JOIN  EmployeeDetails as ed
ON es.EmpId = ed.EmpId;

-- or
SELECT FullName
FROM EmployeeDetails
WHERE EmpId IN
(SELECT EmpId FROM EmpolyeeSalary
WHERE Salary BETWEEN 5000 AND 10000);

-- or

with e as ( SELECT EmpId FROM EmployeeSalary as es WHERE Salary >=500 and salary <= 10000)


--Ques.10. Write a SQL query to fetch only odd rows from table.  EmployeeSalary

WITH nt as ( SELECT *, Row_Number() OVER(ORDER BY EmpId) AS RowNumber
FROM  EmployeeSalary)

Select * from nt where rowNumber%2 = 1;
;



-- Ques.20. Write SQL query to find the 3rd highest salary from table without using TOP/limit keyword.

SELECT Salary
FROM EmployeeSalary Emp1
WHERE 2 = (
                SELECT COUNT( DISTINCT ( Emp2.Salary ) )
                FROM EmployeeSalary Emp2
                WHERE Emp2.Salary > Emp1.Salary
            );

WITH augsal as (SELECT *,  DENSE_RAN() OVER (  ORDER BY Salary DESC) as rank FROM  EmployeeSalary Emp1))
select * from augsalw WHERE rank = 3
;
-- For nth highest salary-

SELECT Salary
FROM EmployeeSalary Emp1
WHERE N-1 = (
                SELECT COUNT( DISTINCT ( Emp2.Salary ) )
                FROM EmployeeSalary Emp2
                WHERE Emp2.Salary > Emp1.Salary

            )
            )

WITH mt as (
    SELECT
        task_id,start_date,end_date,
        CASE
            WHEN ( start_date !=  LAG(end_date, 1) OVER( ORDER BY start_date) )
                THEN concat('pr_',start_date)
            WHEN (LAG(end_date, 1) OVER( ORDER BY start_date)  IS NULL)
                THEN concat('pr_', start_date)
            ELSE ''
        END AS pname
    from
        Projects
    order by start_date, task_id
),
mt2 as (
      SELECT
            task_id,start_date,end_date,
            FIRST_VALUE(pname) OVER(PARTITION BY pname)
        FROM
            mt
       ORDER BY
        start_date, task_id
)
select * from mt2;

