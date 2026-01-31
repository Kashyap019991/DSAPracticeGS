package org.kas.demos.Prac.CoderpatQuest.DAY44_19_01;

import java.util.*;
/*
find all pairs of numbers in an array that sum to value N.
Write a function that takes as input an array of numbers and a target sum.
For each pair of numbers in the array that sum to the target, print the pair on standard output.
Any given array element can only participate in one pairing.
When the function exits, return the number of matching pairs found.

        2 3 =5
*/
//int[] inp ={2,3,4,1,5,0,4}
//int target =5;

class UniquePairs{
    public static void main(String  args[]){
        int[] inp ={2,3,4,1,5,0,4};
        int target =5;
        List<int[]> resPair = new ArrayList<>();
        Map<Integer,Integer> elemInd = new HashMap<>();//{2,0}
        Set<Integer> usedInd = new HashSet<>();
        int n= inp.length;
        for(int i=0;i<n;i++){
            int elm = inp[i];
           // int otherInd = elemInd.get(target-elm);
            if(elemInd.get(target-elm) != null && !usedInd.contains(inp[i]) && !usedInd.contains(target-elm)){//2 , 3,4,1
                //got the pair
                usedInd.add(inp[i]);
                usedInd.add( target-elm);
                resPair.add(new int[]{elm, target-elm});//{3,2}{4,1}

            }

            elemInd.put(elm,i);//{2,0},{3,1},{4,2},{1,3}




        }
        for (int[] pair : resPair) {
            System.out.print(Arrays.toString(pair) + " "); // Prints [2, 3] [1, 4] [0, 5]
        }
        System.out.println(resPair.size());


    }


}
