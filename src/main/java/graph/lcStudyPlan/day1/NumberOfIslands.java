package graph.lcStudyPlan.day1;

// https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int totalRows = grid.length;
        int totalColumns = grid[0].length;
        boolean[][] visited = new boolean[totalRows][totalColumns];
        int islands = 0;

        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (visited[row][column]) {
                    continue;
                }
                if (grid[row][column] == '0') {
                    visited[row][column] = true;
                    continue;
                }

                islands++;
                visitDFS(grid, row, column, visited);
            }
        }
        return islands;
    }

    private void visitDFS(char[][] grid, int row, int column, boolean[][] visited) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || visited[row][column])
            return;

        visited[row][column] = true;

        if (grid[row][column] == '0')
            return;

        visitDFS(grid, row - 1, column, visited);
        visitDFS(grid, row + 1, column, visited);
        visitDFS(grid, row, column - 1, visited);
        visitDFS(grid, row, column + 1, visited);
    }
}
