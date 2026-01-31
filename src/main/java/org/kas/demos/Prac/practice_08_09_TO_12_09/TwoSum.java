package org.kas.demos.Prac.practice_08_09_TO_12_09;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
//lt 1
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        // This line should ideally not be reached based on the problem statement
        // that there is exactly one solution.
        return new int[]{-1, -1}; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TwoSum solution = new TwoSum();

        System.out.println("Enter the array of numbers (space-separated):");
        String[] numStrings = scanner.nextLine().split(" ");
        int[] nums = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            nums[i] = Integer.parseInt(numStrings[i]);
        }

        System.out.println("Enter the target sum:");
        int target = scanner.nextInt();

        int[] result = solution.twoSum(nums, target);

        if (result[0] != -1) {
            System.out.println("Indices are: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No two sum solution found.");
        }

        scanner.close();
    }
}