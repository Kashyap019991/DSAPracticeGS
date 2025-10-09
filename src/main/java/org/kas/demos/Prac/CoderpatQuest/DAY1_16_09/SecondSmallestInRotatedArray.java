package org.kas.demos.Prac.CoderpatQuest.DAY1_16_09;

public class SecondSmallestInRotatedArray {

    public static int findSecondSmallest(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1; // Handle edge cases
        }

        int n = nums.length;
        int minIndex = findMinIndex(nums);

        if (minIndex == n - 1) {
            return nums[0]; // Minimum is the last element, second smallest is the first
        }

        return nums[minIndex + 1]; // Second smallest is the element after the minimum
    }

    private static int findMinIndex(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        if (nums[low] <= nums[high]) {
            return low; // Array is not rotated
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid; // mid is the minimum element
            }

            if (nums[low] > nums[mid]) {
                high = mid - 1; // Minimum is in the left half
            } else {
                low = mid + 1; // Minimum is in the right half
            }
        }

        return 0;
    }
}
