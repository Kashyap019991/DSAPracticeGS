package org.kas.demos.Prac.CoderpatQuest.DAY37_14_11;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FindMaxTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 1000; // Threshold for sequential processing
    private int[] array;
    private int start, end;

    public FindMaxTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) { // Base case: process sequentially
            int max = Integer.MIN_VALUE;
            for (int i = start; i < end; i++) {
                max = Math.max(max, array[i]);
            }
            return max;
        } else { // Recursive case: divide and conquer
            int mid = start + (end - start) / 2;
            FindMaxTask leftTask = new FindMaxTask(array, start, mid);
            FindMaxTask rightTask = new FindMaxTask(array, mid, end);

            // Fork the left task and compute the right task directly
            leftTask.fork(); 
            int rightResult = rightTask.compute(); 
            int leftResult = leftTask.join(); // Wait for the left task to complete

            return Math.max(leftResult, rightResult);
        }
    }

    public static void main(String[] args) {
        int[] data = new int[100000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 100000);
        }

        ForkJoinPool pool = ForkJoinPool.commonPool();
        FindMaxTask task = new FindMaxTask(data, 0, data.length);
        long startTime = System.currentTimeMillis();
        Integer max = pool.invoke(task);
        long endTime = System.currentTimeMillis();

        System.out.println("Max element: " + max);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}