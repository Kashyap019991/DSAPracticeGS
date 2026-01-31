package org.kas.demos.Prac.CoderpatQuest.DAY6_23_09;

import java.util.Arrays;

public class FloydCycleDetection {

    /**
     * Finds the length of a cycle in an integer array using the
     * tortoise and hare (Floyd's) cycle-finding algorithm.
     *
     * @param arr The integer array where each element points to the next index.
     * @param startIndex The starting index for the traversal.
     * @return The length of the cycle, or -1 if no cycle is found.
     */
    public int findCycleLength(int[] arr, int startIndex) {
        // Handle invalid array or start index
        if (arr == null || startIndex < 0 || startIndex >= arr.length) {
            return -1;
        }

        int slow = startIndex;
        int fast = startIndex;

        // Phase 1: Detect the cycle
        // Move the slow pointer one step, and the fast pointer two steps.
        while (true) {
            // Check for potential out-of-bounds access for the fast pointer's next move
            if (fast >= arr.length || arr[fast] >= arr.length) {
                return -1; // No cycle detected, fast pointer went out of bounds.
            }

            slow = arr[slow];
            fast = arr[arr[fast]];

            if (slow == fast) {
                break; // Cycle detected, pointers have met.
            }

            // Check for potential out-of-bounds access for the fast pointer's current position
            if (fast >= arr.length) {
                return -1; // No cycle detected.
            }
        }

        // Phase 2: Calculate the length of the cycle
        int cycleLength = 0;
        int current = slow; // Start a new pointer from the meeting point

        do {
            current = arr[current];
            cycleLength++;
        } while (current != slow); // Continue until we get back to the meeting point

        return cycleLength;
    }

    public static void main(String[] args) {
        FloydCycleDetection detector = new FloydCycleDetection();

        // Example 1: Cycle exists {1, 2, 0}, startIndex = 0
        int[] arr1 = {1, 2, 0};
        int startIndex1 = 0;
        System.out.printf("Array: %s, Start Index: %d%n", Arrays.toString(arr1), startIndex1);
        System.out.println("Cycle length: " + detector.findCycleLength(arr1, startIndex1)); // Expected: 3

        // Example 2: No cycle
        int[] arr2 = {1, 2, 3};
        int startIndex2 = 0;
        System.out.printf("Array: %s, Start Index: %d%n", Arrays.toString(arr2), startIndex2);
        System.out.println("Cycle length: " + detector.findCycleLength(arr2, startIndex2)); // Expected: -1
        
        // Example 3: Cycle later in the sequence
        int[] arr3 = {1, 2, 3, 4, 2}; // 2 -> 3 -> 4 -> 2...
        int startIndex3 = 0;
        System.out.printf("Array: %s, Start Index: %d%n", Arrays.toString(arr3), startIndex3);
        System.out.println("Cycle length: " + detector.findCycleLength(arr3, startIndex3)); // Expected: 3

        // Example 4: Array with no elements
        int[] arr4 = {};
        int startIndex4 = 0;
        System.out.printf("Array: %s, Start Index: %d%n", Arrays.toString(arr4), startIndex4);
        System.out.println("Cycle length: " + detector.findCycleLength(arr4, startIndex4)); // Expected: -1
    }
}