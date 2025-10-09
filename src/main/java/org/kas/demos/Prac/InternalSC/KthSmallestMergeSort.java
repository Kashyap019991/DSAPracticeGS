package org.kas.demos.Prac.InternalSC;

public class KthSmallestMergeSort {
    public static void main(String[] args) {
        int[] arr = {7, 11, 9, 5, 13};
        int k=2;
        int ans = new KthSmallestMergeSort().findKthSmallest(arr,k);
        System.out.println("ans:" +ans);
    }
    // Main function to find the kth smallest element
    public int findKthSmallest(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid input array or k value.");
        }
        return mergeSortAndFindKth(arr, 0, arr.length - 1, k);
    }

    // Recursive merge sort function to find kth smallest
    private int mergeSortAndFindKth(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left]; // Base case: single element
        }

        int mid = left + (right - left) / 2;
        int result = -1; // Placeholder for the k-th smallest element

        // Recursively sort left and right halves
        int leftResult = mergeSortAndFindKth(arr, left, mid, k);
        int rightResult = mergeSortAndFindKth(arr, mid + 1, right, k);

        // If k-th element found in a sub-problem, propagate it
        if (leftResult != -1) return leftResult;
        if (rightResult != -1) return rightResult;

        // Merge the two sorted halves and find the k-th element
        return mergeAndFindKth(arr, left, mid, right, k);
    }

    // Merges two sorted sub-arrays and finds the k-th element
    private int mergeAndFindKth(int[] arr, int left, int mid, int right, int k) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int currentCount = 0; // Tracks the number of elements merged so far

        for (int p = left; p <= right; p++) {
            if (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[p] = L[i];
                    i++;
                } else {
                    arr[p] = R[j];
                    j++;
                }
            } else if (i < n1) {
                arr[p] = L[i];
                i++;
            } else {
                arr[p] = R[j];
                j++;
            }
            currentCount++;
            // If we've reached the k-th element during merging, return it
            if (currentCount == k) {
                return arr[p];
            }
        }
        return -1; // Should not be reached if k is valid
    }
}