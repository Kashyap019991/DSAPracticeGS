package org.kas.demos.Prac.CoderpatQuest.DAY10_29_09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
/*
Given a 2d array of student name and marks. Return maximum average in the data provided.
data - [["ABC", 80], ["DEF", 90], ["EFG", 70], ["ABC", 100]]
 */
public class MaxAverageStream {

    public static int findMaxAverage(String[][] data) {
        // Handle edge case of an empty or invalid array
        if (data == null || data.length == 0) {
            return 0;
        }

        // Use streams to process the data
        Map<String, Double> studentAverages = Arrays.stream(data)
            // Group the data by student name (the first element of the array)
            .collect(Collectors.groupingBy(
                entry -> entry[0],
                // For each name, calculate the average of the marks
                Collectors.averagingDouble(entry -> Double.parseDouble(entry[1]))
            ));

        // Find the maximum average from the map values
        return studentAverages.values().stream().
                map(entry -> (int)Math.floor(entry))
            .max(Comparator.naturalOrder())
            .orElse(0);
    }

    public static void main(String[] args) {
        String[][] studentMarks = {
            {"ABC", "80"},
            {"DEF", "90"},
            {"EFG", "70"},
            {"ABC", "100"}
        };

        int result = findMaxAverage(studentMarks);
        System.out.println("The maximum average score is: " + result);
    }
}
