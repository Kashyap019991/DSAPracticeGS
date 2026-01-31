package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09; /**
 *  
 *  e.g.
 *      for the input: "abbbccda" the longest uniform substring
 *      s "bbb" (which starts at index 1 and is 3 characters long).
 */

import java.lang.reflect.Array;
import java.util.*;

public class LongestUniformSubstring {

  private static final Map<String, int[]> testCases = new HashMap<String, int[]>();
//aabbbbbCdAA  start,length
  static int[] longestUniformSubstring(String input){
    int longestStart = -1;
    int longestLength = 0;
    int n=input.length();
    int left=0;
    //abcabcbb
    for(int right=0;right<n;right++){
      if(input.charAt(left) != input.charAt(right)){
        if(longestLength < (right-left))
        {
          longestLength=right-left;
          longestStart=left;
        }
        left=right;
      }
    }
    //to handle all same chars [aaa] {0,3}
    if(longestLength==0 && input.length()!=0){
      longestLength=input.length();
      longestStart=0;
    }
//last char
    if(longestLength < (n-1-left+1))
    {
      longestLength=n-1-left+1;
      longestStart=left;
    }
    return new int[]{ longestStart, longestLength };
  }

  static String getLongestUniformSubstr(String str){

    int left=0,currCount=0,longestStartInd=0,longestCount=0;
    int n=str.length();

    for(int right=0;right<n;right++){

      //System.out.println(currCount);
      if(str.charAt(left) != str.charAt(right)){
        if(longestCount< currCount){
          longestCount= currCount;
          longestStartInd = left;

        }
        currCount=1;
        left=right;
      }
      else{
        currCount++;
      }

    }
    if(longestCount< currCount){
      longestCount= currCount;
      longestStartInd = left;
    }
    System.out.println(longestStartInd +" "+ longestCount);
    return str.substring(longestStartInd,longestCount+longestStartInd);
  }
  public static void main(String[] args) {

    testCases.put("", new int[]{-1, 0});
    testCases.put("10000111", new int[]{1, 4});
    testCases.put("aabbbbbCdAA", new int[]{2, 5});
    testCases.put("aaa", new int[]{0, 3});
    testCases.put("a", new int[]{0, 1});
    testCases.put("abcde", new int[]{0, 1}); // All unique characters, so longest uniform is length 1
    testCases.put("aaaaaaaa", new int[]{0, 8});

    testCases.put("abcabcbb",new int[]{6,2});
    boolean pass = true;
    for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
      int[] result = longestUniformSubstring(testCase.getKey());
      System.out.println(Arrays.toString(result));
      pass = pass && (Arrays.equals(result, testCase.getValue()));
    }
    if(pass){
      System.out.println("Pass!");
    } else {
      System.out.println("Failed! ");
    }
  }
}