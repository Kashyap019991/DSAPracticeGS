package org.kas.demos.Prac.CoderpatQuest.DAY10_29_09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Given an m x n matrix, find all common elements present in all rows in O(mn) time and one traversal of matrix.

Example:

Input:

mat[4][5] = {{1, 2, 1, 4, 8},

             {3, 7, 8, 5, 1},

             {8, 7, 7, 3, 1},

             {8, 1, 2, 7, 9},

            };

Output:

1 8 or 8 1
 */
public class CommonElementsInMatrix {

    public static List<Integer> findCommonElements(int[][] mat) {
        List<Integer> result = new ArrayList<>();
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return result;
        }

        int m = mat.length; // Number of rows
        int n = mat[0].length; // Number of columns

        // Use a HashMap to store elements and their counts across rows
        // Key: element, Value: number of rows it has been found in so far
        Map<Integer, Integer> elementCounts = new HashMap<>();

        // Initialize the map with elements from the first row
        for (int j = 0; j < n; j++) {
            elementCounts.put(mat[0][j], 1);
        }

        // Iterate through the rest of the rows
        for (int i = 1; i < m; i++) {
            // Use a temporary set to track elements seen in the current row
            // This prevents counting the same element multiple times in one row
            Map<Integer, Integer> currentRowElements = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int currentElement = mat[i][j];
                // If the element is present in our main map and hasn't been counted for this row yet
                if (elementCounts.containsKey(currentElement) && !currentRowElements.containsKey(currentElement)) {
                    elementCounts.put(currentElement, elementCounts.get(currentElement) + 1);
                    currentRowElements.put(currentElement, 1); // Mark as seen in current row
                }
            }
        }

        // Collect elements that have been found in all 'm' rows
        for (Map.Entry<Integer, Integer> entry : elementCounts.entrySet()) {
            if (entry.getValue() == m) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 1, 4, 8},
            {3, 7, 8, 5, 1},
            {8, 7, 7, 3, 1},
            {8, 1, 2, 7, 9}
        };

        List<Integer> commonElements = findCommonElements(mat);
        System.out.println("Common elements: " + commonElements); // Output: Common elements: [1, 8] or [8, 1]
    }
}