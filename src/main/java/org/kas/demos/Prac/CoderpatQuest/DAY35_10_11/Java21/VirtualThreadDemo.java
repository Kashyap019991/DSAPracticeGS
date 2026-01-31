package org.kas.demos.Prac.CoderpatQuest.DAY35_10_11.Java21;

public class VirtualThreadDemo {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Running on virtual thread: " + Thread.currentThread());
        Thread.startVirtualThread(task);
    }
}