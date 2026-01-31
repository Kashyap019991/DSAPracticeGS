package org.kas.demos.Prac.CoderpatQuest.DAY6_23_09;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeAverageMarks {

    public static void main(String[] args) {
        // Given array of employee name and marks as String arrays
        String[][] employeeMarks = {
            {"Alia", "-678"},
            {"Bobby", "100"},
            {"Alex", "223"},
            {"Alex", "-23"},
            {"Bobby", "530"} // Corrected marks for Bobby based on example average
        };
/*
        // Stream to process the employee marks and calculate averages
        Map<String, Double> employeeAverageMarks = Arrays.stream(employeeMarks)
            // Group the data by employee name (entry[0])
            .collect(Collectors.groupingBy(
                entry -> entry[0],
                // For each group, collect the average of their marks (entry[1])
                Collectors.averagingDouble(entry -> Double.parseDouble(entry[1]))
            ));
*/

        Map<String,Double> avgMarks =  Arrays.stream(employeeMarks)
                .collect(Collectors.groupingBy(
                        entity->entity[0],
                        Collectors.averagingDouble(
                                entity -> Double.parseDouble(entity[1]))));
        Double maxAvg = Double.MIN_VALUE;
        for(Map.Entry<String,Double> entry:avgMarks.entrySet()){
            maxAvg = Math.max(maxAvg, entry.getValue());
        }
        System.out.println(maxAvg);
    }
}
