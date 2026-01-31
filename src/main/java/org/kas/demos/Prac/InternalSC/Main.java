package org.kas.demos.Prac.InternalSC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int n;
    static int ans[]  = new int[n];

    public static void main(String[] args) {
    /*
    int[] arr = {7, 11, 9, 5, 13};
        int k = 3;
		o/p -> 9

		//wo sorting mtd


     */
        //7,11
        //7,9,5,11,13

        //7,11    9,5,13
        //7 11     9  5,13
        //7,11     9   5 13
        // 7,11         5 9 13
        //5,7,9,11,13
       /*
        int[] arr ={7, 11, 9, 5, 13};
        n=arr.length;

        int left=0,right=arr.length;
        int mid=(left+right)/2;
        //mergepart(left,mid,right);
        mergesort(arr, left,mid,n-1);
        mergesort(arr,mid+1,right,n-1);
        System.out.println(arr);
    */
        /*
        List<String> myList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if ("B".equals(s)) {
                iterator.remove(); // This is the correct way to remove during iteration
            }
        }
        System.out.println(myList);
*/
        /*
        List<String> myList1 = new ArrayList<>(Arrays.asList("A", "B", "C"));

        for (String s : myList1) { // Enhanced for-loop
            if ("B".equals(s)) {
                myList1.remove(s); // no concurrent modification exception
            }
        }
        System.out.println(myList1);
*/

        List<String> myList12 = new ArrayList<>(Arrays.asList("A", "B", "C"));

        //try {
            for (String s : myList12) {
                if ("B".equals(s)) {
                    myList12.remove(s);
                }
            }
        //} catch (java.util.ConcurrentModificationException e) {
            //System.out.println("Exception caught: " + e);
        //}

        System.out.println("Final list: " + myList12);



    }


   /* static void mergesort(int[] arr1,int left, int mid, int right){

        int i=0;
        if(arr1[left] < arr1[right]){
            if(left < mid) {
                ans[i] = arr1[left];
                left++;
            }
        }
        else{
            if(right > mid) {
                ans[i] = arr1[right];
                right--;
            }
        }


    }*/
}