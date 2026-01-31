package org.kas.demos.Prac.CoderpatQuest.DAY7_24_09;

// Node class for a doubly linked list
class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// DoublyLinkedList class
class DoublyLinkedList {
    Node head;

    // Method to add a new node to the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Method to print the list from head to tail
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * Recursively reverses the doubly linked list.
     * @param node The current node being processed.
     * @return The new head of the reversed list.
     */
    public Node reverse(Node node) {
        // Base case: If the list is empty or we've reached the end
        if (node == null || node.next == null) {
            return node;
        }

        // Recursively call for the rest of the list.
        Node newHead = reverse(node.next);

        // This is where the links are swapped on the way up the recursion.
        //now we reached to last to last node


        /*
        This line stores a temporary reference to the next node in the original sequence (node 4). It is essential because the node.next reference is about to be overwritten, and we would lose our access to node 4 otherwise.
nextNode.next = node; // node 4's next pointer now points to node 3
Before this line, 4.next was null.
This line reverses the forward link. The next pointer of node 4 is now made to point backward to node 3. The list now looks something like: 1 <-> 2 <-> 3 <-> 4 <-> 3.
node.prev = nextNode; // node 3's prev pointer now points to node 4
         */
        Node nextNode = node.next; //3->4
        nextNode.next = node;//4->3
        node.prev =nextNode;//4-> 3
                            //  <-


        // Set the old head's next to null, as it will now be the tail.
        node.next = null;

        // Return the new head up the call stack.
        return newHead;
    }

    // A helper method to start the recursive reversal from the head
    public void reverseList() {
        if (head != null) {
            head = reverse(head);
        }
    }
}

public class ReverseDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Original Doubly Linked List:");
        list.printList();

        list.reverseList();

        System.out.println("Reversed Doubly Linked List:");
        list.printList();
    }
}
