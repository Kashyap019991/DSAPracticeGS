package org.kas.demos.Prac.practice_08_09_TO_12_09;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContainsDuplicate {
//lc 217
    /**
     * Checks if an array of integers contains any duplicates.
     *
     * @param nums The integer array to check.
     * @return true if any value appears at least twice in the array, false otherwise.
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seenNumbers = new HashSet<>();
        for (int num : nums) {
            if (seenNumbers.contains(num)) {
                return true; // Duplicate found
            }
            seenNumbers.add(num);
        }
        return false; // No duplicates found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContainsDuplicate solution = new ContainsDuplicate();

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array, separated by spaces:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        boolean hasDuplicate = solution.containsDuplicate(nums);
        System.out.println("Does the array contain duplicates? " + hasDuplicate);

        scanner.close();
    }
}