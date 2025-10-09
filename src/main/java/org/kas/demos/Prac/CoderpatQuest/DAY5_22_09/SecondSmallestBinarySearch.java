package org.kas.demos.Prac.CoderpatQuest.DAY5_22_09;

import java.util.Arrays;

public class SecondSmallestBinarySearch {

    /**
     * Finds the index of the minimum element in a sorted rotated array.
     *
     * @param nums The sorted rotated array.
     * @return The index of the minimum element.
     */
    private int findMinIndex(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        // If the array is not rotated, the first element is the smallest.
        if (nums[low] <= nums[high]) {
            return low;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                // The minimum element is in the right half.
                low = mid + 1;
            } else {
                // The minimum element is in the left half (including mid).
                high = mid;
            }
        }
        return low;
    }

    /**
     * Finds the second smallest element in a sorted rotated array.
     * Time complexity: O(log n) for finding the minimum, followed by an O(1) lookup.
     *
     * @param nums The sorted rotated array.
     * @return The second smallest element.
     */
    public int findSecondSmallest(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }

        int minIndex = findMinIndex(nums);
        int n = nums.length;
        
        // The second smallest element is the next element after the minimum.
        // We use the modulo operator to handle the wrap-around case.
        return nums[(minIndex + 1) % n];
    }

    public static void main(String[] args) {
        SecondSmallestBinarySearch solution = new SecondSmallestBinarySearch();
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Second smallest element: " + solution.findSecondSmallest(arr)); // Expected: 2
        
        int[] arr2 = {10, 20, 30, 40, 5, 6, 7};
        System.out.println("\nArray: " + Arrays.toString(arr2));
        System.out.println("Second smallest element: " + solution.findSecondSmallest(arr2)); // Expected: 6
        
        int[] arr3 = {1, 1, 2, 3, 4, 5};
        System.out.println("\nArray: " + Arrays.toString(arr3));
        System.out.println("Second smallest element: " + solution.findSecondSmallest(arr3)); // Expected: 2
    }
}
