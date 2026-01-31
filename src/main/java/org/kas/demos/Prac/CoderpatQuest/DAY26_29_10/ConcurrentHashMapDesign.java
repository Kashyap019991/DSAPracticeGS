package org.kas.demos.Prac.CoderpatQuest.DAY26_29_10;

import java.util.concurrent.locks.ReentrantLock;
import java.util.HashMap;
import java.util.Map;

class ConcurrentHashMapDesign<K, V> {
    private final int SEGMENT_COUNT = 16; // Number of segments
    private final Map<K, V>[] segments;
    private final ReentrantLock[] locks;

    public ConcurrentHashMapDesign() {
        segments = new Map[SEGMENT_COUNT];
        locks = new ReentrantLock[SEGMENT_COUNT];
        for (int i = 0; i < SEGMENT_COUNT; i++) {
            segments[i] = new HashMap<>(); // Each segment is a regular HashMap
            locks[i] = new ReentrantLock();
        }
    }

    private int getSegmentIndex(Object key) {
        // Simple hash-based segment selection
        return Math.abs(key.hashCode() % SEGMENT_COUNT);
    }

    public void put(K key, V value) {
        int index = getSegmentIndex(key);
        locks[index].lock(); // Acquire lock for the specific segment
        try {
            segments[index].put(key, value);
        } finally {
            locks[index].unlock(); // Release lock
        }
    }

    public V get(K key) {
        int index = getSegmentIndex(key);
        // For read operations, you might not need to acquire a lock if using a
        // more sophisticated lock-free read approach, or a read lock.
        // For simplicity here, we assume a basic read, but in a true
        // ConcurrentHashMap, reads often don't block writers on other segments.
        return segments[index].get(key);
    }

    // Other methods like remove, containsKey, etc., would follow similar patterns
}