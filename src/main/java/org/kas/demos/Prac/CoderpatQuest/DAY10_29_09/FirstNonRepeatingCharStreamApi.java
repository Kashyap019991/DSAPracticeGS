package org.kas.demos.Prac.CoderpatQuest.DAY10_29_09;/*
 * Click `Run` to execute the snippet below!
 */

import java.util.*;
import java.util.stream.Collectors;

    /**
  * Finds the first character that does not repeat anywhere in the input string
  * Given "apple", the answer is "a"
  * Given "racecars", the answer is "e"
  **/      
  
    
class FirstNonRepeatingCharStreamApi {
  static Optional<Character> getFirstrNonrepeatingChar(String str){
    
     Map<Character,Long> map =
      str.chars().mapToObj(ch -> (char)ch).
        collect(
          Collectors.groupingBy(entry -> entry,LinkedHashMap::new,
            Collectors.counting())
        );


      Optional<Character> ch =
        map.entrySet().stream().filter(entry -> entry.getValue()==1L).
        map(entry -> entry.getKey()).
        findFirst();

        return ch;

      

  }
  public static void main(String[] args) {
    String marks = "apple";
    System.out.println(getFirstrNonrepeatingChar(marks));

  }
}
