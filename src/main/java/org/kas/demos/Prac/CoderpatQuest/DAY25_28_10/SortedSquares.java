package org.kas.demos.Prac.CoderpatQuest.DAY25_28_10;
/*
Given a sorted array in increasing order containing both positive and negative values, return a sorted array with their squares.
I was given only 5 mins to solve it so I did it in O(nlogn)but interviewer wanted it in O(n)

{-3,-2,-1,1,2,4,6}
return array of squares in sorted order

public int[] getSquares(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        arr[i] = arr[i] * arr[i];
    }
    Arrays.sort(arr);
    return arr;
}
 */
import java.util.Arrays;

public class SortedSquares {

    public int[] getSquares(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int resultIndex = n - 1;
//{-3, -2, -1, 1, 2, 4, 6}
        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if (leftSquare > rightSquare) {
                result[resultIndex] = leftSquare;
                left++;
            } else {
                result[resultIndex] = rightSquare;
                right--;
            }
            resultIndex--;
        }

        return result;
    }

    public static void main(String[] args) {
        SortedSquares solution = new SortedSquares();
        int[] arr = {-3, -2, -1, 1, 2, 4, 6};
        
        int[] squares = solution.getSquares(arr);
        System.out.println(Arrays.toString(squares)); // Output: [1, 1, 4, 4, 9, 16, 36]
    }
}
