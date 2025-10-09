package org.kas.demos.Prac.CoderpatQuest.DAY7_24_09;

import java.util.*;
public class FindFrstRepeatedWord {

  
   //Find the first repeated word in a string. Input : "Ravi had been saying that he had been there" .Output : had
  public static String getFindFrstRepeatedWord(String str){
    StringBuilder res = new StringBuilder();

    String[] splitStrs= str.split(" ");
    Set<String> seenSet = new HashSet<>();
    for(int i=0;i<splitStrs.length;i++){

        if(seenSet.contains(splitStrs[i])){
          return splitStrs[i];
        }
        seenSet.add(splitStrs[i]);
      
    }
    return "";
  }

  


  public static void main(String[] args) {

    String str = "Ravi had been saying that he had been there";
    String res = getFindFrstRepeatedWord(str);
    System.out.println(res);
  }
}


