package org.kas.demos.Prac.CoderpatQuest.DAY27_30_10;

public class RotationPointFinder {
//Write a Java program: Given a rotated sorted array.
//Example:
//Input: 1, 2, 3, 4, 5 4, 5, 1, 2, 3
//Task: Find the element where the array is rotated (rotation point)
    /**
     * Finds the index of the rotation point (minimum element) in a rotated sorted array.
     * Uses a modified binary search approach with O(log n) time complexity.
     *
     * @param arr The rotated sorted array of distinct integers.
     * @return The index of the rotation point.
     */
    public static int findRotationPoint(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // Indicate error or empty array
        }

        int low = 0;
        int high = arr.length - 1;

        // If the array is not rotated (or rotated n times), the minimum is the first element
        if (arr[low] <= arr[high]) {
            return low;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            // The rotation point is where the element at 'mid' is greater than the element immediately after it.
            // This condition is an early exit and correctly identifies the start of the second sorted segment.
            if (mid < high && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }
//{4, 5, 1, 2, 3}
            //{7, 8, 9, 1, 2, 3, 4, 5, 6}
            // If arr[low] is less than or equal to arr[mid], the left half is sorted.
            // The minimum must be in the right half.
            /*if (arr[low] <= arr[mid]) {
                low = mid + 1;
            } else {
                // Otherwise, the right half is sorted, and the minimum could be mid itself or to its left.
                high = mid;
            }*/
            if(arr[mid] < arr[high]){
                high=mid;
            }
            else{
                low= mid+1;
            }
        }

        return low; // When low == high, we have found the rotation point index.
    }

    public static void main(String[] args) {
        int[] input1 = {4, 5, 1, 2, 3}; // Original: {1, 2, 3, 4, 5}, rotated at index 2
        int[] input2 = {7, 8, 9, 1, 2, 3, 4, 5, 6}; // Rotated at index 3
        int[] input3 = {1, 2, 3, 4, 5}; // Not rotated

        int rotationIndex1 = findRotationPoint(input1);
        System.out.println("Input 1: " + java.util.Arrays.toString(input1));
        System.out.println("Rotation point index: " + rotationIndex1);
        System.out.println("Element at rotation point: " + input1[rotationIndex1]);

        System.out.println("\nInput 2: " + java.util.Arrays.toString(input2));
        int rotationIndex2 = findRotationPoint(input2);
        System.out.println("Rotation point index: " + rotationIndex2);
        System.out.println("Element at rotation point: " + input2[rotationIndex2]);

        System.out.println("\nInput 3: " + java.util.Arrays.toString(input3));
        int rotationIndex3 = findRotationPoint(input3);
        System.out.println("Rotation point index: " + rotationIndex3);
        System.out.println("Element at rotation point: " + input3[rotationIndex3]);
    }
}
