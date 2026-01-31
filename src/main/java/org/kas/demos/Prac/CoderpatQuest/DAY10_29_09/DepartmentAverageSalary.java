package org.kas.demos.Prac.CoderpatQuest.DAY10_29_09;

import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.Date;

class Employee {
    private int employeeId;
    private String name;
    private String departmentName;
    private Date hireDate;
    private double salary;

    public Employee(int employeeId, String name, String departmentName, Date hireDate, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.departmentName = departmentName;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class DepartmentAverageSalary {

    public static void main(String[] args) {
        // Create a list of employee objects
        List<Employee> employees = List.of(
            new Employee(1, "Alice", "Sales", new Date(), 50000.0),
            new Employee(2, "Bob", "Engineering", new Date(), 80000.0),
            new Employee(3, "Charlie", "Sales", new Date(), 60000.0),
            new Employee(4, "David", "Engineering", new Date(), 90000.0),
            new Employee(5, "Eve", "Marketing", new Date(), 75000.0),
            new Employee(6, "Frank", "Sales", new Date(), 55000.0)
        );

        // Group employees by department and calculate the average salary
        Map<String, Double> averageSalariesByDept = employees.stream()
            .collect(Collectors.groupingBy(
                e->e.getDepartmentName(), // The classifier function to group by department name
                Collectors.averagingDouble(e->e.getSalary()) // The downstream collector to calculate the average salary
            ));

        // Print the results
        averageSalariesByDept.forEach((department, avgSalary) ->
            System.out.printf("Department: %-15s | Average Salary: %.2f%n", department, avgSalary)
        );
    }
}
