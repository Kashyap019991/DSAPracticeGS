package org.kas.demos.Prac.CoderpatQuest.DAY9_26_09;

import java.util.*;
/**
 * Given the same 2D array of student names and marks,
 * write a method to return the name(s) of the student(s)
 * with the highest average marks.
 *
 * Example:
 * For the above input, "Bobby" is the top scorer.
 *
 * If two students tie, return both names.
 */
public class TopScorerFinder {

    /**
     * Returns the name(s) of student(s) with the highest average marks.
     *
     * @param data 2D array where each row contains [name, mark1, mark2, ...]
     * @return List of student names with the highest average
     */
    public static List<String> findTopScorers(String[][] data) {
        List<String> topScorers = new ArrayList<>();
        double highestAverage = -1.0;

        for (String[] row : data) {
            String name = row[0];
            int total = 0;

            // Parse and sum marks
            for (int i = 1; i < row.length; i++) {
                total += Integer.parseInt(row[i]);
            }

            double average = (double) total / (row.length - 1);

            // Compare with current highest average
            if (average > highestAverage) {
                highestAverage = average;
                topScorers.clear();
                topScorers.add(name);
            } else if (average == highestAverage) {
                topScorers.add(name); // Handle tie
            }
        }

        return topScorers;
    }

    // Example usage
    public static void main(String[] args) {
        String[][] students = {
            {"Alice", "80", "90", "100"},
            {"Bob", "85", "95", "90"},
            {"Bobby", "100", "95", "100"},
            {"Charlie", "100", "95", "100"}
        };

        List<String> top = findTopScorers(students);
        System.out.println("Top scorer(s): " + top); // Output: [Bobby, Charlie]
    }
}
