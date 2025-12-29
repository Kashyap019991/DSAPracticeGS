package org.kas.demos.Prac.CoderpatQuest.DAY25_28_10;/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 Given a String "aabbbbddccb" find the longest first repeating character with first index and its length.  (Input: “aabbbbddccb”  Output: [2,4] 2 is the index and 4 is the length)
 */

class PracticedLargestTree {
    static int getLongestTreeRoot(Map<Integer,Integer> childToPar){
        int longestRoot=-1;

        Set<Integer> allNodes = new HashSet<Integer>();

        Set<Integer> parentNodes =  new HashSet<>();
        for(Map.Entry<Integer,Integer> entry:childToPar.entrySet()){
            allNodes.add(entry.getKey());
            allNodes.add(entry.getValue());
            parentNodes.add(entry.getValue());
        }

        Map<Integer,List<Integer>> parentChildMap = new HashMap<>();

        for(Map.Entry<Integer,Integer> entry:childToPar.entrySet()){
            /* parentChildMap.computeIfAbsent(entry.getKey(), new ArrayList<>()).add(entry.getValue());
             */
            if(parentChildMap.get(entry.getKey()) == null){
                parentChildMap.put(entry.getKey(),new ArrayList<Integer>());
            }
            else
            {
                parentChildMap.get(entry.getKey()).add(entry.getValue());;
            }

        }

        //iterate parentNodes
        int maxLen=0;
        for(Integer parent:parentNodes){
            int currLent=findLengthTree(parent,parentChildMap);

            if(currLent > maxLen){
                maxLen = currLent;
                longestRoot = parent;
            }
            else if(currLent == maxLen){
                longestRoot = Math.min(parent,longestRoot);
            }

        }
        return longestRoot;
    }
    //put(1, 2);(1,3)
//put(3, 4);
//1->2,3
    static int findLengthTree(int parent,Map<Integer,List<Integer>> parChildMap)
    {
        int currLen=1;
        Map<Integer,List<Integer>> tempmap = new HashMap<>(parChildMap);
        List<Integer> childs = tempmap.get(parent);
        if(childs !=null){
            for(int currChild:childs){

                //childs.remove(currChild);
                currLen=findLengthTree(currChild,parChildMap);

            }
        }
        return currLen;

    }
    public static void main(String[] args) {
        Map<Integer, Integer> testCaseOneKey = new HashMap<>() {{
            put(1, 2);
            put(3, 4);
        }};

        System.out.println(getLongestTreeRoot(testCaseOneKey));
    }
}
