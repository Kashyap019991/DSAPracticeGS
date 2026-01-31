package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
// You are given a string s, which contains stars *.
// In one operation, you can:
// •  Choose a star in s.
// •  Remove the closest non-star character to its left, as well as remove the star itself.
// Return the string after all stars have been removed.
// Note:
// •  The input will be generated such that the operation is always possible.
// •  It can be shown that the resulting string will always be unique.


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 * erase*****
 */

class RemoveStars {
  
  public static String removeStars(String str) {
    Stack<Character> stack = new Stack<>();

    //if we found * then remove top element from stack
    for(Character ch: str.toCharArray()){
      if(ch == '*' && !stack.isEmpty()){
        stack.pop();
      }
      else if(ch !='*'){
        stack.push(ch);
      }
    }
    StringBuilder result = new StringBuilder();
    for(Character ch:stack){
      result.append(ch);
    }

    return result.toString();
  }

  public static void main(String[] args) {
    HashMap<String, String> testcases = new HashMap<>();
    boolean flag = true;

  //******Test cases*********//

  testcases.put("erase*****","");
  testcases.put("a","a");
  testcases.put("goldmjk**ansb*acbe**hs","goldmansachs");
  /**************/

  for(Map.Entry<String, String> entry: testcases.entrySet()) {
    String actualOutput = removeStars(entry.getKey());
    if(!actualOutput.equals(entry.getValue())) {
      System.out.println("Test case failed for input:" + entry.getKey());
      flag = false;
    }
  }
  if (flag) {
    System.out.println("All testcases passed");
  }
  }
}
