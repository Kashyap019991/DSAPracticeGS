package org.kas.demos.Prac.CoderpatQuest.DAY6_23_09;

public class DotProduct {

    /**
     * Calculates the dot product of two integer arrays.
     * The dot product is the sum of the products of corresponding elements.
     *
     * @param array1 The first array of integers.
     * @param array2 The second array of integers.
     * @return The dot product as a long to avoid integer overflow, or 0 if arrays are invalid.
     *         Returns -1 if the arrays have different lengths.
     */
    public long findDotProduct(int[] array1, int[] array2) {
        // Handle null arrays
        if (array1 == null || array2 == null) {
            return 0;
        }

        // Dot product is only defined for arrays of the same length.
        if (array1.length != array2.length) {
            System.err.println("Error: Arrays must have the same length for dot product.");
            return -1; // Or throw an IllegalArgumentException
        }

        // Use a long to store the sum to prevent potential integer overflow
        // for large arrays or large element values.
        long dotProduct = 0;

        // Iterate through the arrays, multiplying corresponding elements and summing them up.
        for (int i = 0; i < array1.length; i++) {
            dotProduct += (long) array1[i] * array2[i];
        }

        return dotProduct;
    }

    public static void main(String[] args) {
        DotProduct calculator = new DotProduct();

        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        System.out.println("Array 1: [1, 2, 3]");
        System.out.println("Array 2: [4, 5, 6]");
        System.out.println("Dot product: " + calculator.findDotProduct(a, b)); // Expected: 1*4 + 2*5 + 3*6 = 4 + 10 + 18 = 32

        System.out.println();

        int[] c = {-1, 0, 1};
        int[] d = {10, 20, 30};
        System.out.println("Array 1: [-1, 0, 1]");
        System.out.println("Array 2: [10, 20, 30]");
        System.out.println("Dot product: " + calculator.findDotProduct(c, d)); // Expected: -10 + 0 + 30 = 20

        System.out.println();

        int[] e = {1, 2};
        int[] f = {3, 4, 5};
        System.out.println("Array 1: [1, 2]");
        System.out.println("Array 2: [3, 4, 5]");
        System.out.println("Dot product: " + calculator.findDotProduct(e, f)); // Expected: Error message and -1
    }
}
