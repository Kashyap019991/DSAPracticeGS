package org.kas.demos.Prac.CoderpatQuest.DAY6_23_09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Given an m*n matrix, print the matrix in reverse spiral form usingrecursion.
public class ReverseSpiralMatrix {

    /**
     * Main function to start the reverse spiral traversal using a recursive helper.
     *
     * @param matrix The input m x n matrix.
     */
    public void printReverseSpiral(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        // Start the recursive traversal with initial boundaries
        reverseSpiralHelper(matrix, 0, m - 1, 0, n - 1, result);

        // Print the stored elements in reverse order
        Collections.reverse(result);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Recursive helper function to traverse the matrix in a standard spiral form
     * and store elements in a list.
     *
     * @param matrix The input matrix.
     * @param top    The starting row index.
     * @param bottom The ending row index.
     * @param left   The starting column index.
     * @param right  The ending column index.
     * @param result A list to store the elements in spiral order.
     */
    private void reverseSpiralHelper(int[][] matrix, int top, int bottom, int left, int right, List<Integer> result) {
        // Base case: If boundaries cross, stop the recursion.
        if (top > bottom || left > right) {
            return;
        }

        // 1. Traverse top row from left to right
        for (int i = left; i <= right; i++) {
            result.add(matrix[top][i]);
        }
        top++;

        // 2. Traverse rightmost column from top to bottom
        for (int i = top; i <= bottom; i++) {
            result.add(matrix[i][right]);
        }
        right--;

        // 3. Traverse bottom row from right to left (if not a single row)
        if (top <= bottom) {
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
        }

        // 4. Traverse leftmost column from bottom to top (if not a single column)
        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        // Recursive call for the inner layer of the matrix
        reverseSpiralHelper(matrix, top, bottom, left, right, result);
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        ReverseSpiralMatrix solver = new ReverseSpiralMatrix();
        solver.printReverseSpiral(matrix);
    }
}
