package org.kas.demos.Prac.CoderpatQuest.DAY31_05_11;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.lang.SecurityManager;
public class CustomThreadPoolExample {

    // Custom ThreadFactory to customize thread creation
    static class CustomThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        CustomThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "custom-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            System.out.println("Created new thread: " + t.getName());
            return t;
        }
    }

    // A simple task to be executed by the thread pool
    static class MyTask implements Runnable {
        private final int taskId;

        public MyTask(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskId + " running on thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(100); // Simulate some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        // Create a custom ThreadFactory
        ThreadFactory customThreadFactory = new CustomThreadFactory();

        // Create a ThreadPoolExecutor with custom parameters
        // corePoolSize: 2 (minimum number of threads)
        // maximumPoolSize: 5 (maximum number of threads)
        // keepAliveTime: 60 seconds (idle threads beyond corePoolSize will terminate after this time)
        // unit: TimeUnit.SECONDS
        // workQueue: new LinkedBlockingQueue<Runnable>() (unbounded queue for tasks)
        // threadFactory: customThreadFactory
        // handler: new ThreadPoolExecutor.CallerRunsPolicy() (handles rejected tasks by running them in the caller thread)
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,                      // corePoolSize
                5,                      // maximumPoolSize
                60,                     // keepAliveTime
                TimeUnit.SECONDS,       // unit
                new LinkedBlockingQueue<>(), // workQueue
                customThreadFactory,    // threadFactory
                new ThreadPoolExecutor.CallerRunsPolicy() // handler for rejected tasks
        );

        // Submit tasks to the executor
        for (int i = 0; i < 10; i++) {
            executor.execute(new MyTask(i));
        }

        // Shut down the executor gracefully
        executor.shutdown();
        try {
            // Wait for all tasks to complete or timeout
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // Force shutdown if tasks don't complete in time
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("Thread pool shut down.");
    }
}