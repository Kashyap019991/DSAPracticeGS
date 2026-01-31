package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09;

public class SmallestnoInRotatedSortedArr {
  /**
   * Returns the smallest number in a rotated sorted array.
   * This function uses a modified binary search for an efficient O(log n) solution.
   *
   * @param a The input array of integers, which has been rotated.
   * @return The smallest number in the array.
   * @throws IllegalArgumentException if the input array is null or empty.
   */
  public static int FindMin(int a[]) {
    // Handle edge cases for null or empty arrays.
    if (a == null || a.length == 0) {
      throw new IllegalArgumentException("Input array cannot be null or empty.");
    }

    int left = 0;
    int right = a.length - 1;

    // The loop continues as long as the search space contains more than one element.
    while (left < right) {
      // If the subarray is sorted, the minimum is the leftmost element.
      if (a[left] <= a[right]) {
        return a[left];
      }
//5, 1, 2, 3, 4
      //1,2,3,4,5
      //3,4,5,1,2
      int mid = left + (right - left) / 2;

      // If the middle element is greater than the right element,
      // the minimum must be in the right half (including mid + 1).
      if (a[mid] > a[right]) {
        left = mid + 1;
      }
      // Otherwise, the minimum is in the left half (including mid).
      else {
        right = mid;
      }
    }

    // When left == right, we have found the minimum element.
    return a[left];
  }

  public static void main(String args[]) {
    boolean result = true;

    // Test cases for rotated arrays
    result = result && FindMin(new int[]{3, 4, 5, 6, 1, 2}) == 1;
    result = result && FindMin(new int[]{2, 1}) == 1;
    result = result && FindMin(new int[]{1}) == 1;
    result = result && FindMin(new int[]{1, 2, 3, 4, 5}) == 1;
    result = result && FindMin(new int[]{5, 1, 2, 3, 4}) == 1;
    result = result && FindMin(new int[]{4, 5, 1, 2, 3}) == 1;

    // Test for null array to catch the expected exception
    try {
      FindMin(null);
      result = false; // Test should have thrown an exception, so this is a failure.
    } catch (IllegalArgumentException e) {
      System.out.println("Null array test passed.");
    }

    if (result) {
      System.out.println("All tests pass");
    } else {
      System.out.println("There are test failures");
    }
  }
}
