package org.kas.demos.Prac.CoderpatQuest.DAY14_07_10;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median_In_Stream_Of_Int {

    public static void printMedian(int arr[]) {
        // Max-heap to store the smaller half of the numbers
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap to store the larger half of the numbers
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            // Add element to appropriate heap
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            // Balance the heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            // Calculate and print median
            double median;
            if (maxHeap.size() == minHeap.size()) {
                median = (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                median = maxHeap.peek();
            }
            System.out.println("After reading " + num + " -> median - " + median);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
        printMedian(arr);
    }
}