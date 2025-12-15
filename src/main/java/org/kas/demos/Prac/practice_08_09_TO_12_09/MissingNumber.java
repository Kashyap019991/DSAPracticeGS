package org.kas.demos.Prac.practice_08_09_TO_12_09;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MissingNumber {
//lc 268
    /**
     * Finds the missing number in an array containing n distinct numbers
     * in the range [0, n].
     *
     * @param nums The array of numbers.
     * @return The missing number.
     */
    /*
    public int findMissingNumber(int[] nums) {
        int n = nums.length;
        // Calculate the expected sum of numbers from 0 to n
        int expectedSum = n * (n + 1) / 2;

        // Calculate the actual sum of numbers in the given array
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // The missing number is the difference between the expected and actual sum
        return expectedSum - actualSum;
    }
    */

//method 2

 public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for(int num:nums){
            numSet.add(num);
        }
        int n=numSet.size();
        for(int i=0;i<=n;i++)
        {
            if(!numSet.contains(i))
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MissingNumber solution = new MissingNumber();

        int[] arr = new int[] {0,0, 1, 2, 4, 5 };
        int missingNum = solution.missingNumber(arr);
        System.out.println("The missing number is: " + missingNum);

        scanner.close();
    }
}