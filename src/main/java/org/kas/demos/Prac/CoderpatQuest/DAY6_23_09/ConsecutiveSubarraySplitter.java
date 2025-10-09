package org.kas.demos.Prac.CoderpatQuest.DAY6_23_09;

import java.util.Map;
import java.util.TreeMap;
/*
Given an integer array nums of length n, where every element is from range 1 to 10, determine if it is possible to split all elements of the array into one or more subarrays of length k, where:

(a.)Each subarray contains k consecutive sequence number in ascending order. Suppose k is 3 then ay should be like {1,2,3},{2,3,4} -> it should be consecutive increasing sequence.

(b.)Each integer from nums is used exactly as many times as it appears in the input array.

If such a partitioning is possible, and no element is left in input array after making all ays, then return true; otherwise, return false.

Sample input-

1. int[] input=[1,1,1,2,2,3,3,3,4 5, 6, 7, 8, 9,10] -> k=3

ay= [[1,2,3], [1,2,3], [1,3,4], [5,6,7], [8,9,10] , all element covered, but [1,3,4] ay is not in increasing sequence so return false.


2. int[] input=[1,1,2,2,3,3,3,4 5, 6, 7, 8, 9,9,10] -> k = 3

ay= [[1,2,3], [1,2,3], [3,4,5], [6,7,8], [9,10] -> so last subarray is having 2 elements as well as 9 remaing in the array -> so it will return false.


3. int[] = [1,1,2,2,2,2] k = 3

subArray= not possible because only [1,2] can be form. not of exactly 3 number and array is still have some elements remaining, so return False.


4. int[] = {1,2,3,4,5,,6,7,8,9} -> subarray will be {1,2,3}, {4,5,6},{7,8,9} and all the arrays elements are covered so return true;
 */
/**
 * Determines if an array can be split into subarrays of a given length,
 * where each subarray contains consecutive numbers.
 */
public class ConsecutiveSubarraySplitter {

    /**
     * Checks if the given array can be partitioned into consecutive subarrays of length k.
     *
     * @param nums An array of integers from 1 to 10.
     * @param k    The required length of each subarray.
     * @return true if a valid partitioning is possible, false otherwise.
     */
    public boolean canPartitionIntoConsecutiveSubarrays(int[] nums, int k) {
        // Handle edge cases: If k is 0 or array length is not a multiple of k,
        // partitioning is impossible.
        if (k <= 0 || nums.length % k != 0) {
            return false;
        }

        // Use a TreeMap to store frequencies of numbers.
        // TreeMap keeps keys sorted, which is crucial for the greedy approach.
        Map<Integer, Integer> freqMap = new TreeMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Iterate through the sorted keys (numbers) of the map.
        for (int currentNum : freqMap.keySet()) {
            // Check the frequency of the current smallest number.
            // If it's greater than 0, we must use it to start a new subarray.
            while (freqMap.get(currentNum) > 0) {
                // Greedily attempt to form a new subarray of length k
                for (int i = 0; i < k; i++) {
                    int nextNum = currentNum + i;
                    // Check if the next consecutive number exists and its frequency is > 0.
                    if (freqMap.getOrDefault(nextNum, 0) <= 0) {
                        return false; // Cannot form a consecutive sequence
                    }
                    // "Consume" one instance of this number
                    freqMap.put(nextNum, freqMap.get(nextNum) - 1);
                }
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        ConsecutiveSubarraySplitter splitter = new ConsecutiveSubarraySplitter();

        // Sample 1: False (as explained in the prompt)
        int[] input1 = {1, 1, 1, 2, 2, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Input: " + java.util.Arrays.toString(input1) + ", k=3 -> " + splitter.canPartitionIntoConsecutiveSubarrays(input1, 3));

        // Sample 2: False (as explained in the prompt)
        int[] input2 = {1, 1, 2, 2, 3, 3, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        System.out.println("Input: " + java.util.Arrays.toString(input2) + ", k=3 -> " + splitter.canPartitionIntoConsecutiveSubarrays(input2, 3));

        // Sample 3: False (as explained in the prompt)
        int[] input3 = {1, 1, 2, 2, 2, 2};
        System.out.println("Input: " + java.util.Arrays.toString(input3) + ", k=3 -> " + splitter.canPartitionIntoConsecutiveSubarrays(input3, 3));

        // Sample 4: True (as explained in the prompt)
        int[] input4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Input: " + java.util.Arrays.toString(input4) + ", k=3 -> " + splitter.canPartitionIntoConsecutiveSubarrays(input4, 3));

        // Additional test case: {1,2,3,1,2,3} k=3 -> True
        int[] input5 = {1, 2, 3, 1, 2, 3};
        System.out.println("Input: " + java.util.Arrays.toString(input5) + ", k=3 -> " + splitter.canPartitionIntoConsecutiveSubarrays(input5, 3));
    }
}
