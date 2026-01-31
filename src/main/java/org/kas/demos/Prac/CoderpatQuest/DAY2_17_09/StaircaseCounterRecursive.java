package org.kas.demos.Prac.CoderpatQuest.DAY2_17_09;
/*

 ** There is a staircase with 'n' number of steps. A child
 ** walks by and wants to climb up the stairs, starting at
 ** the bottom step and ascending to the top.instead
 ** of taking 1 step at a time, it will vary between taking
 ** either 1, 2 or 3 steps at a time.
 ** Given 'n' number of steps below method should find
 ** number of
 ** unique combinations the child could traverse.
 ** An example would be countSteps(3) == 4:
 ** 1 1 1
 ** 2 1
 ** 1 2
 ** 3
 */
public class StaircaseCounterRecursive {

    /**
     * Counts the number of unique combinations a child can traverse
     * to climb a staircase of 'n' steps, taking 1, 2, or 3 steps at a time.
     *
     * @param n The number of steps in the staircase.
     * @return The total number of unique combinations.
     */
    public static int countSteps(int n) {
        // Base Case 1: If there are 0 or fewer steps, there's 1 way (do nothing).
        // This is important for the recursive calls to terminate correctly.
        if (n < 0) {
            return 0; // No ways to climb a negative number of steps
        }
        // Base Case 2: If there is 1 step, there's only 1 way to climb it (take 1 step).
        if (n == 0 || n == 1) {
            return 1; // If n is 0, it's like being at the top, so 1 way (do nothing).
        }

        // Recursive Step: The number of ways to reach step 'n' is the sum of
        // ways to reach step 'n-1' (by taking 1 step from there),
        // ways to reach step 'n-2' (by taking 2 steps from there),
        // and ways to reach step 'n-3' (by taking 3 steps from there).
        return countSteps(n - 1) + countSteps(n - 2) + countSteps(n - 3);
    }

    public static void main(String[] args) {
        // Example usage:
        int numberOfSteps = 3;
        int combinations = countSteps(numberOfSteps);
        System.out.println("For " + numberOfSteps + " steps, there are " + combinations + " unique combinations."); // Output: 4

        numberOfSteps = 4;
        combinations = countSteps(numberOfSteps);
        System.out.println("For " + numberOfSteps + " steps, there are " + combinations + " unique combinations."); // Output: 7
    }
}