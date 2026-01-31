package org.kas.demos.Prac.CoderpatQuest.DAY6_23_09;/*
 * Click `Run` to execute the snippet below!
 */

import java.util.*;
/* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */


/*
 **  Instructions:
 **
 **  Given a list of student test scores, find the best average score.
 **  Each student may have more than one test score in the list.
 **
 **  Complete the bestAverageGrade function in the editor below.
 **  It has one parameter, scores, which is an array of student test scores.
 **  Each element in the array is a two-element array of the form [student name, test score]
 **  e.g. [ "Bobby", "87" ].
 **  Test scores may be positive or negative integers.
 **
 **  If you end up with an average grade that is not an integer, you should
 **  use a floor function to return the largest integer less than or equal to the average.
 **  Return 0 for an empty input.
 **
 **  Example:
 **
 **  Input:
 **  [["Bobby", "87"],
 **   ["Charles", "100"],
 **   ["Eric", "64"],
 **   ["Charles", "22"]].
 **
 **  Expected output: 87
 **  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
 **  respectively. 87 is the highest.
 */

// class Solution {
//   /*
//    **  Find the best average grade.
//    */
//   public static int bestAverageGrade(String[][] scores) {
//     // TODO: implement this function

//     Map<String,int[]> sumMap = new HashMap<>();

//     for(String[] entry:scores){

//       String name = entry[0];
//       int score = Integer.parseInt(entry[1]);

//       if(!sumMap.containsKey(name)){
//           sumMap.put(name,new int[]{score,1});
//       }
//       else{
//         int[] data = sumMap.get(name);
//         data[0] +=score;
//         data[1]++;
//         sumMap.put(name,data);
//       }

//     }
//     int maxAvg=Integer.MIN_VALUE;
//     for(Map.Entry<String,int[]> entry:sumMap.entrySet()){

//       int currAvg =0;
//       int[] data = entry.getValue();
//       currAvg = data[0]/data[1];
//       maxAvg = Math.max(maxAvg,currAvg);
//     }


//     return maxAvg;
//   }

//   /*
//    **  Returns true if the tests pass. Otherwise, returns false;
//    */
//   public static boolean doTestsPass() {
//     // TODO: implement more test cases
//     String[][] tc1 = {
//         {"Bobby", "87"},
//         {"Charles", "100"},
//         {"Eric", "64"},
//         {"Charles", "22"}};

//       String[][] tc2 = {
//         {"Bobby", "87"},
//         {"Charles", "100"},
//         {"Eric", "64"},
//         {"Charles", "22.02"}};

//     //return bestAverageGrade(tc1) == 87;
//     return bestAverageGrade(tc2) == 87;
//   }

//   /*
//    **  Execution entry point.
//    */
//   public static void main(String[] args) {
//     // Run the tests
//     if (doTestsPass()) {
//       System.out.println("All tests pass");
//     }
//     else {
//       System.out.println("Tests fail.");
//     }
//   }
//}

/*
* Click `Run` to execute the snippet below!
There are n piles of bananas; the ith pile has piles[i] bananas. Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats them instead and will not eat any more bananas during this hour. Return the minimum integer k such that she can eat all the bananas within h hours.

Given :

1 <= piles.length <= 10^4

piles.length <= h <= 10^9

1 <= piles[i] <= 10^9

Input :

piles:[ 3, 6, 7, 11 ] and h=8
 //24/8
Output : k = 4

*/

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */


class FindMaxBananaPerHr {
    static class BananaPile {
        int[] pile;
        int h;
        BananaPile(int [] pile, int h) {
            this.pile = pile;
            this.h = h;
        }
    }
    //  piles:[ 3, 6, 7, 11 ] and h=8
    //24/8
//Output : k = 4
    public static int minEatingSpeed(int[] pile, int h) {
        int maxLimit =Integer.MAX_VALUE ;
        int n = pile.length;

        for(int i=0;i<n;i++){
            maxLimit = Math.max(maxLimit,pile[i]);
        }
        int left =1;
        System.out.println("maxLimit: "+maxLimit);

        while(left <maxLimit){
            int mid  = left + (maxLimit-left)/2;
            //System.out.println(mid);
            if(mid>0){
                int ansMid = maxBananaEat(mid,h,pile);
                if(ansMid <= h){
                    maxLimit = mid;
                }
                else if(ansMid > h){
                    left = mid+1;
                }
                System.out.println(left+" "+mid+" "+maxLimit);
            }
        }
        System.out.println(left);
        return left;
    }
    // piles:[ 3, 6, 7, 11 ] and h=8 for
    //24/8
//Output : k = 4
    static int maxBananaEat(int mid, int h, int[] pile){
        int res =0;

        for(int currPile:pile){
            // System.out.println(Math.floor(currPile/mid));
            //if()
            System.out.println(Math.ceil((double)7/3));

            double ans = Math.ceil((double)currPile/mid);
            System.out.println("cP"+currPile +" mid:"+mid+" "+ans);
            //System.out.println(ans);
            res += Math.ceil(ans);//3/2=1.2

        }
        System.out.println(mid +" r"+ res);
        return res;
    }
    public static void main(String[] args) {
        HashMap<BananaPile, Integer> testcases = new HashMap<>();
        boolean flag = true;

        //******Test cases*********//
        // feel free to add more testcases
        //testcases.put(new BananaPile(new int[]{3,6,7,11},8), 4);
        //testcases.put(new BananaPile(new int[]{30,11,23,4,20},5), 30);
         testcases.put(new BananaPile(new int[]{100},10), 10);
        testcases.put(new BananaPile(new int[]{3,6,7,11},100), 1);
        /**************/

        for(Map.Entry<BananaPile, Integer> entry: testcases.entrySet()) {
            int actualOutput = minEatingSpeed(entry.getKey().pile, entry.getKey().h);
            if(actualOutput != entry.getValue()) {
                String message = "Test case failed for pile %s and Hours %s";
                System.out.println(String.format(message,entry.getKey().pile, entry.getKey().h));
                flag = false;
            }
        }
        if (flag) {
            System.out.println("All testcases passed");
        } else{
            System.out.println("testcases failed");
        }
    }
}


