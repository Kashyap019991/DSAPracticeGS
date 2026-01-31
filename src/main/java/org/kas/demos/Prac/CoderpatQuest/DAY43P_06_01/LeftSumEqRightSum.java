package org.kas.demos.Prac.CoderpatQuest.DAY43P_06_01;
/*
Given a 0-indexed integer array nums, find the leftmost middleIndex (i.e., the smallest amongst all the possible ones).

A middleIndex is an index where nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1].

If middleIndex == 0, the left side sum is considered to be 0. Similarly, if middleIndex == nums.length - 1, the right side sum is considered to be 0.

Return the leftmost middleIndex that satisfies the condition, or -1 if there is no such index.



Example 1:

Input: nums = [2,3,-1,8,4]
Output: 3
Explanation: The sum of the numbers before index 3 is: 2 + 3 + -1 = 4
The sum of the numbers after index 3 is: 4 = 4
Example 2:

Input: nums = [1,-1,4]
Output: 2
Explanation: The sum of the numbers before index 2 is: 1 + -1 = 0
The sum of the numbers after index 2 is: 0
Example 3:

Input: nums = [2,5]
Output: -1
Explanation: There is no valid middleIndex.

 */
public class LeftSumEqRightSum {
    public int findMiddleIndex(int[] nums) {
        // Calculate the total sum of all elements in the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        // Iterate through each index i to check if it's a middleIndex
        for (int i = 0; i < nums.length; i++) {
            // The right side sum is: totalSum - leftSum - current element
            // We check if leftSum == rightSum
            //2, 3, -1, 8, 4 , totsum=16
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i; // Found the leftmost middleIndex
            }
            // Update leftSum to include the current element for the next index
            leftSum += nums[i];
        }

        // If no middleIndex is found after the loop, return -1
        return -1;
    }

    public static void main(String[] args) {
        LeftSumEqRightSum sol = new LeftSumEqRightSum();
        
        // Example 1: Output 3
        System.out.println(sol.findMiddleIndex(new int[]{2, 3, -1, 8, 4})); 
        
        // Example 2: Output 2
        System.out.println(sol.findMiddleIndex(new int[]{1, -1, 4}));      
        
        // Example 3: Output -1
        System.out.println(sol.findMiddleIndex(new int[]{2, 5}));         
    }
}
