package org.kas.demos.Prac.CoderpatQuest.DAY7_24_09;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {

    /**
     * Finds the length of the longest subarray with a sum equal to k.
     * This method works for arrays with positive, negative, and zero integers.
     *
     * @param arr The input array of integers.
     * @param k The target sum.
     * @return The length of the longest subarray with a sum of k.
     */
    public static int longestSubarraySumK(int[] arr, int k) {
        // Handle null or empty array edge cases
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // A map to store prefix sums and their corresponding indices.
        // The key is the prefix sum, and the value is the index.
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        // Initialize variables
        int maxLength = 0;
        int currentSum = 0;

        // A special entry to handle subarrays starting from index 0.
        // If currentSum becomes k, then the subarray from index 0 to the current index has sum k.
        // The length would be current index + 1.
        // This is handled by adding (0, -1) to the map.
        prefixSumMap.put(0, -1);
        //int[] arr2 = {1, 2, 1, 0, 1};
        //int k2 = 4;
        // Iterate through the array to calculate prefix sums
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            // Check if (currentSum - k) exists in the map.
            // If it does, it means a subarray with sum k has been found.
            if (prefixSumMap.containsKey(currentSum - k)) {
                // Calculate the length of the subarray and update maxLength if it's longer.
                // The length is the current index minus the index of the matching prefix sum.
                int length = i - prefixSumMap.get(currentSum - k);
                maxLength = Math.max(maxLength, length);
            }

            // If the current sum is not yet in the map, add it.
            // We only store the first occurrence of a prefix sum to ensure we get the longest subarray.
            if (!prefixSumMap.containsKey(currentSum)) {
                prefixSumMap.put(currentSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Example with positive and negative numbers
        int[] arr1 = {-5, 8, -14, 2, 4, 12};
        int k1 = -5;
        System.out.println("Array: " + java.util.Arrays.toString(arr1));
        System.out.println("Longest subarray with sum " + k1 + " has length: " + longestSubarraySumK(arr1, k1)); // Expected: 5

        // Another example
        int[] arr2 = {1, 2, 1, 0, 1};
        int k2 = 4;
        System.out.println("\nArray: " + java.util.Arrays.toString(arr2));
        System.out.println("Longest subarray with sum " + k2 + " has length: " + longestSubarraySumK(arr2, k2)); // Expected: 4
    
        // Example with no subarray having the target sum
        int[] arr3 = {1, 2, 3, 4};
        int k3 = 10;
        System.out.println("\nArray: " + java.util.Arrays.toString(arr3));
        System.out.println("Longest subarray with sum " + k3 + " has length: " + longestSubarraySumK(arr3, k3)); // Expected: 0
    }
}
