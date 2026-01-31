package org.kas.demos.Prac.CoderpatQuest.DAY3_18_09;

class MaxCollectUsingDp {

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
  public static Integer optimalPath(Integer[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0; // Handle empty or invalid grid
    }

    int rows = grid.length;
    int cols = grid[0].length;

    // We can use the grid itself to store the maximum rocks, which acts as our DP table.
    // The state `grid[i][j]` will represent the maximum rocks collected to reach cell (i, j).

    // Since we can only move up or right, the dependencies are always on cells to the
    // left or below. We can iterate from the starting position towards the end.
    for (int i = rows - 1; i >= 0; i--) {
      for (int j = 0; j < cols; j++) {
        // Skip the starting cell, as it is the base case.
        if (i == rows - 1 && j == 0) {
          continue;
        }

        int fromLeft = -1;
        int fromBelow = -1;

        // Check the path from the cell to the left (moving east).
        if (j > 0) {
          fromLeft = grid[i][j - 1];
        }

        // Check the path from the cell below (moving north).
        if (i < rows - 1) {
          fromBelow = grid[i + 1][j];
        }

        // The maximum rocks to reach the current cell (i, j) is the current cell's value
        // plus the maximum of the values from the previous cells (left or below).
        int maxPrevious = Math.max(fromLeft, fromBelow);

        // Update the current cell with the optimal path value.
        // If there are no valid previous cells (e.g., at the edges), maxPrevious will be -1.
        // We handle this by adding to 0 instead.
        if (maxPrevious != -1) {
          grid[i][j] += maxPrevious;
        }
      }
    }
    
    // The top-right cell will contain the total maximum rocks from the start to the end.
    return grid[0][cols - 1];
  }


  public static boolean doTestsPass() {
    boolean result = true;

    // Example from the problem description
    result &= optimalPath(new Integer[][]{{0, 0, 0, 0, 5},
                                         {0, 1, 1, 1, 0},
                                         {2, 0, 0, 0, 0}}) == 10;

    // Additional test case: Larger grid
    Integer[][] largeGrid = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    // Optimal path: 7 -> 8 -> 9 -> 6 -> 3. Sum = 33.
    result &= optimalPath(largeGrid) == 33;

    // Additional test case: Grid with zero values
    Integer[][] zeroGrid = {
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0}
    };
    result &= optimalPath(zeroGrid) == 0;

    // Additional test case: Single cell grid
    Integer[][] singleCellGrid = {{100}};
    result &= optimalPath(singleCellGrid) == 100;

    // Additional test case: A path that forces a specific route
    Integer[][] forcedPathGrid = {
        {1, 10, 1, 1},
        {1, 1, 1, 1},
        {1, 1, 1, 1}
    };
    // Optimal path will go through the 10.
    result &= optimalPath(forcedPathGrid) == 14;

    return result;
  }

  public static void main(String[] args) {
    if (doTestsPass()) {
      System.out.println("All tests pass");
    } else {
      System.out.println("Tests fail.");
    }
  }
}