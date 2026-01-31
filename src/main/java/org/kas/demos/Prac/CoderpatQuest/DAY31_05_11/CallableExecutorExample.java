package org.kas.demos.Prac.CoderpatQuest.DAY31_05_11;

import java.util.concurrent.*;

// Define a Callable task that returns a String
class MyCallableTask implements Callable<String> {
    private final String taskName;

    public MyCallableTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String call() throws Exception {
        System.out.println(taskName + " is executing in thread: " + Thread.currentThread().getName());
        // Simulate some work
        Thread.sleep(2000);
        if (taskName.equals("Task C")) {
            throw new RuntimeException("Simulated error in Task C");
        }
        return "Result from " + taskName;
    }
}

public class CallableExecutorExample {
    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool size
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Create Callable instances
        Callable<String> taskA = new MyCallableTask("Task A");
        Callable<String> taskB = new MyCallableTask("Task B");
        Callable<String> taskC = new MyCallableTask("Task C");

        // Submit Callable tasks to the ExecutorService and get Future objects
        Future<String> futureA = executorService.submit(taskA);
        Future<String> futureB = executorService.submit(taskB);
        Future<String> futureC = executorService.submit(taskC);

        try {
            // Retrieve results from Future objects. get() is blocking.
            System.out.println(futureA.get());
            System.out.println(futureB.get());
            System.out.println(futureC.get()); // This will throw an ExecutionException
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.err.println("Task interrupted: " + e.getMessage());
        } catch (ExecutionException e) {
            System.err.println("Task execution failed: " + e.getCause().getMessage());
        } finally {
            // Shut down the ExecutorService gracefully
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    executorService.shutdownNow(); // Force shutdown if not terminated
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}