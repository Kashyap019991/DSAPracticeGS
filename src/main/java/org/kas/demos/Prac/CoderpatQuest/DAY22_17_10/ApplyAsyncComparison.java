package org.kas.demos.Prac.CoderpatQuest.DAY22_17_10;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ApplyAsyncComparison {

    public static void main(String[] args) throws Exception {
        ExecutorService customExecutor = Executors.newFixedThreadPool(2);

        System.out.println("Main thread: " + Thread.currentThread().getName());

        // --- Example 1: using thenApply() ---
        System.out.println("\n--- Starting thenApply() chain ---");
        CompletableFuture<String> futureWithApply = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync() on thread: " + Thread.currentThread().getName());
            return "data";
        }).thenApply(result -> {
            // This runs on the same thread as the supplyAsync() task
            System.out.println("thenApply() on thread: " + Thread.currentThread().getName());
            return result.toUpperCase();
        });
        System.out.println("Result with thenApply(): " + futureWithApply.get());


        // --- Example 2: using thenApplyAsync() ---
        System.out.println("\n--- Starting thenApplyAsync() chain ---");
        CompletableFuture<String> futureWithApplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync() on thread: " + Thread.currentThread().getName());
            return "data";
        }).thenApplyAsync(result -> {
            // This runs on a new worker thread from the ForkJoinPool
            System.out.println("thenApplyAsync() on thread: " + Thread.currentThread().getName());
            return result.toUpperCase();
        });
        System.out.println("Result with thenApplyAsync(): " + futureWithApplyAsync.get());


        // --- Example 3: using thenApplyAsync(executor) ---
        System.out.println("\n--- Starting thenApplyAsync(executor) chain ---");
        CompletableFuture<String> futureWithCustomExecutor = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync() on thread: " + Thread.currentThread().getName());
            return "data";
        }).thenApplyAsync(result -> {
            // This runs on a thread from our custom thread pool
            System.out.println("thenApplyAsync(executor) on thread: " + Thread.currentThread().getName());
            return result.toUpperCase();
        }, customExecutor);
        System.out.println("Result with custom executor: " + futureWithCustomExecutor.get());

        customExecutor.shutdown();
    }
}
