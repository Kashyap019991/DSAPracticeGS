package org.kas.demos.Prac.CoderpatQuest.DAY4_19_09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSTInorder {

  static class BST {

    private Node root;

    public BST() {
      // Initialize the root node with a null value; this node is a sentinel.
      // The first value will replace this node's value.
      this.root = new Node();
    }

    /**
     * Inserts a new value into the Binary Search Tree.
     * Traverses the tree to find the correct leaf node position for the new value.
     *
     * @param value The integer value to be inserted.
     */
    public void put(int value) {
      // If the root is null (or a sentinel with a null value), insert the first element.
      if (root.val == null) {
        root.val = value;
        return;
      }
      put(root, value);
    }

    // Helper method for recursive insertion.
    private void put(Node node, int value) {
      if (value < node.val) {
        if (node.left == null) {
          node.left = new Node();
          node.left.val = value;
        } else {
          put(node.left, value);
        }
      } else if (value > node.val) {
        if (node.right == null) {
          node.right = new Node();
          node.right.val = value;
        } else {
          put(node.right, value);
        }
      }
      // If the value is equal, do nothing (assuming no duplicates).
    }

    /**
     * Checks if the BST contains a specific value.
     * Traverses the tree to find the value based on BST properties.
     *
     * @param value The integer value to search for.
     * @return true if the value is found, false otherwise.
     */
    public boolean contains(int value) {
      if (root.val == null) {
        return false;
      }
      return contains(root, value);
    }
    
    // Helper method for recursive searching.
    private boolean contains(Node node, int value) {
      if (node == null) {
        return false;
      }
      if (value == node.val) {
        return true;
      } else if (value < node.val) {
        return contains(node.left, value);
      } else {
        return contains(node.right, value);
      }
    }

    /**
     * Performs an in-order traversal of the BST.
     *
     * @return A list of integers representing the in-order traversal.
     */
    public List<Integer> inOrderTraversal() {
      final ArrayList<Integer> acc = new ArrayList<>();
      inOrderTraversal(root, acc);
      return acc;
    }

    /**
     * Corrected in-order traversal helper method.
     * Traverses the left subtree, visits the root, then traverses the right subtree.
     *
     * @param node The current node to visit.
     * @param acc  The accumulator list for storing visited values.
     */
    private void inOrderTraversal(Node node, List<Integer> acc) {
      if (node == null || node.val == null) { // Handle empty nodes
        return;
      }
      inOrderTraversal(node.left, acc); // Left
      acc.add(node.val);                  // Root
      inOrderTraversal(node.right, acc); // Right
    }

    private static class Node {
      Integer val;
      Node left;
      Node right;
    }
  }

  public static void main(String[] args) {
    final BST searchTree = new BST();

    searchTree.put(3);
    searchTree.put(1);
    searchTree.put(2);
    searchTree.put(5);

    if (Arrays.asList(1, 2, 3, 5).equals(searchTree.inOrderTraversal())
        && !searchTree.contains(0)
        && searchTree.contains(1)
        && searchTree.contains(2)
        && searchTree.contains(3)
        && !searchTree.contains(4)
        && searchTree.contains(5)
        && !searchTree.contains(6)) {
      System.out.println("Pass");
    } else {
      System.out.println("Fail");
    }
  }
}
