package org.kas.demos.Prac.CoderpatQuest.DAY2_17_09;

public class SubArrayExceedsSum
{
  /**
   * Finds the length of the smallest contiguous subarray whose sum exceeds the target.
   * If no such subarray exists, it returns -1.
   *
   * @param arr The input array of integers.
   * @param target The target sum to exceed.
   * @return The length of the smallest subarray exceeding the target, or -1 if none exists.
   */
  public static int subArrayExceedsSum(int arr[], int target )
  {
    int minLength = Integer.MAX_VALUE; // Initialize with a very large value
    int currentSum = 0;
    int windowStart = 0;
//{10, 4, 2, 5, 6, 8} tget=15
    // Iterate through the array with a sliding window
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      currentSum += arr[windowEnd]; // Add the current element to the window sum

      // While the current sum exceeds the target, shrink the window from the left
      while (currentSum > target) {
        // Update the minimum length if the current window is smaller
        minLength = Math.min(minLength, windowEnd - windowStart + 1);
        currentSum -= arr[windowStart]; // Remove the element at the start of the window
        windowStart++; // Move the window start forward
      }
    }

    // If minLength is still MAX_VALUE, no such subarray was found
    return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
  }

  /**
   * Execution entry point.
   * Contains test cases to verify the correctness of subArrayExceedsSum.
   */
  public static void main(String[] args)
  {
   boolean result = true;
  int[] arr = { 1, 2, 3, 4 };
  result = result && subArrayExceedsSum( arr, 6 ) == 2; // Expected: {3,4} sum=7, length=2
  result = result && subArrayExceedsSum( arr, 12 ) == -1; // Expected: No subarray exceeds 12

  // Additional test cases
  int[] arr2 = {1, 1, 1, 1, 1, 1, 1, 1};
  result = result && subArrayExceedsSum(arr2, 5) == 6; // Expected: {1,1,1,1,1,1} sum=6, length=6

  int[] arr3 = {10, 4, 2, 5, 6, 8};
  result = result && subArrayExceedsSum(arr3, 15) == 3; // Expected: {10,4} sum=14 (not exceeding), {10,4,2} sum=16, length=3. Or {8,6} sum=14, {8,6,5} sum=19, length=3. Or {5,6,8} sum=19, length=3. Let's recheck the example. {10,4,2} sum = 16, length=3. {6,8} sum=14. {5,6,8} sum=19, length=3. The smallest is actually 2 for {10,6} (if we could skip elements) but for contiguous: {10,4,2} is 3. Let's assume the test case is based on a specific outcome.

  int[] arr4 = {1, 2, 3};
  result = result && subArrayExceedsSum(arr4, 0) == 1; // Expected: Any single element exceeds 0, smallest length is 1

  int[] emptyArr = {};
  result = result && subArrayExceedsSum(emptyArr, 5) == -1; // Expected: Empty array, no subarray

  if( result )
  {
    System.out.println("All tests pass\n");
  }
  else
  {
    System.out.println("There are test failures\n");
  }
  }
}