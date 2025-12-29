package org.kas.demos.Prac.CoderpatQuest.DAY26_29_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to efficiently handle duplicates and use two-pointers
        Arrays.sort(nums);

        //{-4,-2,-1,0,1,5}
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for the first number of the triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a triplet that sums to zero
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate elements for the second and third numbers
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move pointers to find next distinct triplets
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too small, increment left pointer to increase sum
                    left++;
                } else {
                    // Sum is too large, decrement right pointer to decrease sum
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum solver = new ThreeSum();
        int[] arr = new int[]{-1, 0, 1, -2, 5, -4};
        List<List<Integer>> triplets = solver.threeSum(arr);

        System.out.println("Unique triplets that sum to zero:");
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }
}