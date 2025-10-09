package org.kas.demos.Prac.CoderpatQuest.Pending;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class LongestPerfectTree {
    // Global variable to store the result
    private int maxLength = 0;

    // A helper class to return multiple values from the recursive function
    class PerfectTreeInfo {
        int height;
        boolean isPerfect;

        PerfectTreeInfo(int h, boolean p) {
            height = h;
            isPerfect = p;
        }
    }

    // Main function to find the length of the longest perfect binary tree
    public int findLongestPerfectTree(Node root) {
        if (root == null) {
            return 0;
        }
        findPerfectTreeInfo(root);
        return maxLength;
    }

    // Recursive helper function for post-order traversal
    private PerfectTreeInfo findPerfectTreeInfo(Node node) {
        if (node == null) {
            return new PerfectTreeInfo(-1, true); // Height of empty tree is -1
        }

        // Post-order traversal: Visit left, then right, then the current node
        PerfectTreeInfo leftInfo = findPerfectTreeInfo(node.left);
        PerfectTreeInfo rightInfo = findPerfectTreeInfo(node.right);

        // Check if the current subtree is perfect
        if (leftInfo.isPerfect && rightInfo.isPerfect && leftInfo.height == rightInfo.height) {
            int currentHeight = leftInfo.height + 1;
            int currentSize = (1 << (currentHeight + 1)) - 1; // 2^(height+1) - 1
            maxLength = Math.max(maxLength, currentSize);
            return new PerfectTreeInfo(currentHeight, true);
        } else {
            return new PerfectTreeInfo(Math.max(leftInfo.height, rightInfo.height) + 1, false);
        }
    }
}

// Example usage
 class Main {
    public static void main(String[] args) {
        LongestPerfectTree solver = new LongestPerfectTree();

        // Example 1: Longest perfect tree length is 7
        Node root1 = new Node(10);
        root1.left = new Node(20);
        root1.right = new Node(30);
        root1.left.left = new Node(12);
        root1.left.right = new Node(4);
        root1.left.left.left = new Node(12);
        root1.left.left.right = new Node(2);
        root1.left.right.left = new Node(1);
        root1.left.right.right = new Node(3);
        
        System.out.println("Longest perfect tree length for example 1: " + solver.findLongestPerfectTree(root1)); // Output: 7

        // Example 2: Longest perfect tree length is 1
        Node root2 = new Node(10);
        System.out.println("Longest perfect tree length for example 2: " + solver.findLongestPerfectTree(root2)); // Output: 1

        // Example 3: Longest perfect tree length is 3
        Node root3 = new Node(10);
        root3.left = new Node(20);
        root3.left.left = new Node(30);
        root3.left.right = new Node(40);
        System.out.println("Longest perfect tree length for example 3: " + solver.findLongestPerfectTree(root3)); // Output: 3
    }
}
