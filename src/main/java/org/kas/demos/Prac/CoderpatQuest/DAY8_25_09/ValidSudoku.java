package org.kas.demos.Prac.CoderpatQuest.DAY8_25_09;
//85
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    private static final int TARGET_SUM = 45;
    private static final int MATRIX_SIZE = 9;

    /**
     * Checks if a given 9x9 matrix is valid based on uniqueness and sum rules for each row and column.
     *
     * @param matrix The 9x9 integer matrix to be validated.
     * @return true if the matrix is valid, false otherwise.
     */
    public boolean isValidMatrix(int[][] matrix) {
        // Basic validation to ensure the matrix is 9x9.
        if (matrix == null || matrix.length != MATRIX_SIZE) {
            return false;
        }
        for (int[] row : matrix) {
            if (row.length != MATRIX_SIZE) {
                return false;
            }
        }

        // Iterate through each row and column simultaneously.
        for (int i = 0; i < MATRIX_SIZE; i++) {
            // Use HashSets to check for uniqueness in the current row and column.
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            int rowSum = 0;
            int colSum = 0;

            for (int j = 0; j < MATRIX_SIZE; j++) {
                // Get the value for the current row and column.
                int rowValue = matrix[i][j];
                int colValue = matrix[j][i];

                // --- Check Uniqueness ---
                // Add value to rowSet. If add() returns false, the value was already present.
                if (!rowSet.add(rowValue)) {
                    System.out.println("Invalid: Duplicate value " + rowValue + " found in row " + i);
                    return false;
                }
                // Add value to colSet. If add() returns false, the value was already present.
                if (!colSet.add(colValue)) {
                    System.out.println("Invalid: Duplicate value " + colValue + " found in column " + i);
                    return false;
                }

                // --- Check Sum ---
                rowSum += rowValue;
                colSum += colValue;
            }

            // After checking all elements in the row/column, verify the sum.
            if (rowSum != TARGET_SUM) {
                System.out.println("Invalid: Row " + i + " sum is " + rowSum + ", expected " + TARGET_SUM);
                return false;
            }
            if (colSum != TARGET_SUM) {
                System.out.println("Invalid: Column " + i + " sum is " + colSum + ", expected " + TARGET_SUM);
                return false;
            }
        }

        // If all rows and columns pass the checks, the matrix is valid.
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validator = new ValidSudoku();

        // --- Test Case 1: A valid 9x9 matrix (a solved Sudoku puzzle) ---
        int[][] validMatrix = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        System.out.println("Test Case 1 (Valid Matrix): " + validator.isValidMatrix(validMatrix)); // Expected: true

        // --- Test Case 2: Invalid due to duplicate in a row ---
        int[][] invalidRowDuplicate = {
            {5, 3, 4, 6, 7, 8, 9, 1, 1}, // Duplicate '1' in last row
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        System.out.println("\nTest Case 2 (Invalid Row Duplicate): " + validator.isValidMatrix(invalidRowDuplicate)); // Expected: false

        // --- Test Case 3: Invalid due to incorrect sum in a column ---
        int[][] invalidColSum = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        // Intentionally modify a column sum.
        invalidColSum[0][0] = 6; // changes a value, affecting both row and column sums
        System.out.println("\nTest Case 3 (Invalid Column Sum): " + validator.isValidMatrix(invalidColSum)); // Expected: false
    }
}
