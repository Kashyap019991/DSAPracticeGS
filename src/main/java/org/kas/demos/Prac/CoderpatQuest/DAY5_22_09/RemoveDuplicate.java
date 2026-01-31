package org.kas.demos.Prac.CoderpatQuest.DAY5_22_09;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        List<Integer> list = new ArrayList<>();
        //Set<Integer> seen = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if((i+1 < nums.length) && (nums[i] != nums[i+1]))
            {
                list.add(nums[i]);
            }
        }
        //System.out.println(list.get(list.size()-1));
        if(nums[nums.length-1] != list.get(list.size()-1)){
            list.add(nums[nums.length-1]);
        }
        System.out.println(list);

    }
}
