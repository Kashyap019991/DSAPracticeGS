package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09;

public class DotProduct {
    /**
     * Given two arrays of integers, returns the dot product of the arrays.
     * The dot product is calculated as the sum of the products of corresponding elements.
     * It is assumed that both arrays have the same length.
     *
     * @param array1 The first array of integers.
     * @param array2 The second array of integers.
     * @return The dot product of the two arrays.
     */
    public static int dotProduct(int[] array1, int[] array2) {
        // Initialize the result variable to store the dot product
        int sum = 0;

        // Iterate through the arrays, multiplying corresponding elements and adding to the sum
        // The loop runs for the length of the arrays, assuming they are of equal length.
        for (int i = 0; i < array1.length; i++) {
            sum += array1[i] * array2[i]; // Multiply elements at the same index and add to sum
        }

        // Return the calculated dot product
        return sum;
    }

    public static void main(String[] args) {
        // Define two sample arrays for testing
        int[] array1 = {1, 2};
        int[] array2 = {2, 3};

        // Calculate the dot product using the dotProduct method
        int result = dotProduct(array1, array2);

        // Check if the calculated result matches the expected value (1*2 + 2*3 = 2 + 6 = 8)
        if (result == 8) {
            System.out.println("Passed."); // Output if the test passes
            // Note: The original code returned 'true' here, but main methods typically
            // don't return a boolean. The System.out.println is sufficient for testing.
        } else {
            System.out.println("Failed."); // Output if the test fails
            // Note: Similar to the above, returning 'false' from main is not standard.
        }
    }
}