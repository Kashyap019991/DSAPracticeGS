package org.kas.demos.Prac.CoderpatQuest.DAY6_23_09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Finds the number of pairs in an integer array that sum up to a specific target value.
 */
public class PairSumFinder {

    /**
     * Finds the number of pairs using a HashMap (optimized approach).
     * Time Complexity: O(n) - A single pass is made through the array.
     * Space Complexity: O(n) - A HashMap is used to store elements and their frequencies.
     *
     * @param arr The input integer array.
     * @param targetSum The target sum for the pairs.
     * @return The total number of pairs whose sum equals the targetSum.
     */
    public int findPairCount(int[] arr, int targetSum) {
        // A map to store the frequency of each number encountered
        Map<Integer, Integer> numFrequency = new HashMap<>();
        int pairCount = 0;
//[1, 5, 7, -1, 5], Target Sum: 6" , op 3
        // Iterate through each number in the array
        for (int num : arr) {
            // Calculate the complement needed to reach the target sum
            int complement = targetSum - num;

            // If the complement exists in the map, add its frequency to the pair count
            if (numFrequency.containsKey(complement)) {
                pairCount += numFrequency.get(complement);
            }

            // Update the frequency of the current number in the map
            numFrequency.put(num, numFrequency.getOrDefault(num, 0) + 1);
        }

        return pairCount;
    }

    /**
     * Finds the number of pairs using a brute-force approach with nested loops.
     * Time Complexity: O(n^2) - Nested loops check every possible pair.
     * Space Complexity: O(1) - No extra space is used.
     *
     * @param arr The input integer array.
     * @param targetSum The target sum for the pairs.
     * @return The total number of pairs whose sum equals the targetSum.
     */
    public int findPairCountBruteForce(int[] arr, int targetSum) {
        int pairCount = 0;
        int n = arr.length;

        // Outer loop iterates from the first element
        for (int i = 0; i < n; i++) {
            // Inner loop iterates from the next element to avoid double-counting
            // and pairing an element with itself
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == targetSum) {
                    pairCount++;
                }
            }
        }
        return pairCount;
    }

    public static int findUniquePairCount(int[] arr, int targetSum) {
        // Set to store numbers we have already seen.
        Set<Integer> seen = new HashSet<>();
        // Set to store the unique pairs found. Using strings like "1,5" avoids
        // object overhead and complex pair-hashing.
        Set<String> uniquePairs = new HashSet<>();

        for (int num : arr) {
            int complement = targetSum - num;
//{1, 5, 7, -1, 5}; 6
            // Check if we have seen the complement before.
            if (seen.contains(complement)) {
                // To ensure the pair is unique and not dependent on order (e.g., (1, 5) vs (5, 1)),
                // we sort the numbers before adding them to the uniquePairs set.
                int a = Math.min(num, complement);
                int b = Math.max(num, complement);
                uniquePairs.add(a + "," + b);
            }
            // Add the current number to the seen set for future checks.
            seen.add(num);
        }

        return uniquePairs.size();
    }

    public static void main(String[] args) {
        PairSumFinder finder = new PairSumFinder();

        int[] arr1 = {1, 5, 7, -1, 5};
        int targetSum1 = 6;
        System.out.println("Array: [1, 5, 7, -1, 5], Target Sum: 6");
        System.out.println("Pair Count (HashMap): " + finder.findPairCount(arr1, targetSum1)); // Expected: 3
        System.out.println("Pair Count (Brute Force): " + finder.findPairCountBruteForce(arr1, targetSum1)); // Expected: 3

        System.out.println("Unique Pair :" +findUniquePairCount(arr1,targetSum1));
        System.out.println();

        int[] arr2 = {2, 7, 4, -5, 11, 5, 20};
        int targetSum2 = 15;
        System.out.println("Array: [2, 7, 4, -5, 11, 5, 20], Target Sum: 15");
        System.out.println("Pair Count (HashMap): " + finder.findPairCount(arr2, targetSum2)); // Expected: 2
        System.out.println("Pair Count (Brute Force): " + finder.findPairCountBruteForce(arr2, targetSum2)); // Expected: 2

        System.out.println();
        
        int[] arr3 = {1, 1, 1, 1};
        int targetSum3 = 2;
        System.out.println("Array: [1, 1, 1, 1], Target Sum: 2");
        System.out.println("Pair Count (HashMap): " + finder.findPairCount(arr3, targetSum3)); // Expected: 6
        System.out.println("Pair Count (Brute Force): " + finder.findPairCountBruteForce(arr3, targetSum3)); // Expected: 6
    }
}

