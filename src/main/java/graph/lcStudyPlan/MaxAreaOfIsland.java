package graph.lcStudyPlan;

// https://leetcode.com/problems/max-area-of-island/
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int totalRows = grid.length;
        int totalColumns = grid[0].length;

        boolean[][] visited = new boolean[totalRows][totalColumns];
        int maxArea = 0;
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                maxArea = Math.max(maxArea, dfs(grid, row, column, visited));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int column, boolean[][] visited) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || visited[row][column]) {
            return 0;
        }

        visited[row][column] = true;
        if (grid[row][column] == 0) {
            return 0;
        }

        return 1 + dfs(grid, row - 1, column, visited) +
                   dfs(grid, row + 1, column, visited) +
                   dfs(grid, row, column - 1, visited) +
                   dfs(grid, row, column + 1, visited);
    }
}
