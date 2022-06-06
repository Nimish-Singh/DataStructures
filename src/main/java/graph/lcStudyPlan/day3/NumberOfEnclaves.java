package graph.lcStudyPlan.day3;

// https://leetcode.com/problems/number-of-enclaves/
public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        int totalRows = grid.length;
        int totalColumns = grid[0].length;

        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (row == 0 || column == 0 || row == totalRows - 1 || column == totalColumns - 1)
                    dfs(grid, row, column);
            }
        }

        int enclaves = 0;
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (grid[row][column] == 1)
                    enclaves++;
            }
        }
        return enclaves;
    }

    private void dfs(int[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length)
            return;


        if (grid[row][column] == 0)
            return;

        grid[row][column] = 0;

        dfs(grid, row - 1, column);
        dfs(grid, row + 1, column);
        dfs(grid, row, column - 1);
        dfs(grid, row, column + 1);
    }
}
