package org.kas.demos.Prac.CoderpatQuest.DAY26_29_10;

import java.util.Arrays;

public class MaxProductSubarray0 {

    public static void findMaxProductSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            System.out.println("The array is empty.");
            return;
        }

        long maxSoFar = nums[0];
        long minSoFar = nums[0];
        long maxProduct = nums[0];

        int maxStart = 0, maxEnd = 0;
        int tempMaxStart = 0;
        int minStart = 0; // track where min product subarray starts

        for (int i = 1; i < nums.length; i++) {
            long currentVal = nums[i];

            // swap when negative
            if (currentVal < 0) {
                long temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;

                int tempIdx = tempMaxStart;
                tempMaxStart = minStart;
                minStart = tempIdx;
            }

            // check whether to start a new subarray for max
            if (currentVal > maxSoFar * currentVal) {
                maxSoFar = currentVal;
                tempMaxStart = i;
            } else {
                maxSoFar = maxSoFar * currentVal;
            }

            // check whether to start a new subarray for min
            if (currentVal < minSoFar * currentVal) {
                minSoFar = currentVal;
                minStart = i;
            } else {
                minSoFar = minSoFar * currentVal;
            }

            // update global max
            if (maxSoFar > maxProduct) {
                maxProduct = maxSoFar;
                maxStart = tempMaxStart;
                maxEnd = i;
            }
        }

        int[] subarray = Arrays.copyOfRange(nums, maxStart, maxEnd + 1);
        System.out.println("Maximum product subarray is " + Arrays.toString(subarray)
                + " and product is " + maxProduct);
    }

    public static void main(String[] args) {
        int[] arr1 = {-2, 6, 4};
        findMaxProductSubarray(arr1);

        int[] arr2 = {2, 3, -2, 4};
        findMaxProductSubarray(arr2);

        int[] arr3 = {-2, -3, -4};
        findMaxProductSubarray(arr3);
    }
}
