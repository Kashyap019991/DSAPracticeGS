package org.kas.demos.Prac.CoderpatQuest.DAY8_25_09;

import java.util.Arrays;

public class RemoveDuplicatesInplace {

    /**
     * Removes duplicates from a sorted integer array in-place.
     * The unique elements are moved to the front of the array.
     *
     * @param nums The input array of sorted integers with duplicates.
     * @return The new length of the array after removing duplicates.
     */
    //method 1:
    static int getRemoveDuplicateInplace(int[] nums){
//{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
        int left=0,n=nums.length;
        for(int right=0;right<n;right++){
            if(right +1 < n && nums[right] != nums[right+1]){
                nums[left] = nums[right];
                left++;
            }

        }
        if(nums[n-2] != nums[n-1]){
            nums[left]= nums[n-1];
        }

        //no. of element
        return left+1;
    }
    //method 2
    public static int removeDuplicates(int[] nums) {
        // If the array is empty, there's nothing to do.
        if (nums.length == 0) {
            return 0;
        }
        
        // Use a "slow" pointer `i` to keep track of the position of the last unique element.
        int i = 0;
//{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
        // Use a "fast" pointer `j` to iterate through the array.
        for (int j = 1; j < nums.length; j++) {
            // If the current element `nums[j]` is different from the previous unique element `nums[i]`,
            // it means we have found a new unique element.
            if (nums[j] != nums[i]) {
                // Increment the slow pointer `i` to move to the next position.
                i++;
                // Place the new unique element `nums[j]` at the position of the slow pointer.
                nums[i] = nums[j];
            }
        }
        
        // The number of unique elements is `i + 1`.
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        
        System.out.println("Original array: " + Arrays.toString(nums));
        
        int newLength = removeDuplicates(nums);
        
        // Since the array is modified in-place, the result is in the first `newLength` elements.
        System.out.print("Array with duplicates removed: [");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i]);
            if (i < newLength - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        System.out.println("New length: " + newLength);
    }
}
