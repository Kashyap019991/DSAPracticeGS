package org.kas.demos.Prac.CoderpatQuest.DAY10_29_09;

import java.util.Arrays;

public class ProductExceptSelf {

    public static int[] productArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n];
        
        // Pass 1: Calculate left products
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // Pass 2: Calculate right products and finalize result
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Test case 1: Positive integers
        int[] input1 = {1, 2, 3, 4, 5};
        int[] output1 = productArray(input1);
        System.out.println("Input: " + Arrays.toString(input1));
        System.out.println("Output: " + Arrays.toString(output1)); // Expected: [120, 60, 40, 30, 24]

        // Test case 2: Negative and zero values
        int[] input2 = {-1, 1, 0, -3, 3};
        int[] output2 = productArray(input2);
        System.out.println("\nInput: " + Arrays.toString(input2));
        System.out.println("Output: " + Arrays.toString(output2)); // Expected: [0, 0, 9, 0, 0]

        // Test case 3: Single element
        int[] input3 = {10};
        int[] output3 = productArray(input3);
        System.out.println("\nInput: " + Arrays.toString(input3));
        System.out.println("Output: " + Arrays.toString(output3)); // Expected: [1]

        // Test case 4: Empty array
        int[] input4 = {};
        int[] output4 = productArray(input4);
        System.out.println("\nInput: " + Arrays.toString(input4));
        System.out.println("Output: " + Arrays.toString(output4)); // Expected: []
    }
}
