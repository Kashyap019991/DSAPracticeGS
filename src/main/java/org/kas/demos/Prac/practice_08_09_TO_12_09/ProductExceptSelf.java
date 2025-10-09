package org.kas.demos.Prac.practice_08_09_TO_12_09;

import java.util.Arrays;
import java.util.Scanner;

public class ProductExceptSelf {
//lc 238
    public static int[] productExceptSelf(int[] nums) {
        //create product arra of left element except it self
        int n=nums.length;
        int[] left = new int[n];

        left[0] = 1;
        for(int i=1;i<n;i++){
            left[i] = left[i-1]*nums[i-1];
        }
        //multiply rightside prodct with left side will get final product
        int rightSideProduct =1;
        for(int i=n-1;i>=0;i--){
            left[i] = left[i] * rightSideProduct;
            rightSideProduct = nums[i]*rightSideProduct;
        }
        return left;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            nums[i] = scanner.nextInt();
        }

        int[] result = productExceptSelf(nums);

        System.out.println("Original Array: " + Arrays.toString(nums));
        System.out.println("Product of Array Except Self: " + Arrays.toString(result));

        scanner.close();
    }
}