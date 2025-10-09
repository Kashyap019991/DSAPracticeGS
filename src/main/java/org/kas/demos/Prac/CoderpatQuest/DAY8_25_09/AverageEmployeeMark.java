package org.kas.demos.Prac.CoderpatQuest.DAY8_25_09;

import java.util.*;
class AverageEmployeeMark
{
  public static Integer bestAvgGrade(String[][] scores)
  {
    // write your code goes here
    Map<String,Integer[]> avgGrade = new HashMap<>();

    for(String[] entity:scores){
      int marks = Integer.parseInt(entity[1]);
      if(!avgGrade.containsKey(entity[0])){
        avgGrade.put(entity[0],new Integer[]{0,0});
      }
      Integer[] sumCount = avgGrade.get(entity[0]);
      sumCount[0] += marks;
      sumCount[1]++;
    }
    //find best avg
    int bestAvg=0;
    for(Map.Entry<String,Integer[]> entry:avgGrade.entrySet()){
      Integer[] marksCount = entry.getValue();
      bestAvg = Math.max(bestAvg,marksCount[0]/marksCount[1]);

    }
    return bestAvg;
  }

  public static boolean pass()
  {
    String[][] s1 = { { "Rohan", "84" },
               { "Sachin", "102" },
               { "Ishan", "55" },
               { "Sachin", "18" } };

    return bestAvgGrade(s1) == 84;
  }

  public static void main(String[] args)
  {
    if(pass())
    {
      System.out.println("Pass");
    }
    else
    {
      System.out.println("Some Fail");
    }
  }
}