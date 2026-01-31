package org.kas.demos.Prac.CoderpatQuest.DAY29_3_11;

import java.util.Arrays;

public class SurroundedIslands {
/*1
Given a 2D grid consisting of 0s(land) and 1s(water). Return the number of islands such that an island is a connected group of 0 which is completely surrounded by 1s.
[[1,1,1,1,1,1,0,0],
[ 1,0,0,0,0,1,1,1],
[ 1,0,1,0,1,1,1,0],
[ 1,0,0,0,0,1,0,1],
[ 1,1,1,1,1,1,1,0]]

*/

    /**
     * Counts the number of islands (groups of 0s) that are completely surrounded by water (1s).
     * @param grid The 2D grid where 0 is land and 1 is water.
     * @return The number of completely surrounded islands.
     */
    public int countClosedIslands(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // 1. Mark all '0's connected to the boundary as visited
        for (int i = 0; i < rows; i++) {
            // Left and right columns
            if (grid[i][0] == 0 && !visited[i][0]) {
                dfsBoundary(grid, visited, i, 0, rows, cols);
            }
            if (grid[i][cols - 1] == 0 && !visited[i][cols - 1]) {
                dfsBoundary(grid, visited, i, cols - 1, rows, cols);
            }
        }
        for (int j = 0; j < cols; j++) {
            // Top and bottom rows
            if (grid[0][j] == 0 && !visited[0][j]) {
                dfsBoundary(grid, visited, 0, j, rows, cols);
            }
            if (grid[rows - 1][j] == 0 && !visited[rows - 1][j]) {
                dfsBoundary(grid, visited, rows - 1, j, rows, cols);
            }
        }

        // 2. Count the remaining unvisited '0's (these are the surrounded islands)
        int islandCount = 0;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    // Start DFS from an unvisited inner cell and increment count
                    dfsBoundary(grid, visited, i, j, rows, cols); // Mark the rest of the island as visited
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    /**
     * Helper DFS function to traverse connected '0's and mark them as visited.
     */
    private void dfsBoundary(int[][] grid, boolean[][] visited, int r, int c, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || grid[r][c] == 1) {
            return;
        }

        visited[r][c] = true;

        // Recurse for all 4 neighbors
        dfsBoundary(grid, visited, r + 1, c, rows, cols);
        dfsBoundary(grid, visited, r - 1, c, rows, cols);
        dfsBoundary(grid, visited, r, c + 1, rows, cols);
        dfsBoundary(grid, visited, r, c - 1, rows, cols);
    }

    public static void main(String[] args) {
        SurroundedIslands solution = new SurroundedIslands();

        // The given input grid
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };

        int count = solution.countClosedIslands(grid);
        System.out.println("The number of completely surrounded islands is: " + count); // Expected output: 1
    }
}
