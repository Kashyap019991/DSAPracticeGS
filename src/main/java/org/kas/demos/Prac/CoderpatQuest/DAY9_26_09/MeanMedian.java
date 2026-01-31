package org.kas.demos.Prac.CoderpatQuest.DAY9_26_09;

import java.util.Arrays;

public class MeanMedian {

    /**
     * Calculates the mean (average) of the elements in an array.
     *
     * @param arr The input array of integers.
     * @return The mean of the array as a double.
     */
    public static double findMean(int[] arr) {
        // Handle empty or null arrays to avoid division by zero
        if (arr == null || arr.length == 0) {
            return 0.0;
        }

        // Initialize sum
        long sum = 0;

        // Iterate through the array and add each element to the sum
        for (int num : arr) {
            sum += num;
        }

        // Return the sum divided by the number of elements
        return (double) sum / arr.length;
    }

    /**
     * Calculates the median of the elements in an array.
     * The array is sorted first to find the middle element(s).
     *
     * @param arr The input array of integers.
     * @return The median of the array as a double.
     */
    public static double findMedian(int[] arr) {
        // Handle empty or null arrays
        if (arr == null || arr.length == 0) {
            return 0.0;
        }

        // Get the size of the array
        int n = arr.length;

        // Create a copy of the array to avoid modifying the original
        int[] sortedArr = Arrays.copyOf(arr, n);

        // Sort the array in ascending order
        Arrays.sort(sortedArr);

        // Check if the number of elements is odd or even
        if (n % 2 != 0) {
            // If odd, the median is the middle element
            return (double) sortedArr[n / 2];
        } else {
            // If even, the median is the average of the two middle elements
            int middle1 = sortedArr[n / 2 - 1];
            int middle2 = sortedArr[n / 2];
            return (double) (middle1 + middle2) / 2.0;
        }
    }

    public static void main(String[] args) {
        // Example with an odd-sized array
        int[] oddArray = {8, 1, 7, 4, 3};
        System.out.println("Odd-sized array: " + Arrays.toString(oddArray));
        System.out.println("Mean: " + findMean(oddArray));
        System.out.println("Median: " + findMedian(oddArray));

        System.out.println(); // Add a newline for better readability

        // Example with an even-sized array
        int[] evenArray = {9, 2, 5, 6, 1};
        System.out.println("Even-sized array: " + Arrays.toString(evenArray));
        System.out.println("Mean: " + findMean(evenArray));
        System.out.println("Median: " + findMedian(evenArray));
    }
}
