package org.kas.demos.Prac.CoderpatQuest.DAY6_23_09;

public class DotProductUnequalLength {

    /**
     * Calculates the dot product of two integer arrays. If the arrays
     * have different lengths, the loop runs for the length of the shorter array.
     *
     * @param array1 The first array of integers.
     * @param array2 The second array of integers.
     * @return The dot product as a long to avoid integer overflow, or 0 if either array is null.
     */
    public long findDotProduct(int[] array1, int[] array2) {
        // Handle null arrays gracefully
        if (array1 == null || array2 == null) {
            return 0;
        }

        // Determine the length of the shorter array to avoid ArrayIndexOutOfBoundsException
        int minLength = Math.min(array1.length, array2.length);

        // Use a long for the sum to prevent potential integer overflow
        long dotProduct = 0;

        // Iterate up to the minimum length, multiplying corresponding elements
        for (int i = 0; i < minLength; i++) {
            dotProduct += (long) array1[i] * array2[i];
        }

        return dotProduct;
    }

    public static void main(String[] args) {
        DotProductUnequalLength calculator = new DotProductUnequalLength();

        // Example with equal length arrays
        int[] a1 = {1, 2, 3};
        int[] b1 = {4, 5, 6};
        System.out.println("Arrays: {1, 2, 3} and {4, 5, 6}");
        System.out.println("Dot product: " + calculator.findDotProduct(a1, b1)); // Expected: 1*4 + 2*5 + 3*6 = 32

        System.out.println();

        // Example with unequal length arrays (array2 is shorter)
        int[] a2 = {1, 2, 3, 4};
        int[] b2 = {5, 6};
        System.out.println("Arrays: {1, 2, 3, 4} and {5, 6}");
        System.out.println("Dot product: " + calculator.findDotProduct(a2, b2)); // Expected: 1*5 + 2*6 = 17

        System.out.println();

        // Example with unequal length arrays (array1 is shorter)
        int[] a3 = {10, 20};
        int[] b3 = {1, 2, 3, 4};
        System.out.println("Arrays: {10, 20} and {1, 2, 3, 4}");
        System.out.println("Dot product: " + calculator.findDotProduct(a3, b3)); // Expected: 10*1 + 20*2 = 50

        System.out.println();

        // Example with empty array
        int[] a4 = {};
        int[] b4 = {1, 2, 3};
        System.out.println("Arrays: {} and {1, 2, 3}");
        System.out.println("Dot product: " + calculator.findDotProduct(a4, b4)); // Expected: 0
    }
}
