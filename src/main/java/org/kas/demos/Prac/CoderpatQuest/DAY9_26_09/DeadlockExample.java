package org.kas.demos.Prac.CoderpatQuest.DAY9_26_09;

public class DeadlockExample {

    // Two resource locks
    private static final Object Lock1 = new Object();
    private static final Object Lock2 = new Object();

    public static void main(String[] args) {
        // Thread 1 tries to lock Lock1 then Lock2
        Thread thread1 = new Thread(() -> {
            synchronized (Lock1) {
                System.out.println("Thread 1: Holding Lock1...");

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 1: Waiting for Lock2...");

                // This will block if Thread 2 holds Lock2
                synchronized (Lock2) {
                    System.out.println("Thread 1: Acquired Lock2!");
                }
            }
        });

        // Thread 2 tries to lock Lock2 then Lock1 (reverse order)
        Thread thread2 = new Thread(() -> {
            synchronized (Lock2) {
                System.out.println("Thread 2: Holding Lock2...");

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 2: Waiting for Lock1...");

                // This will block if Thread 1 holds Lock1
                synchronized (Lock1) {
                    System.out.println("Thread 2: Acquired Lock1!");
                }
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
