package org.kas.demos.Prac.CoderpatQuest.DAY26_29_10;

import java.util.Arrays;

public class MaxProductSubarray1 {

    public static void findMaxProductSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            System.out.println("The array is empty.");
            return;
        }

        long maxSoFar = nums[0];
        long minSoFar = nums[0];
        long maxProduct = nums[0];
        int start = 0;
        int end = 0;
        int currentStart = 0;
        int minStart=0;
        for (int i = 1; i < nums.length; i++) {
            long currentVal = nums[i];

            if (currentVal < 0) {
                long temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
                minStart=i;
            }

            maxSoFar = Math.max(currentVal, maxSoFar * currentVal);
            minSoFar = Math.min(currentVal, minSoFar * currentVal);

            if (currentVal == maxSoFar) {
                currentStart = i;
            }
            if (maxSoFar > maxProduct) {
                maxProduct = maxSoFar;
                end = i;
                start = currentStart;
            }


        }

        int[] subarray = Arrays.copyOfRange(nums, start, end + 1);

        System.out.println("maximum subarray is " + Arrays.toString(subarray) + " and product is " + maxProduct);
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
