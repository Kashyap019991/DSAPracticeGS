package org.kas.demos.Prac.CoderpatQuest.DAY8_25_09;

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindSecondLargestPriorityQueue {

    /**
     * Finds the second largest element in an array using a PriorityQueue (Min-Heap).
     * This method is efficient for finding the k-th largest element and handles duplicates.
     *
     * @param arr The integer array to search.
     * @return The second largest distinct element, or -1 if no such element exists.
     */
    public static int findSecondLargest(int[] arr) {
        // Handle edge cases: null or arrays with fewer than two elements.
        if (arr == null || arr.length < 2) {
            System.out.println("Array must have at least two distinct elements.");
            return -1;
        }

        // A PriorityQueue in Java is a Min-Heap by default.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Use a Set to track elements already added, to handle duplicates.
        Set<Integer> distinctElements = new HashSet<>();

        // Iterate through the array.
        for (int num : arr) {
            // Add the element to the heap only if it's a distinct value.
            if (distinctElements.add(num)) {
                minHeap.add(num);
                // If the heap size exceeds 2, remove the smallest element.
                // This keeps the heap size to at most 2, holding the largest two distinct elements.
                if (minHeap.size() > 2) {
                    minHeap.poll();
                }
            }
        }
        
        // After iterating, if the heap has exactly two elements,
        // the smallest of the two (the heap's peek) is the second largest overall.
        if (minHeap.size() == 2) {
            return minHeap.peek();
        } else {
            // This case covers scenarios where there are fewer than two distinct elements.
            System.out.println("No distinct second largest element exists.");
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {14, 20, 6, 45, 99, 67};
        System.out.println("Second largest in " + Arrays.toString(arr1) + " is: " + findSecondLargest(arr1));

        int[] arr2 = {10, 10, 10, 10};
        System.out.println("Second largest in " + Arrays.toString(arr2) + " is: " + findSecondLargest(arr2));

        int[] arr3 = {5, 8, 2, 8, 1};
        System.out.println("Second largest in " + Arrays.toString(arr3) + " is: " + findSecondLargest(arr3));

        int[] arr4 = {5};
        System.out.println("Second largest in " + Arrays.toString(arr4) + " is: " + findSecondLargest(arr4));
    }
}
