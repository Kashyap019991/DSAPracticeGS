package org.kas.demos.Prac.CoderpatQuest.DAY32_06_11;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class SlidingWindowLogRateLimiter {
    private final int maxRequests;
    private final long windowSizeInMillis;
    // Map to store request timestamps for each client, using a thread-safe Queue
    private final Map<String, ConcurrentLinkedQueue<Long>> requestLogs = new ConcurrentHashMap<>();

    public SlidingWindowLogRateLimiter(int maxRequests, long windowSize, TimeUnit unit) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = unit.toMillis(windowSize);
    }

    public boolean allowRequest(String clientId) {
        long currentTime = System.currentTimeMillis();
        // Ensure a queue exists for the client ID
        requestLogs.putIfAbsent(clientId, new ConcurrentLinkedQueue<>());
        ConcurrentLinkedQueue<Long> timestamps = requestLogs.get(clientId);

        // Remove expired timestamps from the front of the queue
        while (!timestamps.isEmpty() && currentTime - timestamps.peek() > windowSizeInMillis) {
            timestamps.poll();
        }

        // Check if the current request count exceeds the limit
        if (timestamps.size() < maxRequests) {
            // Add the new request timestamp and allow the request
            timestamps.add(currentTime);
            return true;
        } else {
            // Deny the request
            return false;
        }
    }
}
