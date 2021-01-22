# Write your MySQL query statement below
SELECT a.Name as Employee
FROM Employee a JOIN Employee b
ON a.ManagerId = b.Id
AND a.Salary > b.Salary
