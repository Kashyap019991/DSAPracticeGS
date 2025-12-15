package org.kas.demos.Prac.CoderpatQuest.DAY2_17_09;

import java.util.*;

//  Find the best average grade.
//  Given a list of student test scores
//  Each student may have more than one test score in the list.


class BestAvgGrade
{
  public static Integer bestAvgGrade(String[][] scores)
  {
    // Handle the case of an empty or null input array.
    if (scores == null || scores.length == 0) {
      return 0; // Or throw an IllegalArgumentException, depending on desired behavior.
    }

    // Use a HashMap to store the total score and count of scores for each student.
    // The key is the student's name (String), and the value is an array of two integers:
    // index 0: total score, index 1: count of scores.
    Map<String, int[]> studentScores = new HashMap<>();

    // Iterate through the input array of scores.
    for (String[] scoreEntry : scores) {
      String studentName = scoreEntry[0];
      int score = Integer.parseInt(scoreEntry[1]);

      // If the student is already in the map, update their total score and count.
      if (studentScores.containsKey(studentName)) {
        int[] data = studentScores.get(studentName);
        //studentScores.get(studentName)[0]+=score;
        //studentScores.get(studentName)[1]++;
        data[0] += score; // Add the current score to the total.
        data[1]++;        // Increment the count of scores.
      } else {
        // If the student is not in the map, add them with their first score.
        studentScores.put(studentName, new int[]{score, 1});
      }
    }

    // Initialize the maximum average found so far to the smallest possible integer value.
    int maxAverage = Integer.MIN_VALUE;

    // Iterate through the entries in the studentScores map to calculate averages.
    for (Map.Entry<String, int[]> entry : studentScores.entrySet()) {
      int[] data = entry.getValue();
      int totalScore = data[0];
      int scoreCount = data[1];

      // Calculate the average for the current student using integer division.
      int currentAverage = totalScore / scoreCount;

      // Update maxAverage if the current student's average is higher.
      if (currentAverage > maxAverage) {
        maxAverage = currentAverage;
      }
    }

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