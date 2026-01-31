package org.kas.demos.Prac.CoderpatQuest.DAY9_26_09;

public class LinkedListCycleDetector {

    // Definition for singly-linked list node.
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /**
     * Detects if a linked list has a cycle using Floyd's Cycle-Finding Algorithm.
     * This algorithm uses two pointers, a 'slow' pointer and a 'fast' pointer.
     * The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.
     * If there is a cycle, the fast pointer will eventually catch up to the slow pointer.
     * If there is no cycle, the fast pointer will reach the end of the list (null).
     *
     * @param head The head node of the linked list.
     * @return true if a cycle is detected, false otherwise.
     */
    public boolean hasCycle(Node head) {
        // If the list is empty or has only one node, a cycle cannot exist.
        if (head == null || head.next == null) {
            return false;
        }

        // Initialize slow and fast pointers.
        Node slow = head;
        Node fast = head;

        // Traverse the list with slow and fast pointers.
        // The loop continues as long as fast and fast.next are not null,
        // which ensures that fast doesn't go out of bounds before checking fast.next.
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }

        // If the loop finishes without slow and fast meeting, it means fast reached null,
        // indicating no cycle in the linked list.
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycleDetector detector = new LinkedListCycleDetector();

        // Create a linked list with a loop: 1 -> 2 -> 3 -> 4 -> 2 (loop back to 2)
        Node headWithLoop = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        headWithLoop.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a loop

        System.out.println("Linked list with loop has cycle: " + detector.hasCycle(headWithLoop)); // Expected: true

        // Create a linked list without a loop: 5 -> 6 -> 7 -> 8
        Node headWithoutLoop = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        headWithoutLoop.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null; // No loop

        System.out.println("Linked list without loop has cycle: " + detector.hasCycle(headWithoutLoop)); // Expected: false

        // Create an empty linked list
        Node emptyList = null;
        System.out.println("Empty linked list has cycle: " + detector.hasCycle(emptyList)); // Expected: false

        // Create a single-node linked list
        Node singleNodeList = new Node(10);
        System.out.println("Single-node linked list has cycle: " + detector.hasCycle(singleNodeList)); // Expected: false
    }
}