sql Write a query to find duplicate records in a table employee based on emp_id



SELECT emp_id, COUNT(emp_id) AS count
FROM employee
GROUP BY emp_id
HAVING COUNT(emp_id) > 1;


SELECT *
FROM employee
WHERE emp_id IN (
  SELECT emp_id
  FROM employee
  GROUP BY emp_id
  HAVING COUNT(emp_id) > 1
);