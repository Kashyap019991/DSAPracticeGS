package org.kas.demos.Prac.CoderpatQuest.DAY9_26_09;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
public class StudentAverageMarks {
    /**
     * You are given a 2D array of student names and their marks.
     * Some students may appear multiple times with different marks.
     *
     * Write a method to compute the average marks for each student
     * using Java Streams and return a Map<String, Double>.
     *
     * Input:
     * String[][] marks = {
     *     {"Bobby", "87"},
     *     {"Charles", "100"},
     *     {"Eric", "64"},
     *     {"Charles", "22"}
     * };
     *
     * Expected Output:
     * Bobby -> 87.0
     * Charles -> 61.0
     * Eric -> 64.0
     *
     * Handle edge cases:
     * - Negative marks (ignore such entries).
     * - Non-numeric entries (skip those).
     * - Empty arrays (return empty map).
     */

    /**
     * Computes the average marks for each student from a 2D array of student names and their marks.
     * Handles negative marks (ignores them), non-numeric entries (skips them), and empty arrays (returns an empty map).
     *
     * @param marks A 2D array where each inner array contains a student name and their mark as strings.
     * @return A Map where the key is the student's name and the value is their average mark.
     */
    /*
    public static Map<String, Double> calculateAverageMarks(String[][] marks) {
        if (marks == null || marks.length == 0) {
            return Map.of(); // Return an empty map for empty or null input
        }

        return Arrays.stream(marks)
                .filter(entry -> entry != null && entry.length == 2) // Ensure valid entry format
                .map(entry -> {
                    String name = entry[0];
                    String markStr = entry[1];
                    try {
                        int mark = Integer.parseInt(markStr);
                        if (mark >= 0) { // Ignore negative marks
                            return new StudentMark(name, mark);
                        }
                    } catch (NumberFormatException e) {
                        // Non-numeric entry, return null to filter out later
                    }
                    return null;
                })
                .filter(Objects::nonNull) // Filter out invalid entries (nulls from parsing errors or negative marks)
                .collect(Collectors.groupingBy(
                        StudentMark::getName,
                        Collectors.averagingDouble(StudentMark::getMark)
                ));
    }
*/
    public static Map<String, Double> calculateAverageMarks(String[][] marks) {
        if (marks == null || marks.length == 0) {
            return Map.of(); // Return an empty map for empty or null input
        }

        return Arrays.stream(marks)
                .filter(entry -> entry != null && entry.length == 2) // Ensure valid entry format
                .map(entry -> {
                    String name = entry[0];
                    String markString = entry[1];
                    try {
                        double mark = Double.parseDouble(markString);
                        if (mark >= 0) { // Ignore negative marks
                            return Map.entry(name, mark);
                        }
                    } catch (NumberFormatException e) {
                        // Ignore non-numeric entries
                    }
                    return null; // Return null for invalid entries
                })
                .filter(Objects::nonNull) // Filter out null entries (invalid marks)
                .collect(Collectors.groupingBy(
                        entry -> entry.getKey(),
                        Collectors.averagingDouble(entry -> entry.getValue())
                ));
    }
    // Helper class to hold student name and mark
    private static class StudentMark {
        private final String name;
        private final int mark;

        public StudentMark(String name, int mark) {
            this.name = name;
            this.mark = mark;
        }

        public String getName() {
            return name;
        }

        public int getMark() {
            return mark;
        }
    }

    public static void main(String[] args) {
        String[][] marks1 = {
                {"Bobby", "87"},
                {"Charles", "100"},
                {"Eric", "64"},
                {"Charles", "22"},
                {"Alice", "-10"}, // Negative mark
                {"David", "abc"}  // Non-numeric mark
        };
        Map<String, Double> averageMarks1 = calculateAverageMarks(marks1);
        System.out.println("Average Marks 1: " + averageMarks1);
        // Expected Output: {Bobby=87.0, Charles=61.0, Eric=64.0}

        String[][] marks2 = {}; // Empty array
        Map<String, Double> averageMarks2 = calculateAverageMarks(marks2);
        System.out.println("Average Marks 2: " + averageMarks2);
        // Expected Output: {}

        String[][] marks3 = null; // Null array
        Map<String, Double> averageMarks3 = calculateAverageMarks(marks3);
        System.out.println("Average Marks 3: " + averageMarks3);
        // Expected Output: {}
    }
}