package org.kas.demos;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
//book my show, rapido, LRU
public class SlidingWindowRateLimiter {

    // A map to store user-specific request timestamps.
    // It's thread-safe for concurrent access.
    private final ConcurrentHashMap<String, ConcurrentLinkedQueue<Long>> userRequests;
    private final int maxRequests;
    private final long windowMillis;

    public SlidingWindowRateLimiter(int maxRequests, long windowSeconds) {
        this.userRequests = new ConcurrentHashMap<>();
        this.maxRequests = maxRequests;
        this.windowMillis = windowSeconds * 1000L;
    }

    /**
     * Attempts to acquire a token for the specified user.
     * @param userId The unique identifier for the user.
     * @return true if the request is allowed, false otherwise.
     */
    public boolean tryAcquire(String userId) {
        long currentTime = System.currentTimeMillis();
        // Use computeIfAbsent to ensure a queue is created atomically for a new user.
        ConcurrentLinkedQueue<Long> timestamps = userRequests.computeIfAbsent(userId, k -> new ConcurrentLinkedQueue<>());

        // Synchronize on the user's queue to prevent multiple threads from
        // modifying it at the same time for the same user.
        synchronized (timestamps) {
            // Step 1: Remove expired timestamps from the beginning of the queue.
            // This is the "sliding" part of the algorithm.
            long windowStart = currentTime - windowMillis;
            while (!timestamps.isEmpty() && timestamps.peek() < windowStart) {
                timestamps.poll();
            }

            // Step 2: Check if the request limit is exceeded.
            if (timestamps.size() < maxRequests) {
                timestamps.add(currentTime);
                return true;
            } else {
                return false;
            }
        }
    }

    // Example main method for demonstration
    public static void main(String[] args) throws InterruptedException {
        SlidingWindowRateLimiter limiter = new SlidingWindowRateLimiter(8, 10);
        String user1 = "user-1";
        String user2 = "user-2";

        System.out.println("Testing user-1 with 10 requests...");
        for (int i = 0; i < 10; i++) {
            if (limiter.tryAcquire(user1)) {
                System.out.println("User-1 Request " + (i + 1) + ": ACCEPTED");
            } else {
                System.out.println("User-1 Request " + (i + 1) + ": REJECTED");
            }
            Thread.sleep(100); // Wait for 100ms between requests
        }

        System.out.println("\nTesting user-2 concurrently...");
        for (int i = 0; i < 5; i++) {
            if (limiter.tryAcquire(user2)) {
                System.out.println("User-2 Request " + (i + 1) + ": ACCEPTED");
            } else {
                System.out.println("User-2 Request " + (i + 1) + ": REJECTED");
            }
            Thread.sleep(50);
        }

        System.out.println("\nWaiting for window to pass for user-1...");
        Thread.sleep(10000); // Wait for 10 seconds

        System.out.println("\nTesting user-1 again after window reset...");
        if (limiter.tryAcquire(user1)) {
            System.out.println("User-1 Request after reset: ACCEPTED");
        } else {
            System.out.println("User-1 Request after reset: REJECTED");
        }
    }
}
