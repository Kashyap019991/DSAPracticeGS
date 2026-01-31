package org.kas.demos.Prac.CoderpatQuest.DAY34_08_11;

public class RotatedSortedArraySearch {

    /**
     * Searches for a target value in a rotated sorted array.
     *
     * @param nums The rotated sorted array.
     * @param target The number to search for.
     * @return The index of the target if found, otherwise -1.
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Target found at mid
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {//{4, 5, 6, 7, 0, 1, 2} tg=5,1
                // Check if the target lies within the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left half
                } else {
                    left = mid + 1; // Target is in the right half
                }
            } 
            // Otherwise, the right half must be sorted
            else {////4,5,0,1,2,3 tg=5,1
                // Check if the target lies within the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target is in the right half
                } else {
                    right = mid - 1; // Target is in the left half
                }
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Array: [4, 5, 6, 7, 0, 1, 2], Target: 0");
        System.out.println("Result Index: " + search(arr1, target1)); // Output: 4

        int[] arr2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("\nArray: [4, 5, 6, 7, 0, 1, 2], Target: 3");
        System.out.println("Result Index: " + search(arr2, target2)); // Output: -1
        
        int[] arr3 = {1, 2, 3, 4, 5};
        int target3 = 4;
        System.out.println("\nArray: [1, 2, 3, 4, 5], Target: 4");
        System.out.println("Result Index: " + search(arr3, target3)); // Output: 3

        int[] arr4 = {4,5,0,1,2,3};
        int target4 = 5;
        System.out.println("\nArray: {4,5,0,1,2,3}, Target: 5");
        System.out.println("Result Index: " + search(arr4, target4)); // Output: 1


    }


}
