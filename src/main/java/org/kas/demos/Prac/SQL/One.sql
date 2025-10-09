 CREATE TABLE Department (
       DeptID INT PRIMARY KEY,
       DeptName VARCHAR(50)
   );

   CREATE TABLE Employee (
       EmpID INT PRIMARY KEY,
       EmpName VARCHAR(50),
       Salary DECIMAL(10,2),
       DeptID INT,
       FOREIGN KEY (DeptID) REFERENCES Department(DeptID)
   );

   /*
   * Write an SQL query to return each department name
   * along with the average salary of employees in that department.
   * Sort the result by average salary descending.
   */

OUTPUT:
   select DeptName, avg(Salary) as avgSal from Employee e left JOIN Department d
   on e.DeptId=d.DeptID Group by DeptName ORDER By avgSal DESC;