package org.kas.demos.Prac.practice_08_09_TO_12_09;

import java.util.HashSet;
import java.util.Set;
/*
lc 128
Input: nums = [100,4,200,1,3,2]
Output: 4
 */
class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        int longestCons =0;

        Set<Integer> numSet = new HashSet<>();

        for(int num:nums){
            numSet.add(num);
        }
        //find element which is start point of series and count untill consecutive elm avail
        for(int num:numSet){
            int currLongCons=0;
             if(!numSet.contains(num-1)){
                 //consider it as start point
                 currLongCons++;
                 while(numSet.contains(num+1)){
                     num = num+1;
                     currLongCons++;
                 }
             }
             longestCons = Math.max(longestCons,currLongCons);
        }
        
        return longestCons;
    }

    public static void main(String[] args) {
        int[] nums = {0,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));

    }
}