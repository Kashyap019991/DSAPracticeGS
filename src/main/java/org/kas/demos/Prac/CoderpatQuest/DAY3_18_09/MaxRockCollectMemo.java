package org.kas.demos.Prac.CoderpatQuest.DAY3_18_09;

class Solution {
/**
 * Calculates the optimal path to accumulate the most rocks from SoCal (bottom-left)
 * to New York (top-right) in a grid, moving only up (north) or right (east).
 * <p>
 * This problem can be solved efficiently using dynamic programming. We can work backward
 * from the destination (top-right) or forward from the start (bottom-left). The bottom-up
 * approach (working from the start) is often more intuitive.
 * <p>
 * We will modify the grid in-place to store the maximum number of rocks that can be
 * accumulated to reach that cell.
 *
 * @param grid A 2D array of Integers where each element represents the number of
 *             rocks in a city.
 * @return The maximum number of rocks that can be collected on the optimal path.
 */
  /**
   * Calculates the optimal path using a recursive approach with memoization.
   *
   * @param grid A 2D array of Integers where each element represents the number of rocks.
   * @return The maximum number of rocks that can be collected on the optimal path.
   */
  public static Integer optimalPath(Integer[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rows = grid.length;
    int cols = grid[0].length;
    Integer[][] memo = new Integer[rows][cols];

    return findOptimalPathRecursive(grid, rows - 1, 0, memo);
  }

  /**
   * Recursive helper method with memoization to find the optimal path sum.
   *
   * @param grid The grid of rock values.
   * @param row The current row index.
   * @param col The current column index.
   * @param memo The memoization table to store results of subproblems.
   * @return The maximum rock sum from the current cell to the destination.
   */
  private static int findOptimalPathRecursive(Integer[][] grid, int row, int col, Integer[][] memo) {
    int rows = grid.length;
    int cols = grid[0].length;

    // Base Case 1: If we move out of bounds, this is an invalid path.
    if (row < 0 || col >= cols) {
      // Use a very small value to ensure this path is not chosen.
      return Integer.MIN_VALUE;
    }

    // Base Case 2: If we have reached the destination (top-right corner).
    if (row == 0 && col == cols - 1) {
      return grid[row][col];
    }

    // Memoization Check: If we have already computed this subproblem, return the cached result.
    if (memo[row][col] != null) {
      return memo[row][col];
    }

    // Recursive Step:
    // We can move either up (decrease row) or right (increase col).
    // Find the maximum rock count from the next possible moves.
    int pathUp = findOptimalPathRecursive(grid, row - 1, col, memo);
    int pathRight = findOptimalPathRecursive(grid, row, col + 1, memo);
    int maxNextPath = Math.max(pathUp, pathRight);

    // Calculate the total rocks for the current path and store it in memo.
    int currentPathSum = grid[row][col] + maxNextPath;
    memo[row][col] = currentPathSum;

    return currentPathSum;
  }

  public static boolean doTestsPass() {
    boolean result = true;
    result &= optimalPath(new Integer[][]{{0, 0, 0, 0, 5},
                                         {0, 1, 1, 1, 0},
                                         {2, 0, 0, 0, 0}}) == 10;
    
    // Additional test cases
    result &= optimalPath(new Integer[][]{{1, 1}, {1, 1}}) == 4;
    result &= optimalPath(new Integer[][]{{1, 2}, {3, 4}}) == 8; // Path: 3 -> 4 -> 2
    result &= optimalPath(new Integer[][]{{100}}) == 100;
    
    return result;
  }

  public static void main(String[] args) {
    /*if (doTestsPass()) {
      System.out.println("All tests pass");
    } else {
      System.out.println("Tests fail.");
    }*/
    System.out.println(optimalPath(new Integer[][]{{0, 0, 0, 0, 5},
            {0, 1, 1, 1, 0},
            {2, 0, 0, 0, 0}}));
  }
}