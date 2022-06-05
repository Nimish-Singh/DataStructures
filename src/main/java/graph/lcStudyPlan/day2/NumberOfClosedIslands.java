package graph.lcStudyPlan.day2;

// https://leetcode.com/problems/number-of-closed-islands/
public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
//        return selfLogic(grid);

        return slightlySimpler(grid);
    }

    private int slightlySimpler(int[][] grid) {
        // logic is similar to selfLogic, but just with some less steps

        //count the number
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    count += dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;//if we meet the edge return 0;
        }
        if (grid[row][col] == 1) {
            return 1;//if we meet 1 return 1;
        }
        grid[row][col] = 1;
        int up = dfs(grid, row - 1, col);
        int down = dfs(grid, row + 1, col);
        int left = dfs(grid, row, col - 1);
        int right = dfs(grid, row, col + 1);
        return up & down & left & right; //any of the side meet the edge,is not a island; bitwise AND
    }

    private int selfLogic(int[][] grid) {
        int totalRows = grid.length;
        int totalColumns = grid[0].length;

        boolean[][] visited = new boolean[totalRows][totalColumns];

        // essentially here we are flood-filling for edge islands
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (row == 0 || row == totalRows - 1 || column == 0 || column == totalColumns - 1)
                    markEdgeIslandsAsVisited(grid, row, column, visited);
            }
        }

        int closedIslands = 0;
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (!visited[row][column] && grid[row][column] == 0) {
                    dfs(grid, row, column, visited);
                    closedIslands++;
                }
            }
        }
        return closedIslands;
    }

    private void markEdgeIslandsAsVisited(int[][] grid, int row, int column, boolean[][] visited) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || visited[row][column]) {
            return;
        }

        visited[row][column] = true;
        if (grid[row][column] == 1)
            return;

        markEdgeIslandsAsVisited(grid, row - 1, column, visited);
        markEdgeIslandsAsVisited(grid, row + 1, column, visited);
        markEdgeIslandsAsVisited(grid, row, column - 1, visited);
        markEdgeIslandsAsVisited(grid, row, column + 1, visited);
    }

    private void dfs(int[][] grid, int row, int column, boolean[][] visited) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || visited[row][column]) {
            return;
        }

        visited[row][column] = true;

        if (grid[row][column] == 1)
            return;

        dfs(grid, row - 1, column, visited);
        dfs(grid, row + 1, column, visited);
        dfs(grid, row, column - 1, visited);
        dfs(grid, row, column + 1, visited);
    }
}
