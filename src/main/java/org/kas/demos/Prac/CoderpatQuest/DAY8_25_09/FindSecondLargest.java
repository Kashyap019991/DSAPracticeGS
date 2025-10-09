package org.kas.demos.Prac.CoderpatQuest.DAY8_25_09;

import java.util.Arrays;

public class FindSecondLargest {

    public static void main(String[] args) {
        int[] numbers = {14, 20, 6, 45, 99, 99, 67};
        
        System.out.println("Input Array: " + Arrays.toString(numbers));
        
        try {
            // Method 1: Using a single pass (most efficient)
            System.out.println("\n--- Method 1: Single Pass ---");
            int secondLargest1 = findSecondLargestSinglePass(numbers);
            if (secondLargest1 != Integer.MIN_VALUE) {
                System.out.println("Second largest element: " + secondLargest1);
            } else {
                System.out.println("No distinct second largest element found.");
            }

            // Method 2: Using sorting
            System.out.println("\n--- Method 2: Using Sorting ---");
            int secondLargest2 = findSecondLargestWithSorting(numbers);
            if (secondLargest2 != Integer.MIN_VALUE) {
                System.out.println("Second largest element: " + secondLargest2);
            } else {
                System.out.println("No distinct second largest element found.");
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Finds the second largest element in an array using a single pass.
     * This is the most efficient method with a time complexity of O(n).
     * It handles duplicate numbers and edge cases like an array with fewer than two elements.
     *
     * @param arr The integer array to search.
     * @return The second largest element, or Integer.MIN_VALUE if no distinct second largest exists.
     */
    public static int findSecondLargestSinglePass(int[] arr) {
        // Handle edge case where the array is too small
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                // If a new largest element is found, the old largest becomes the new second largest.
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                // If the number is between the largest and second largest, it becomes the new second largest.
                secondLargest = num;
            }
        }
        
        // This check handles cases like {5, 5, 5} where no distinct second largest exists.
        if (secondLargest == Integer.MIN_VALUE) {
             throw new IllegalArgumentException("No distinct second largest element found.");
        }
        
        return secondLargest;
    }

    /**
     * Finds the second largest element in an array by sorting.
     * This is a simple and readable approach but is less efficient, with a time complexity of O(n log n).
     *
     * @param arr The integer array to search.
     * @return The second largest element, or Integer.MIN_VALUE if no distinct second largest exists.
     */
    public static int findSecondLargestWithSorting(int[] arr) {
        // Handle edge case where the array is too small.
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }

        // Create a copy to avoid modifying the original array.
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr); // Sorts in ascending order.

        // Iterate backward from the second-to-last element to find a distinct value.
        for (int i = sortedArr.length - 2; i >= 0; i--) {
            if (sortedArr[i] < sortedArr[sortedArr.length - 1]) {
                return sortedArr[i];
            }
        }
        
        // If all elements are the same, no distinct second largest exists.
        throw new IllegalArgumentException("No distinct second largest element found.");
    }
}
