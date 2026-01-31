package org.kas.demos.Prac.CoderpatQuest.DAY30_04_11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//  Find the best average grade.
//  Given a list of student test scores
//  Each student may have more than one test score in the list.


class BestAvgGradeStream
{
  public static Integer bestAvgGrade(String[][] scores)
  {

    Integer maxAverage = Arrays.stream(scores).collect(Collectors.groupingBy(
            e->e[0], Collectors.averagingDouble(e->Double.parseDouble(e[1]))
    ))
            .values()
            .stream()
            .map(e->(int)Math.floor(e)).max(Comparator.naturalOrder())
            .orElse(0);

    // Return the highest average grade found.
    return maxAverage;
  }


  public static boolean pass()
  {
    String[][] s1 = { { "Rohan", "84" },
               { "Sachin", "102" },
               { "Ishan", "55" },
               { "Sachin", "18" } };

    // The expected best average is 84 (Rohan's average is 84, Sachin's is (102+18)/2 = 60, Ishan's is 55).
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