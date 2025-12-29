package org.kas.demos.Prac.CoderpatQuest.DAY32_06_11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks  =marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", marks=" + marks +
               '}';
    }
}

public class StudentAnalysis {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 95),
            new Student("Bob", 88),
            new Student("Charlie", 92),
            new Student("David", 78),
            new Student("Eve", 98),
            new Student("Frank", 85)
        );

        // Find one student with highest marks
        Optional<Student> highestMarksStudent = students.stream()
            .max(Comparator.comparingInt(Student::getMarks));

        highestMarksStudent.ifPresent(student ->
            System.out.println("Student with highest marks: " + student)
        );

        // Find top three students (return name only)
        List<String> topThreeStudentNames = students.stream()
            .sorted(Comparator.comparingInt(Student::getMarks).reversed()) // Sort in descending order of marks
            .limit(3) // Take the top three
            .map(Student::getName) // Map to just their names
            .collect(Collectors.toList()); // Collect into a List

        System.out.println("Top three students by name: " + topThreeStudentNames);
    }
}