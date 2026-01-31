package org.kas.demos.Prac.CoderpatQuest.DAY25_28_10;

import java.util.*;

class LargestTree {
    /*
    **  Find the largest tree.
    */

    /*
     **  Instructions:
     **
     **  Given a forest ( one or more disconnected trees ), find the root of largest tree
     **  and return its Id. If there are multiple such roots, return the smallest Id of them.
     **
     **  Complete the largestTree function in the editor below.
     **  It has one parameter, immediateParent, which is a map containing key-value pair indicating
     **  child -> parent relationship. The key is child and value is the corresponding
     **  immediate parent.
     **  Constraints
     **    - Child cannot have more than one immediate parent.
     **    - Parent can have more than one immediate child.
     **    - The given key-value pair forms a well-formed forest ( a tree of n nodes will have n-1 edges )
     **
     **  Example:
     **
     **  Input:
     **  { { 1 -> 2 }, { 3 -> 4} }
     **
     **  Expected output: 2
     **  Explanation: There are two trees one having root of Id 2 and another having root of Id 4.
     **  Both trees have size 2. The smaller number of 2 and 4 is 2. Hence the answer is 2.
     */


    public static Integer largestTree(final Map<Integer, Integer> immediateParent) {
        if (immediateParent == null || immediateParent.isEmpty()) {
            return null;
        }

        // 1. Identify all nodes and roots
        Set<Integer> allNodes = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : immediateParent.entrySet()) {
            allNodes.add(entry.getKey());
            allNodes.add(entry.getValue());
        }

        Set<Integer> roots = new HashSet<>(allNodes);
        for (Integer child : immediateParent.keySet()) {
            roots.remove(child);
        }

        // 2. Build child-to-parent and parent-to-children maps
        Map<Integer, List<Integer>> parentToChildren = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : immediateParent.entrySet()) {
            parentToChildren.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        // 3. Find the largest tree
        Integer largestTreeRoot = null;
        int maxTreeSize = 0;

        for (Integer root : roots) {
            int currentTreeSize = countNodes(root, parentToChildren);

            if (currentTreeSize > maxTreeSize) {
                maxTreeSize = currentTreeSize;
                largestTreeRoot = root;
            } else if (currentTreeSize == maxTreeSize) {
                // Tie-breaker: return the smallest ID
                if (largestTreeRoot == null || root < largestTreeRoot) {
                    largestTreeRoot = root;
                }
            }
        }
        return largestTreeRoot;
    }

    // Helper method to count nodes in a tree using DFS
    private static int countNodes(Integer root, Map<Integer, List<Integer>> parentToChildren) {
        int count = 1;
        if (parentToChildren.containsKey(root)) {
            for (Integer child : parentToChildren.get(root)) {
                count += countNodes(child, parentToChildren);
            }
        }
        return count;
    }

    /*
    **  Returns true if the tests pass. Otherwise, returns false;
    */
    public static boolean doTestsPass() {
        // map of test cases to expected results
        final Map<Map<Integer, Integer>, Integer> testCases = new HashMap<>();

        // example
        final Map<Integer, Integer> testCaseOneKey = new HashMap<>() {{
            put(1, 2);
            put(3, 4);
        }};
        testCases.put(testCaseOneKey, 2);

        // More than two trees
        final Map<Integer, Integer> testCaseTwoKey = new HashMap<>() {{
            put(2, 3);
            put(7, 8);
            put(12, 15);
            put(3, 1);
            put(13, 15);
            put(11, 15);
            put(9, 8);
            put(5, 12);
        }};
        testCases.put(testCaseTwoKey, 15);

        // really large index values
        final Map<Integer, Integer> testCaseThreeKey = new HashMap<>() {{
            put(200000000, 300000000);
            put(500000000, 200000000);
            put(700000000, 200000000);
            put(800000000, 900000000);
        }};
        testCases.put(testCaseThreeKey, 300000000);

        // One tree
        final Map<Integer, Integer> testCaseFourKey = new HashMap<>() {{
            put(1, 2);
            put(2, 3);
            put(3, 4);
        }};
        testCases.put(testCaseFourKey, 4);

        // Another one tree test
        final Map<Integer, Integer> testCaseFiveKey = new HashMap<>() {{
            put(1, 5);
            put(2, 5);
            put(3, 1);
            put(4, 2);
            put(6, 4);
        }};
        testCases.put(testCaseFiveKey, 5);

        // Test with a large tree and a small tree, tie-breaker not needed
        final Map<Integer, Integer> testCaseSixKey = new HashMap<>() {{
            put(10, 20);
            put(30, 20);
            put(40, 20);
            put(50, 60);
        }};
        testCases.put(testCaseSixKey, 20);

        // Test with an empty map
        final Map<Integer, Integer> testCaseSevenKey = new HashMap<>();
        testCases.put(testCaseSevenKey, null);

        boolean isAllPass = true;
        for (Map.Entry<Map<Integer, Integer>, Integer> entry : testCases.entrySet()) {
            final Integer actual = largestTree(entry.getKey());
            final Integer expected = entry.getValue();
            final boolean passed = (actual == null && expected == null) || (actual != null && actual.equals(expected));

            if (!passed) {
                isAllPass = false;
                System.out.println("Test failed: Input: " + entry.getKey() + ", Expected: " + expected + ", Got: " + actual);
            } else {
                System.out.println("Test passed: Input: " + entry.getKey() + ", Expected: " + expected + ", Got: " + actual);
            }
        }
        return isAllPass;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests passed");
        } else {
            System.out.println("Some tests failed");
        }
    }
}
