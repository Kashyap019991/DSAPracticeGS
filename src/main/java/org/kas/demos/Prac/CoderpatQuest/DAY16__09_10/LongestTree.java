package org.kas.demos.Prac.CoderpatQuest.DAY16__09_10;/*
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
/*
High-Level Plan
Find all root nodes: Roots are nodes that appear as parents in the immediateParent map 3
but are never listed as children. We can find all nodes that are children by
collecting all the keys from the immediateParent map. Then, any node in the set of all parent nodes that is not a child must be a root.
Convert to child-centric map: To facilitate tree traversal from the root down,
we first need to invert the input child -> parent map to a parent -> child map.
This is a standard preprocessing step for tree problems where traversal from the root is necessary.
Calculate tree sizes: Iterate through each root node identified in the first step.
For each root, use a traversal algorithm (like a provided Depth-First Search or Breadth-First Search) to count all the nodes in its tree. Store the root ID and its corresponding tree size.
Find the largest and smallest root: Keep track of the largest tree size
found so far and the ID of the corresponding root. If a new tree has the same
size but a smaller root ID, update the tracked root ID. If a new tree is strictly larger,
update both the size and the root ID.
 */
import java.util.*;


class LongestTree {
    /*
     ** Get the size of the tree with root index rootIndex
     */
    public static Integer getTreeSize(final Map<Integer, List<Integer>> parentToChild, final Integer rootIndex) {
        Integer result = 0;
        final Stack<Integer> nodes = new Stack<>();
        nodes.push(rootIndex);
        while (!nodes.empty()) {
            final Integer index = nodes.pop();
            for (final Integer childIndex : parentToChild.getOrDefault(index, new ArrayList<>())) {
                nodes.push(childIndex);
                result++;
            }
        }
        return result;
    }

    /*
     **  Find the largest tree.
     */
    public static Integer largestTree(final Map<Integer, Integer> immediateParent) {
        // Step 1: Identify all nodes and roots
        Set<Integer> allNodes = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : immediateParent.entrySet()) {
            allNodes.add(entry.getKey());   // Add child
            allNodes.add(entry.getValue()); // Add parent
        }

        Set<Integer> children = immediateParent.keySet();
        Set<Integer> roots = new HashSet<>(allNodes);
        roots.removeAll(children);

        // Step 2: Invert the map for parent -> children relationship
        Map<Integer, List<Integer>> parentToChild = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : immediateParent.entrySet()) {
            parentToChild.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        // Step 3: Calculate tree sizes and find the largest
        Integer maxTreeSize = -1;
        Integer largestTreeRootId = null;

        for (Integer rootId : roots) {
            // The getTreeSize function calculates the number of edges.
            // The number of nodes is the number of edges + 1.
            Integer currentTreeSize = getTreeSize(parentToChild, rootId) + 1;

            if (currentTreeSize > maxTreeSize) {
                maxTreeSize = currentTreeSize;
                largestTreeRootId = rootId;
            } else if (currentTreeSize.equals(maxTreeSize)) {
                // Tie-breaker: choose the smallest root ID
                if (largestTreeRootId == null || rootId < largestTreeRootId) {
                    largestTreeRootId = rootId;
                }
            }
        }

        return largestTreeRootId;
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
            put(700000000, 300000000);
            put(600000000, 700000000);
            put(900000000, 400000000);
            put(100000000, 400000000);
            put(800000000, 400000000);
            put(1000000000, 400000000);
        }};
        testCases.put(testCaseThreeKey, 300000000);

        // two trees of same size
        final Map<Integer, Integer> testCaseFourKey = new HashMap<>() {{
            put(9, 4);
            put(1, 4);
            put(5, 2);
            put(8, 4);
            put(7, 3);
            put(2, 3);
            put(6, 7);
            put(10, 4);
        }};
        testCases.put(testCaseFourKey, 3);

        // tree sizes differ by one
        final Map<Integer, Integer> testCaseFiveKey = new HashMap<>() {{
            put(35, 33);
            put(33, 28);
            put(31, 22);
            put(28, 25);
            put(34, 31);
            put(29, 27);
            put(21, 23);
            put(25, 21);
            put(22, 29);
        }};
        testCases.put(testCaseFiveKey, 23);

        boolean passed = true;
        for (Map.Entry<Map<Integer, Integer>, Integer> entry : testCases.entrySet()) {
            final Integer actual = largestTree(entry.getKey());
            if (!actual.equals(entry.getValue())) {
                passed = false;
                System.out.println("Failed for " + entry.getKey().toString() + "\n  expected " + entry.getValue() + ", actual " + actual);
            }
        }

        return passed;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args) {
        // Run the tests
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}