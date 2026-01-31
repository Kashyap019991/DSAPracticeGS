package org.kas.demos.Prac.CoderpatQuest.DAY9_26_09;

import java.util.HashMap;
/**
 * Design and implement a Least Recently Used (LRU) Cache.
 * Your implementation should support the following operations in O(1) time:
 * - get(key): Return the value (if present), else return -1.
 * - put(key, value): Insert or update the value. If the cache exceeds its capacity, evict the least recently used entry.
 *
 * Example:
 * LRUCache cache = new LRUCache(2);
 * cache.put(1, 10);
 * cache.put(2, 20);
 * System.out.println(cache.get(1)); // Output: 10
 * cache.put(3, 30); // Evicts key 2
 * System.out.println(cache.get(2)); // Output: -1 (not found)
 * cache.put(4, 40); // Evicts key 1
 * System.out.println(cache.get(1)); // Output: -1 (not found)
 * System.out.println(cache.get(3)); // Output: 30
 * System.out.println(cache.get(4)); // Output: 40
 *
 * Constraints:
 * - Use a combination of HashMap and Doubly Linked List to achieve O(1).
 */
public class LRUCache1 {

    // Node class for doubly linked list
    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head, tail; // Dummy nodes for ease of list operations

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail nodes to avoid null checks
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    /**
     * Get the value of the key if present, else return -1.
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        moveToFront(node); // Mark as most recently used
        return node.value;
    }

    /**
     * Put the key-value pair into the cache.
     * If the key exists, update the value.
     * If the cache exceeds capacity, evict least recently used (LRU) item.
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update existing node and move it to front
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            if (map.size() >= capacity) {
                // Evict least recently used node (tail.prev)
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

            // Create new node and add it to the front
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToFront(newNode);
        }
    }

    // Move node to front (most recently used)
    private void moveToFront(Node node) {
        remove(node);
        addToFront(node);
    }

    // Add node right after head
    private void addToFront(Node node) {
        Node next = head.next;

        node.prev = head;
        node.next = next;

        head.next = node;
        next.prev = node;
    }
    //<--prev---n1--next--><--prev--n2--next-->

    // Remove a node from the list
    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public static void main(String[] args) {
        LRUCache1 cache = new LRUCache1(2);

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println("Value for key 1: " + cache.get(1)); // Returns 10, key 1 is now most recently used.

        cache.put(3, 30); // Cache is full, key 2 (least recently used) is removed.
        System.out.println("Value for key 2: " + cache.get(2)); // Returns -1 (not found).

        cache.put(4, 40); // Cache is full, key 1 (least recently used) is removed.
        System.out.println("Value for key 1: " + cache.get(1)); // Returns -1 (not found).
        System.out.println("Value for key 3: " + cache.get(3)); // Returns 30.
        System.out.println("Value for key 4: " + cache.get(4)); // Returns 40.
    }
}
