package org.kas.demos.Prac.practice_08_09_TO_12_09;

import java.util.Arrays;

public class RotateImage {
//ltc 48
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        // Swap elements across the main diagonal (matrix[i][j] with matrix[j][i])
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { // Start j from i to avoid double-swapping
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row of the matrix
        // Swap elements from the beginning and end of each row
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage solution = new RotateImage();

        // Example 1: 3x3 matrix
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Original Matrix 1:");
        printMatrix(matrix1);
        solution.rotate(matrix1);
        System.out.println("Rotated Matrix 1:");
        printMatrix(matrix1);
        System.out.println();

        // Example 2: 4x4 matrix
        int[][] matrix2 = {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };
        System.out.println("Original Matrix 2:");
        printMatrix(matrix2);
        solution.rotate(matrix2);
        System.out.println("Rotated Matrix 2:");
        printMatrix(matrix2);
    }

    // Helper method to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}