package org.kas.demos.Prac.CoderpatQuest.DAY42P_04_01;
/*
leetcode 26
Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */
class RemDupl {
    static public int removeDuplicates(int[] nums) {
      /*
       Set<Integer> set = new HashSet<>();
    int index = 0;
    for (int num : nums) {
        // add() returns true if the element was not already present
        if (set.add(num)) {
            nums[index++] = num; // Update original array in-place
        }
    }
    return set.size(); // Or return index;
    
    */
        int j=0;
        int n = nums.length;
        //int[] res = new int[n];
        //res[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[j] != nums[i]){
                j++;
                nums[j] = nums[i];

            }

        }
        for(int i=0;i<=j;i++)
            System.out.print(" "+nums[i]);
        return j;
    }

    public static void main(String[] args) {
        int[] nums =  {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}