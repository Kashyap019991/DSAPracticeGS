package org.kas.demos.Prac.CoderpatQuest.DAY3_18_09;

import java.util.HashMap;

public class CountLengthOfCycle {

  /**
   * Finds the length of a cycle in an integer array starting from a given index.
   * This method uses a HashMap to store visited indices and the step at which they were visited.
   *
   * @param arr The integer array where each element points to the next index.
   * @param startIndex The starting index for the traversal.
   * @return The length of the cycle, or -1 if no cycle is found.
   */
  public static int countLengthOfCycle(int[] arr, int startIndex) {
    // A HashMap is used to track visited indices and the step number when they were first visited.
    HashMap<Integer, Integer> visitedIndices = new HashMap<>();
    
    int currentIndex = startIndex;
    int step = 0;

    // The loop continues as long as we are within the array bounds.
    while (currentIndex >= 0 && currentIndex < arr.length) {
      // Check if the current index has been visited before.
      if (visitedIndices.containsKey(currentIndex)) {
        // If it has, a cycle is detected. The length of the cycle is the difference
        // between the current step and the step when the cycle was first entered.
        return step - visitedIndices.get(currentIndex);
      }

      // If the index has not been visited, store it in the map with the current step number.
      visitedIndices.put(currentIndex, step);
      
      // Move to the next index as specified by the array value.
      currentIndex = arr[currentIndex];
      
      // Increment the step counter.
      step++;
    }

    // If the loop finishes without finding a cycle (i.e., we go out of bounds),
    // it means there is no cycle.
    return -1;
  }

  public static void main(String[] args) {
    boolean testsPassed = true;
    
    // Test case 1: A simple 2-element cycle.
    testsPassed &= countLengthOfCycle(new int[]{1, 0}, 0) == 2;
    
    // Test case 2: A simple 3-element cycle.
    testsPassed &= countLengthOfCycle(new int[]{1, 2, 0}, 0) == 3;
    
    // Test case 3: A path that leads into a cycle.
    testsPassed &= countLengthOfCycle(new int[]{1, 2, 3, 1}, 0) == 3;
    
    // Test case 4: No cycle, path goes out of bounds.
    testsPassed &= countLengthOfCycle(new int[]{1, 2, 3, 4}, 0) == -1;

    // Test case 5: Starting index is already out of bounds.
    testsPassed &= countLengthOfCycle(new int[]{1, 2, 3, 4}, 5) == -1;
    
    if (testsPassed) {
      System.out.println("Test passed.");
    } else {
      System.out.println("Test failed.");
    }
  }
}