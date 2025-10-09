package org.kas.demos.Prac.practice_08_09_TO_12_09;

class LongestMonotonicSubArr {
    public int longestMonotonicSubarray(int[] nums) {
        int currIncrSubArr =1;
        int currDecrSubArr=1;
        int maxMon=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                currIncrSubArr++;
                currDecrSubArr=1;
            }
            else if(nums[i] < nums[i-1]){
                currDecrSubArr++;
                currIncrSubArr=1;
            }
            else{
                currIncrSubArr=1;
                currDecrSubArr=1;
            }
            maxMon = Math.max(maxMon,Math.max(currIncrSubArr,currDecrSubArr));
        }
        return maxMon;
    }

    public static void main(String[] args) {
        int[] arr = {1,10,10};
        System.out.println(new LongestMonotonicSubArr().longestMonotonicSubarray(arr));
    }
}