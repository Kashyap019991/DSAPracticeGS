package org.kas.demos.Prac.CoderpatQuest.DAY12_1_10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
/* method 1: o(n) , o(1)
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Ignore non-positive numbers and numbers greater than n.
        // We can use the array itself as a hash table for numbers 1 to n.
        // The indices 0 to n-1 can represent the numbers 1 to n.
        // We don't care about other numbers, so they can be ignored or treated specially.
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                // Replacing with a placeholder value greater than n.
                nums[i] = n + 1;
            }
        }

        // Step 2: Mark the presence of positive numbers within the range [1, n].
        // We use the sign of the number at a specific index to mark presence.
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                // For a number 'num', we mark the index 'num-1'.
                // Using Math.abs() prevents us from using an already marked negative number.
                int index = num - 1;
                if (nums[index] > 0) {
                    nums[index] = -nums[index];
                }
            }
        }

        // Step 3: Find the first missing positive integer.
        // The first positive number found in the array indicates the missing value.
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                // The index i corresponds to the positive integer i+1.
                return i + 1;
            }
        }

        // If no positive number is found, it means all numbers from 1 to n are present.
        return n + 1;
    }
*/
public static int findFirstMissingPositive_notOpt(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
        if (num > 0) {
            set.add(num);
        }
    }

    for (int i = 1; i <= nums.length + 1; i++) {
        if (!set.contains(i)) {
            return i;
        }
    }
    return -1; // Should not be reached
}
//method 3 optimal
    //nums = {3, 4, -1, 1}
    //or loop: i = 0 {-1, 4, 3, 1}
    //cyclic sort: Final state of the array after the loops: nums = {1, -1, 3, 4}
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }

        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // The missing positive number
            }
        }
        return n + 1;
    }
    public static void main(String[] args) {
        int[] nums2 = {1, 2, 0};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums2));
        // Output: 3

        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums3));
        // Output: 1

        System.out.println("Test Case: {1, 2, 0}");
        int[] nums21 = {1, 2, 0};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums21));
        System.out.println();

        System.out.println("Test Case: {7, 8, 9, 11, 12}");
        int[] nums31 = {7, 8, 9, 11, 12};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums31));
        System.out.println();

        System.out.println("Test Case: {1, 2, 4}");
        int[] nums4 = {1, 2, 4};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums4));
        System.out.println();

        System.out.println("Test Case: {1, 2, 3}");
        int[] nums5 = {1, 2, 3};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums5));
        System.out.println();

        System.out.println("Test Case: {3, 4, -1, 1}");
        int[] nums6 = {3, 4, -1, 1};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums6));
        System.out.println();

        System.out.println("Test Case: {-5, -3, -1}");
        int[] nums7 = {-5, -3, -1};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums7));
        System.out.println();

        System.out.println("Test Case: {0}");
        int[] nums8 = {0};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums8));
        System.out.println();

        System.out.println("Test Case: {}");
        int[] nums9 = {};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums9));
        System.out.println();

        System.out.println("Test Case: {1}");
        int[] nums10 = {1};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums10));
        System.out.println();

        System.out.println("Test Case: {-10}");
        int[] nums11 = {-10};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums11));
        System.out.println();

        System.out.println("Test Case: {1, 1, 0, -1, -2}");
        int[] nums12 = {1, 1, 0, -1, -2};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums12));
        System.out.println();

        System.out.println("Test Case: {2, 2, 0, 1}");
        int[] nums13 = {2, 2, 0, 1};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums13));
        System.out.println();

        System.out.println("Test Case: {4, 1, 3, 5, 2}");
        int[] nums14 = {4, 1, 3, 5, 2};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums14));
        System.out.println();
    }

}
