package org.kas.demos.Prac.CoderpatQuest.DAY8_25_09;

import java.util.HashSet;
import java.util.Set;

public class SmallestMissingPositive {

    /**
     * Finds the smallest positive integer that is not present in an unsorted integer array.
     * 
     * @param nums The unsorted integer array.
     * @return The smallest positive integer missing from the array.
     */
    public int findSmallestMissingPositive(int[] nums) {
        // Use a HashSet for efficient lookup (O(1) average time).
        Set<Integer> seen = new HashSet<>();

        // Add all positive numbers from the input array to the set.
        // We only care about positive integers because the problem asks for the smallest *positive*
        // missing integer. Any negative numbers or zeros are irrelevant.
        for (int num : nums) {
            if (num > 0) {
                seen.add(num);
            }
        }

        // Iterate through positive integers, starting from 1.
        // The smallest missing positive integer must be at least 1.
        for (int i = 1; i <= nums.length + 1; i++) {
            // Check if the current integer 'i' is in the set.
            // If it's not in the set, it means this is the smallest missing positive integer.
            if (!seen.contains(i)) {
                return i;
            }
        }
        
        // This line is technically unreachable due to the loop condition (i <= nums.length + 1).
        // The smallest missing positive will be at most nums.length + 1.
        return -1; // Should not happen
    }

    public static void main(String[] args) {
        SmallestMissingPositive solution = new SmallestMissingPositive();
        
        // Example 1: Basic case with missing number in the middle
        int[] nums1 = {1, 2, 0};
        System.out.println("Input: {1, 2, 0}");
        System.out.println("Smallest missing positive: " + solution.findSmallestMissingPositive(nums1)); // Expected: 3
        
        // Example 2: Missing number is 1
        int[] nums2 = {3, 4, -1, 1};
        System.out.println("\nInput: {3, 4, -1, 1}");
        System.out.println("Smallest missing positive: " + solution.findSmallestMissingPositive(nums2)); // Expected: 2
        
        // Example 3: All numbers from 1 to n are present
        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println("\nInput: {7, 8, 9, 11, 12}");
        System.out.println("Smallest missing positive: " + solution.findSmallestMissingPositive(nums3)); // Expected: 1
        
        // Example 4: Array contains 1, so the missing number is after it
        int[] nums4 = {1};
        System.out.println("\nInput: {1}");
        System.out.println("Smallest missing positive: " + solution.findSmallestMissingPositive(nums4)); // Expected: 2
    }
}
