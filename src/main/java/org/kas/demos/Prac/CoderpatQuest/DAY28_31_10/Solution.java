package org.kas.demos.Prac.CoderpatQuest.DAY28_31_10;/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
 static int nonRepeatLongest(String str){

  int left =0, longest=0;
  Map<Character,Integer> posMap= new HashMap<>();
  for(int right=0;right<str.length();right++){
    if(posMap.containsKey(str.charAt(right))){
        
        left= posMap.get(str.charAt(right))+1;
    }
    posMap.put(str.charAt(right),right);
    longest = Math.max(longest, right-left+1);
  }
    return longest;
 }
  public static void main(String[] args) {
   String str = "abba";

  System.out.println(nonRepeatLongest(str));

       
  }
}

