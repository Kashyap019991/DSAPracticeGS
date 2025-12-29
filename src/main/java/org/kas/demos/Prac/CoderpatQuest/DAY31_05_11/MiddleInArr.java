package org.kas.demos.Prac.CoderpatQuest.DAY31_05_11;

public class MiddleInArr {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7,8};
        int slow = 0;
        int fast = 0;

        // Iterate until fast reaches or exceeds the end of the array
        // The condition `fast + 1 < arr.length` ensures that for even length arrays,
        // slow points to the first of the two middle elements.
        // For odd length arrays, slow points to the single middle element.
        //while (fast < arr.length - 1 && fast + 1 < arr.length) {
        while (fast < arr.length-1 ) {
            slow++;//1//2//3
            fast += 2;//2//4//6
        }

        System.out.println(arr[slow]);
    }
}