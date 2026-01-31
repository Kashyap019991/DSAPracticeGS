package org.kas.demos.Prac.CoderpatQuest.DAY6_23_09;

import java.util.HashMap;
import java.util.Map;

/**
 * Finds the maximum average marks from a list of employees.
 */
public class EmployeeAverageFinder {

    /**
     * Finds the maximum average marks from the given array of employees.
     * This method is memory-efficient as it does not store all individual marks,
     * but rather a running sum and count for each employee.
     *
     * Time Complexity: O(N) where N is the total number of entries in the input array.
     *                  This is because we iterate through the array once to build the map
     *                  and then iterate through the unique employees to calculate averages.
     * Space Complexity: O(U) where U is the number of unique employees.
     *                   The HashMap stores one entry for each unique employee.
     *
     * @param employeeMarks An array of String arrays, where each inner array
     *                      contains an employee's name and their marks as a string.
     * @return The maximum average marks among all employees.
     */
    public double findMaxAverage(String[][] employeeMarks) {
        if (employeeMarks == null || employeeMarks.length == 0) {
            return 0.0;
        }

        // Map to store {EmployeeName: [total_marks_sum, count_of_marks]}
        Map<String, int[]> employeeData = new HashMap<>();

        // 1. Iterate through the input array to populate the map with sums and counts
        for (String[] entry : employeeMarks) {
            String name = entry[0];
            int marks = Integer.parseInt(entry[1]);

            // Get or create the data array for the employee
            int[] data = employeeData.getOrDefault(name, new int[]{0, 0});
            
            // Update the total marks sum and the count
            data[0] += marks;
            data[1] += 1;
            
            // Put the updated data back into the map
            employeeData.put(name, data);
        }

        double maxAverage = Double.MIN_VALUE;

        // 2. Iterate through the map to calculate the average for each employee
        //    and find the maximum average.
        for (Map.Entry<String, int[]> entry : employeeData.entrySet()) {
            int[] data = entry.getValue();
            double currentAverage = (double) data[0] / data[1];

            if (currentAverage > maxAverage) {
                maxAverage = currentAverage;
            }
        }

        return maxAverage;
    }
    
    public static void main(String[] args) {
        String[][] employeeMarks = {
            {"Alia", "-678"},
            {"Bobby", "100"},
            {"Alex", "223"},
            {"Alex", "-23"},
            {"Bobby", "723"}
        };

        EmployeeAverageFinder finder = new EmployeeAverageFinder();
        double maxAvg = finder.findMaxAverage(employeeMarks);

        System.out.println("The maximum average marks from the list is: " + maxAvg);
        // Expected output: 315.0
    }
}
