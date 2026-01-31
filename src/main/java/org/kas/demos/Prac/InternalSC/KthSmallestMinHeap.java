package org.kas.demos.Prac.InternalSC;

import java.util.PriorityQueue;

public class KthSmallestMinHeap {

    public static int findKthSmallest(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        // Create a max-heap to store the k smallest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); 

        for (int num : arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the largest element if heap size exceeds k
            }
        }
        return maxHeap.peek(); // The root of the max-heap is the k-th smallest element
    }

    public static void main(String[] args) {
        int[] arr =  {7, 11, 9, 5, 13};;
        int k = 3;
        System.out.println("The " + k + "th smallest element is: " + findKthSmallest(arr, k)); // Output: 7
    }
}