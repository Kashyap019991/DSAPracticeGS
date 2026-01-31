package org.kas.demos.Prac.practice_08_09_TO_12_09;

import java.util.HashSet;
import java.util.Set;

class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        
        int rows= matrix.length;
        int cols = matrix[0].length;

        //mark all zeros rows and cols
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j] ==0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        //start making rows as zero
        for(int row:rowSet){
            for(int j=0;j<cols;j++){
                matrix[row][j] =0;
            }
        }

        
        //start making cols as zero
        for(int col:colSet){
            for(int j=0;j<rows;j++){
                matrix[j][col] =0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new SetMatrixZeroes().setZeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}