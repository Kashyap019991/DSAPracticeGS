package org.kas.demos.Prac.CoderpatQuest.DAY19_14_10;

public class RotatedSortedArraySearch {

    /**
     * Searches for a target element in a rotated sorted array.
     *
     * @param nums The rotated sorted array.
     * @param target The element to search for.
     * @return The index of the target element if found, otherwise -1.
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[low] <= nums[mid]) {
                // If target is within the sorted left half
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            // Otherwise, the right half must be sorted
            else { 
                // If target is within the sorted right half
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Index of " + target1 + " in arr1: " + search(arr1, target1)); // Expected: 4

        int[] arr2 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int target2 = 3;
        System.out.println("Index of " + target2 + " in arr2: " + search(arr2, target2)); // Expected: 8

        int[] arr3 = {1, 2, 3, 4, 5}; // Not rotated
        int target3 = 5;
        System.out.println("Index of " + target3 + " in arr3: " + search(arr3, target3)); // Expected: 4

        int[] arr4 = {1};
        int target4 = 1;
        System.out.println("Index of " + target4 + " in arr4: " + search(arr4, target4)); // Expected: 0

        int[] arr5 = {1, 3};
        int target5 = 2;
        System.out.println("Index of " + target5 + " in arr5: " + search(arr5, target5)); // Expected: -1
    }
}