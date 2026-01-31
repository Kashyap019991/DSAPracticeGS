package org.kas.demos.Prac.CoderpatQuest.DAY9_26_09;

import java.util.*;
/**
 * Implement a custom HashMap `MyHashMap<K, V>` without using Java's built-in HashMap.
 * Use an ArrayList<LinkedList<Entry<K,V>>> to handle collisions.
 *
 * Requirements:
 * - Implement `put(K key, V value)` to insert or update a key-value pair.
 * - Implement `get(K key)` to retrieve the value for a given key, or null if not found.
 * - Implement `remove(K key)` to delete a mapping if present.
 * - Handle collisions using separate chaining (LinkedList).
 * - Maintain an initial capacity SIZE = 16 and a LOAD_FACTOR = 0.75.
 * - When the number of entries exceeds capacity * load factor, double the capacity and rehash existing entries.
 * - Implement `containsKey(K key)` and `containsValue(V value)`.
 * - Implement an `entrySet()` method that returns all key-value pairs.
 * - Ensure keys with identical hashCodes but unequal objects (e.g., "Aa" and "BB") are still handled correctly.
 * - Support null keys and null values.
 *
 * Example:
 * MyHashMap<String, Integer> map = new MyHashMap<>();
 * map.put("one", 1);
 * map.put("two", 2);
 * map.put("three", 3);
 * System.out.println(map.get("two")); // Output: 2
 *
 * // Collision scenario
 * map.put("Aa", 100);
 * map.put("BB", 200); // "Aa".hashCode() == "BB".hashCode() in Java
 * System.out.println(map.get("Aa")); // Output: 100
 * System.out.println(map.get("BB")); // Output: 200
 *
 * // Resizing
 * for (int i = 0; i < 20; i++) {
 *     map.put("key" + i, i);
 * }
 * System.out.println(map.get("key15")); // Should still work after rehash
 *
 * // Null handling
 * map.put(null, 999);
 * System.out.println(map.get(null)); // Output: 999
 */
public class CustomHashMap<K, V> {

    // Initial capacity and load factor
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    // Entry class to hold key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return key + "=" + value;
        }
    }

    private List<LinkedList<Entry<K, V>>> buckets;
    private int capacity;
    private int size;

    public CustomHashMap() {
        this.capacity = INITIAL_CAPACITY;
        this.buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    // Puts a key-value pair into the map

    // Computes index for a given key
    private int getBucketIndex(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode()) % capacity;
    }
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(index);

        for (Entry<K, V> entry : bucket) {
            if (Objects.equals(entry.key, key)) {
                // Update existing key
                entry.value = value;
                return;
            }
        }

        // Insert new entry
        bucket.add(new Entry<>(key, value));
        size++;

        // Resize if needed
        if (size >= capacity * LOAD_FACTOR) {
            resize();
        }
    }

    // Gets value associated with a key
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(index);

        for (Entry<K, V> entry : bucket) {
            if (Objects.equals(entry.key, key)) {
                return entry.value;
            }
        }
        return null;
    }

    // Removes key-value pair by key
    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(index);
        Iterator<Entry<K, V>> iterator = bucket.iterator();

        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (Objects.equals(entry.key, key)) {
                iterator.remove();
                size--;
                return;
            }
        }
    }

    // Returns true if the key is in the map
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // Returns true if the value exists in any entry
    public boolean containsValue(V value) {
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                if (Objects.equals(entry.value, value)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Returns a set of all entries in the map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                set.add(new AbstractMap.SimpleEntry<>(entry.key, entry.value));
            }
        }
        return set;
    }

    // Internal method to resize and rehash entries
    private void resize() {
        int oldCapacity = capacity;
        capacity = capacity * 2;
        List<LinkedList<Entry<K, V>>> oldBuckets = buckets;

        // Create new buckets
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<>());
        }

        size = 0;

        // Rehash all entries into new buckets
        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            for (Entry<K, V> entry : bucket) {
                put(entry.key, entry.value);
            }
        }
    }

    // For testing and debug purposes
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println(map.get("two")); // Output: 2

        // Collision scenario: "Aa".hashCode() == "BB".hashCode() in Java
        map.put("Aa", 100);
        map.put("BB", 200);
        System.out.println(map.get("Aa")); // Output: 100
        System.out.println(map.get("BB")); // Output: 200

        // Resizing
        for (int i = 0; i < 20; i++) {
            map.put("key" + i, i);
        }
        System.out.println(map.get("key15")); // Output: 15

        // Null handling
        map.put(null, 999);
        System.out.println(map.get(null)); // Output: 999

        // Contains methods
        System.out.println(map.containsKey("key10")); // true
        System.out.println(map.containsValue(15));    // true

        // Entry set
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
