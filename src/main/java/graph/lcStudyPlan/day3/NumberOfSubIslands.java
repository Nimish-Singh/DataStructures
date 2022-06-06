package graph.lcStudyPlan.day3;

// https://leetcode.com/problems/count-sub-islands/
public class NumberOfSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int totalRows = grid2.length;
        int totalColumns = grid2[0].length;

        int subIslands = 0;
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (grid2[row][column] == 1) {
                    if (dfs(grid1, grid2, row, column)) {
                        subIslands++;
                    }
                }
            }
        }
        return subIslands;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int row, int column) {
        if (row < 0 || row >= grid2.length || column < 0 || column >= grid2[0].length)
            return true;

        if (grid2[row][column] != 1)
            return true;

        if (grid1[row][column] != 1)
            return false;

        grid2[row][column] = -1;

        boolean top = dfs(grid1, grid2, row - 1, column);
        boolean bottom = dfs(grid1, grid2, row + 1, column);
        boolean left = dfs(grid1, grid2, row, column - 1);
        boolean right = dfs(grid1, grid2, row, column + 1);

        return top && bottom && left && right;
    }
}
