-- https://www.hackerrank.com/challenges/occupations

SELECT
  MIN(CASE WHEN Occupation = 'Doctor' THEN Name ELSE NULL END) AS Doctor,
  MIN(CASE WHEN Occupation = 'Professor' THEN Name ELSE NULL END) AS Professor,
  MIN(CASE WHEN Occupation = 'Singer' THEN Name ELSE NULL END) AS Singer,
  MIN(CASE WHEN Occupation = 'Actor' THEN Name ELSE NULL END) AS Actor
FROM (
  SELECT o.Name, o.Occupation, (SELECT COUNT(DISTINCT Name) FROM OCCUPATIONS o1 WHERE o1.Name < o.Name AND o1.Occupation = o.Occupation) AS n
  FROM OCCUPATIONS o) AS result
GROUP BY n;
