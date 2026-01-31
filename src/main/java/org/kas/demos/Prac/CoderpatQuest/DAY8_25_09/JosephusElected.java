package org.kas.demos.Prac.CoderpatQuest.DAY8_25_09;

import java.util.ArrayList;
import java.util.List;

public class JosephusElected {
  
  /**
   * Solves the Josephus Problem by simulating the process with an ArrayList.
   * This approach is intuitive but less efficient for large n.
   *
   * @param n the number of students sitting in a circle.
   * @param k the length (in students) of each song.
   * @return the number of the student that is elected.
   */
  public static int whoIsElected_list(int n, int k) {
    // A list to represent the students in the circle, numbered 1 to n.
    List<Integer> students = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      students.add(i);
    }
    
    // The index of the student to be removed in the current round.
    int removalIndex = 0;
    
    // Continue until only one student is left.
    while (students.size() > 1) {
      // Calculate the index of the next student to remove.
      // (k - 1) because counting is 1-based, but list index is 0-based.
      // Modulo students.size() ensures we wrap around the circle.
      removalIndex = (removalIndex + k - 1) % students.size();
      
      // Remove the student at the calculated index.
      students.remove(removalIndex);
    }
    
    // The last remaining student is the president.
    return students.get(0);
  }
  
  /**
   * Solves the Josephus Problem using a mathematical formula.
   * This is a more efficient and optimized solution with O(n) time complexity.
   * The approach uses a recursive relationship:
   * J(n,k) = (J(n-1,k) + k) % n
   * where J(n,k) is the index (0-based) of the winner.
   * The result is converted back to 1-based indexing.
   *
   * @param n the number of students.
   * @param k the song length.
   * @return the number of the elected student.
   *
   */
  public static int whoIsElected_optimized(int n, int k) {
    int winner = 0; // Represents the 0-indexed winner for n=1.
    
    // Iteratively find the winner for increasing numbers of students.
    for (int i = 2; i <= n; i++) {
      // Apply the recursive formula.
      winner = (winner + k) % i;
    }
    
    // The problem uses 1-based indexing, so add 1 to the result.
    return winner + 1;
  }
  
  /**
   * This method uses the optimized solution to fulfill the original problem request.
   *
   * @param n the number of students sitting in a circle.
   * @param k the length (in students) of each song.
   * @return the number of the student that is elected.
   */
  public static int whoIsElected(int n, int k) {
    return whoIsElected_optimized(n, k);
  }

  /**
   * bool doTestsPass()
   * Runs various tests. Returns true if tests pass. Otherwise,
   * returns false.
   */
  public static boolean doTestsPass() {
    int[][] testCases = {
        {1, 1, 1},
        {2, 2, 1},
        {4, 2, 1},
        {100, 2, 73},
        {5, 3, 4},
        {6, 4, 5},
        {1000, 5, 763}
    };

    for (int[] testCase : testCases) {
      int answer = whoIsElected(testCase[0], testCase[1]);
      if (answer != testCase[2]) {
        System.out.println("Test failed!");
        System.out.printf("n:%d, k:%d, answer got: %d, should be: %d\n", testCase[0], testCase[1], answer, testCase[2]);
        return false;
      }
    }
    System.out.println("All tested passed");
    return true;
  }

  /**
   * Execution entry point.
   */
  public static void main(String args[]) {
    doTestsPass();
  }
}
