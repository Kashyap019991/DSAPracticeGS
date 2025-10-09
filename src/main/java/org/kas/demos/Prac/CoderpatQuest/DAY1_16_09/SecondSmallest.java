package org.kas.demos.Prac.CoderpatQuest.DAY1_16_09;

public class SecondSmallest {
    public static int secondSmallest(int[] x) {

        if (x.length < 2) {
            return (0);
        }
//{4, 5, 6, 7, 0, 1, 2};
        int smallestElem=Integer.MAX_VALUE,secSmall=Integer.MAX_VALUE;

        for(int i=0;i<x.length;i++){
            int currElem = x[i];
            if(currElem<smallestElem){
                secSmall=smallestElem;
                smallestElem=currElem;
            }
            else if(currElem<secSmall){
                secSmall=currElem;
            }
        }

        return secSmall;
    }

    public static void main(String args[]) {
/*
        int[] a = { 0 };
        int[] b = { 0, 1 };

        boolean result = true;
        result &= secondSmallest(a) == 0;
        result &= secondSmallest(b) == 1;

        if (result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
*/
        int[] arr1 = {4, 5, 6, 7, 0, 1, 2}; // Rotated sorted array
        System.out.println("Second smallest in arr1: " + secondSmallest(arr1)); // Expected: 1


    }
}