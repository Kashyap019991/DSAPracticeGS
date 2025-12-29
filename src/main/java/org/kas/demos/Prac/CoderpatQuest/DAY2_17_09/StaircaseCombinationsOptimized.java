package org.kas.demos.Prac.CoderpatQuest.DAY2_17_09;

public class StaircaseCombinationsOptimized {

    /**
     * Calculates the number of unique ways to climb a staircase of 'n' steps, 
     * taking 1, 2, or 3 steps at a time, using O(1) extra space.
     *
     * @param n The total number of steps in the staircase.
     * @return The number of unique combinations.
     */
    public static int countStepsOptimized(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        // Initialize variables to hold the number of ways for the previous three steps:
        // 'a' holds the result for step i-3 (starts as ways[0] = 1)
        int ways_i_minus_3 = 1; 
        // 'b' holds the result for step i-2 (starts as ways[1] = 1)
        int ways_i_minus_2 = 1;
        // 'c' holds the result for step i-1 (starts as ways[2] = 2)
        int ways_i_minus_1 = 2;

        // 'current_ways' will hold the result for the current step 'i'
        int current_ways = 0;

        // Iterate from the 3rd step up to 'n'
        for (int i = 3; i <= n; i++) {
            // Calculate the number of ways for the current step 'i'
            current_ways = ways_i_minus_1 + ways_i_minus_2 + ways_i_minus_3;

            // Update the variables for the next iteration:
            // Shift all values "forward" by one step
            ways_i_minus_3 = ways_i_minus_2;
            ways_i_minus_2 = ways_i_minus_1;
            ways_i_minus_1 = current_ways;
        }

        // After the loop finishes, ways_i_minus_1 holds the result for step 'n'
        return ways_i_minus_1;
    }

    // Example Usage (Test the function)
    public static void main(String[] args) {
        int n1 = 3;
        System.out.println("O(1) space combinations for " + n1 + " steps: " + countStepsOptimized(n1)); // Expected: 4

        int n2 = 4;
        System.out.println("O(1) space combinations for " + n2 + " steps: " + countStepsOptimized(n2)); // Expected: 7
        
        int n3 = 5;
        System.out.println("O(1) space combinations for " + n3 + " steps: " + countStepsOptimized(n3)); // Expected: 13
    }
}
