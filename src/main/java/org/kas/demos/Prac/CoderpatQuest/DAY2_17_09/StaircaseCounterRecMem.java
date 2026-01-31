package org.kas.demos.Prac.CoderpatQuest.DAY2_17_09;

import java.util.Arrays;
/*

 ** There is a staircase with 'n' number of steps. A child
 ** walks by and wants to climb up the stairs, starting at
 ** the bottom step and ascending to the top.instead
 ** of taking 1 step at a time, it will vary between taking
 ** either 1, 2 or 3 steps at a time.
 ** Given 'n' number of steps below method should find
 ** number of
 ** unique combinations the child could traverse.
 ** An example would be countSteps(3) == 4:
 ** 1 1 1
 ** 2 1
 ** 1 2
 ** 3
 */
class StaircaseCounterRecMem {
  static int[] dp;
  static int countSteps(int n){
    //base cas
    if(n<0) return 0;
    if(n==0 || n==1) return 1;
    if(dp[n] !=-1) return dp[n];

    dp[n] = countSteps(n-1)+countSteps(n-2)+countSteps(n-3);

    return dp[n];
  }
  public static void main(String[] args) {
     int numberOfSteps = 3;
      dp = new int[numberOfSteps+1];
      Arrays.fill(dp, -1);
        int combinations = countSteps(numberOfSteps);


        System.out.println("For " + numberOfSteps + " steps, there are " + combinations + " unique combinations."); // Output: 4

  }
}
