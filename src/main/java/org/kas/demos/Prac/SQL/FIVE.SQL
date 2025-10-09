find the employee(s) with the highest salary in each department

SELECT e.emp_id, e.emp_name, e.dept_id, e.salary

FROM Employee e

INNER JOIN (

    SELECT dept_id, MAX(salary) AS max_sal

    FROM Employee

    GROUP BY dept_id

) AS m

  ON e.dept_id = m.dept_id

     AND e.salary = m.max_sal;



