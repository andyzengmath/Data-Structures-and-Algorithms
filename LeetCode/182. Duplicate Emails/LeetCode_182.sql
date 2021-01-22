# Write your MySQL query statement below
SELECT Email FROM 
(SELECT Email, COUNT(Email) as num
 FROM Person
 GROUP BY Email)
as statistic
WHERE num > 1
;