package org.kas.demos.Prac.CoderpatQuest.DAY26_29_10;

import java.util.List;

public class Ss {
    int a = 10;

    void call(int a) {
        a = a + 10;
    }

    public static void main(String args[]) {
        Ss s = new Ss();
        System.out.println("Before" + s.a); // → Before10
        s.call(50510);
        System.out.println("After" + s.a); // →After10
/*
//Write a Stream expression to get the names of all employees in the "Tech"
//department sorted by descending salary along with edge cases


        List<String> techEmployeeNames = employees.stream()
                .filter(employee -> "Tech".equals(employee.getDepartment()))
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getName)
                .collect(Collectors.toList());
*/
    }

}
