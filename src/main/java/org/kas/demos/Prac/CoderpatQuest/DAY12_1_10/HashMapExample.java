package org.kas.demos.Prac.CoderpatQuest.DAY12_1_10;
// In your main method or another class:
import java.util.HashMap;
import java.util.Map;

class Student {
    private final int id;
    private final String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
}


public class HashMapExample {
    public static void main(String[] args) {
        Map<Student, String> studentGrades = new HashMap<>();

        Student s1 = new Student(1, "Alice");
        Student s2 = new Student(2, "Bob");
        Student s3 = new Student(1, "Alice"); // Same as s1 based on equals()

        studentGrades.put(s1, "A");
        studentGrades.put(s2, "B");

        System.out.println("Grade for Alice (s1): " + studentGrades.get(s1));
        System.out.println("Grade for Alice (s3): " + studentGrades.get(s3)); // Retrieves correctly due to equals() and hashCode()
    }
}