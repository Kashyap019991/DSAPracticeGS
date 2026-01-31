package org.kas.demos.Prac.CoderpatQuest.Pending;

/*
 * Click `Run` to execute the snippet below!
 */

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Maxlector {
    static Integer[][] mem ;
    static int maxPathRecMem(int[][] mat,int rowInd,int colInd){
        int rows = mat.length;
        int cols = mat[0].length;

        if(rowInd == 0 && colInd == cols-1){
            return mat[rowInd][colInd];
        }
        if(rowInd < 0)
            return Integer.MIN_VALUE;

        if(colInd >cols-1)
            return Integer.MIN_VALUE;

        if(mem[rowInd][colInd] != null)
                return mem[rowInd][colInd];
        //System.out.println(rowInd +":"+colInd);
        int rowUp = maxPathRecMem(mat, rowInd-1, colInd);
        int colRight = maxPathRecMem(mat, rowInd, colInd+1);

        mem[rowInd][colInd] = mat[rowInd][colInd]+Math.max(rowUp,colRight);
        //System.out.println(mat[rowInd][colInd]);
        return mem[rowInd][colInd];

    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 1, 2},
                {2, 1, 0, 3},
                {3, 0, 1, 2}};
        int rows = mat.length;
        int cols = mat[0].length;
        mem = new Integer[rows+1][cols+1];
        /*for(int i=0;i<mat.length;i++){
            for(int j =0;j<mat[0].length;j++){
                mem[i][j] = mat[i][j];
            }
        }*/
        System.out.println(maxPathRecMem(mat,rows-1,0));


    }
}


// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!







