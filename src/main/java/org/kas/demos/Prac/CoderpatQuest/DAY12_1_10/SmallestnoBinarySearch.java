package org.kas.demos.Prac.CoderpatQuest.DAY12_1_10;

public class SmallestnoBinarySearch {
    //Given a program to reverse a string which is incorrect. Need todebug and fix it to run executing all test cases successfully
//Find the smallest number in array that has been rotated
//For example - Array {3,4,5,6,1,2} returns 1
//create pq--> max heap
//k=1 pq.size>k pop max element
    public static void main(String[] args) {


        int[] arr = {2,3,4,5,6,2,2};//{1,2,2,3,4};
        int left = 0, right = arr.length - 1;
        if (arr[left] < arr[right])
            System.out.println(arr[left]);
        int mid = -1;
        while (left < right) {
            mid = left + (right - left) / 2;
            System.out.println("mid:" + mid);
            if (arr[mid] > arr[right]) {
                left = mid + 1;
                System.out.println("left:" + left);
            } else {
                right = mid;
                System.out.println("right:" + right);
            }
        }

        System.out.println(arr[left]);
        //for second smallest element
        for(int i=0;i<arr.length;i++){
            if(arr[i] != arr[left]){
                System.out.println(arr[i]);
                break;
            }
        }
    }

}