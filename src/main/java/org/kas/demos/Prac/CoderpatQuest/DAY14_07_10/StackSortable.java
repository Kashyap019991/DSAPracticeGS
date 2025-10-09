package org.kas.demos.Prac.CoderpatQuest.DAY14_07_10;

import java.util.Stack;

public class StackSortable {

    /**
     * Checks if an array of distinct elements (1 to n) is stack sortable.
     * An array is stack sortable if its elements can be moved to another
     * array in sorted order using a temporary stack.
     *
     * @param arr The input array of integers.
     * @return true if the array is stack sortable, false otherwise.
     */
    /*
    Given an array arr[] of n distinct elements, where each element is between 1 and n (inclusive), determine if it is stack-sortable.
Note: An array a[] is considered stack-sortable if it can be rearranged into a sorted array b[] using a temporary stack stk with the following operations:

Remove the first element from a[] and push it into stk.
Remove the top element from stk and append it to b[].
If all elements from a[] can be moved to b[] in this manner, ensuring that b[] is sorted in ascending order, then a[] is stack-sortable.

Examples:

Input: arr[] = [4, 1, 3, 2]
Output: Yes
Explanation: Elements are pushed and popped in the following order:

Push 4 (stk = [4])
Push 1 (stk = [4, 1]) -> Pop 1 to b = [1]
Push 3 (stk = [4, 3])
Push 2 (stk = [4, 3, 2]) -> Pop 2 to b = [1, 2]
Pop 3 to b = [1, 2, 3]
Pop 4 to b = [1, 2, 3, 4]
     */




        /**
         * Checks if an array of distinct elements (1 to n) is stack sortable.
         * An array is stack sortable if its elements can be moved to another
         * array in sorted order using a temporary stack.
         *
         * @param arr The input array of integers.
         * @return true if the array is stack sortable, false otherwise.
         */
        public static boolean isStackSortable(int[] arr) {
            if (arr == null || arr.length <= 1) {
                return true;
            }

            Stack<Integer> tempStack = new Stack<>();
            int n = arr.length;
            int expected = 1;

            // Iterate through the input array
            for (int element : arr) {
                tempStack.push(element);

                // Pop from the stack as long as the top element
                // matches the next number in the sorted sequence.
                while (!tempStack.isEmpty() && tempStack.peek() == expected) {
                    tempStack.pop();
                    expected++;
                }
            }

            // If the array is stack-sortable, the stack will be empty
            // at the end, and the expected counter will have reached n + 1.
            return tempStack.isEmpty();
        }

        public static void main(String[] args) {
            // Example 1: Stack sortable
            int[] arr1 = {3, 1, 2};
            System.out.println("Is " + java.util.Arrays.toString(arr1) + " stack sortable? " + isStackSortable(arr1)); // Expected: true

            // Example 2: Not stack sortable
            int[] arr2 = {3, 2, 1};
            System.out.println("Is " + java.util.Arrays.toString(arr2) + " stack sortable? " + isStackSortable(arr2)); // Expected: false

            // Example 3: Stack sortable
            int[] arr3 = {1, 2, 3};
            System.out.println("Is " + java.util.Arrays.toString(arr3) + " stack sortable? " + isStackSortable(arr3)); // Expected: true

            // Example 4: Not stack sortable (a smaller number after a larger one)
            int[] arr4 = {4, 2, 3, 1};
            System.out.println("Is " + java.util.Arrays.toString(arr4) + " stack sortable? " + isStackSortable(arr4)); // Expected: false

            // Example 5: Actually stack sortable
            int[] arr5 = {4, 1, 3, 2};
            System.out.println("Is " + java.util.Arrays.toString(arr5) + " stack sortable? " + isStackSortable(arr5)); // Expected: true
        }
    }


