SELECT COUNT(c.FISH_TYPE) AS FISH_COUNT, n.FISH_NAME 
FROM FISH_INFO AS c
INNER JOIN FISH_NAME_INFO AS n
ON c.FISH_TYPE = n.FISH_TYPE
GROUP BY n.FISH_NAME
ORDER BY FISH_COUNT DESC;