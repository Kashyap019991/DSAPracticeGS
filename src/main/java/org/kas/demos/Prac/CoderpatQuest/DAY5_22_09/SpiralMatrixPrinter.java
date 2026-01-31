package org.kas.demos.Prac.CoderpatQuest.DAY5_22_09;

public class SpiralMatrixPrinter {

    /**
     * Prints the elements of a 2D matrix in spiral order.
     *
     * @param matrix The 2D integer array to be printed.
     */
    //method 1:
    public static void printSpiral(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1. Traverse right (print top row)
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            // 2. Traverse down (print right column)
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            // 3. Traverse left (print bottom row), only if there's a row to print
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }

            // 4. Traverse up (print left column), only if there's a column to print
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }
    //method 2
    static void printSpiralMat(int[][] matrix){
        boolean lToR = true;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0;i<rows;i++){
            int start,end;
            if(lToR){
                start=0;
                end=cols;
                lToR=false;
                for(int j=start;j<cols;j++)
                    System.out.print(matrix[i][j]+" ");
            }
            else{
                start = cols-1;
                end=0;
                lToR=true;
                for(int j=start;j>=end;j--)
                    System.out.print(matrix[i][j]+" ");
            }
            //System.out.println();
        }

    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Printing matrix in spiral form:");
        //printSpiral(matrix); // Expected output: 1 2 3 6 9 8 7 4 5
        printSpiralMat(matrix);
    }
}
