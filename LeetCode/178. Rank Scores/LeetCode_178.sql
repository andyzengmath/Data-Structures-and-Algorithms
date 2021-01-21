# Write your MySQL query statement below
# Slow
SELECT A.Score as Score, (SELECT COUNT(DISTINCT B.Score) FROM Scores B WHERE B.Score >= A.Score) as 'Rank'
FROM Scores A
ORDER BY A.Score DESC