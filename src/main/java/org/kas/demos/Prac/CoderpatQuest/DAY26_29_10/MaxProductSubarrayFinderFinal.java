package org.kas.demos.Prac.CoderpatQuest.DAY26_29_10;

import java.util.Arrays;

public class MaxProductSubarrayFinderFinal {

    /**
     * Finds the maximum product subarray in O(n) time complexity and prints
     * the subarray and its product. This solution correctly tracks indices
     * for all cases.
     *
     * @param nums The input array of integers.
     */
    public static void findMaxProductSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            System.out.println("The array is empty.");
            return;
        }

        long maxSoFar = nums[0];
        long minSoFar = nums[0];
        long maxProduct = nums[0];
        int globalStart = 0;
        int globalEnd = 0;
        int currentStart = 0;
        int minStart = 0; // Track the start index for the minSoFar product

        for (int i = 1; i < nums.length; i++) {
            long currentVal = nums[i];

            // Store previous max for minSoFar calculation and indices
            long tempMax = maxSoFar;
            int tempStart = currentStart;
//{-2, -3, -4}
            // Calculate new maxSoFar and minSoFar
            // If the currentVal is greater than any product extending from the previous
            // elements, the new sequence starts from 'i'.
            maxSoFar = Math.max(currentVal, Math.max(maxSoFar * currentVal, minSoFar * currentVal));
            minSoFar = Math.min(currentVal, Math.min(tempMax * currentVal, minSoFar * currentVal));

            // Logic to update start indices:
            if (maxSoFar == currentVal) {
                currentStart = i; // New sequence starts at 'i'
            } else if (maxSoFar == tempMax * currentVal) { // Check if it came from the OLD max sequence
                currentStart = tempStart; // Use the start index of the OLD max sequence
            } else {
                currentStart = minStart; // It came from the previous min sequence
            }

            if (minSoFar == currentVal) {
                minStart = i;
            } else if (minSoFar == tempMax * currentVal) {
                minStart = tempStart;
            } else {
                minStart = minStart; // It came from the previous minStart sequence
            }

            // Update the global maximum product and its indices
            if (maxSoFar > maxProduct) {
                maxProduct = maxSoFar;
                globalStart = currentStart;
                globalEnd = i;
            }
        }

        int[] subarray = Arrays.copyOfRange(nums, globalStart, globalEnd + 1);
        System.out.println("The maximum product subarray is: " + Arrays.toString(subarray));
        System.out.println("The maximum product is: " + maxProduct);
    }

    public static void main(String[] args) {
        System.out.println("--- Case: {-2, -3, -4} ---");
        int[] arr1 = {-2, -3, -4};
        findMaxProductSubarray(arr1); // Expected: [-3, -4], Product 12

        System.out.println("\n--- Case: {2, 3, -2, 4} ---");
        int[] arr2 = {2, 3, -2, 4};
        findMaxProductSubarray(arr2);

        System.out.println("\n--- Case: {1, 5, -2, -1, 4} ---");
        int[] arr3 = {1, 5, -2, -1, 4};
        findMaxProductSubarray(arr3);

        System.out.println("\n--- Case: {-1, -3, -10, 0, 60} ---");
        int[] arr4 = {-1, -3, -10, 0, 60};
        findMaxProductSubarray(arr4);
    }
}
