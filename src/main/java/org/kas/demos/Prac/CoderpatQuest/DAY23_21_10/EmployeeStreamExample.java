package org.kas.demos.Prac.CoderpatQuest.DAY23_21_10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", department='" + department + '\'' + ", salary=" + salary + '}';
    }
}

public class EmployeeStreamExample {

    public static void main(String[] args) {
        // Sample data
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "Tech", 120000),
            new Employee("Bob", "Tech", 150000),
            new Employee("Charlie", "Sales", 90000),
            new Employee("David", "Tech", 110000),
            new Employee("Eve", "Marketing", 100000),
            new Employee("Frank", "Tech", 140000)
        );

        List<String> techEmployeeNames = employees.stream()
            // 1. Filter for employees in the "Tech" department
            .filter(employee -> "Tech".equals(employee.getDepartment()))
            // 2. Sort by salary in descending order
            .sorted(Comparator.comparing(Employee::getSalary).reversed())
            // 3. Map to get only the names
            .map(Employee::getName)
            // 4. Collect the results into a new List
            .collect(Collectors.toList());

        System.out.println("Tech employee names sorted by salary (descending):");
        techEmployeeNames.forEach(System.out::println);
    }
}
