package graph.lcStudyPlan.day1;

// https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
//        return dfsApproach(grid);

        return unionFindApproach(grid);
    }

    private int unionFindApproach(char[][] grid) {
        UnionFind uf = new UnionFind(grid);

        int totalRows = grid.length;
        int totalColumns = grid[0].length;

        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (grid[row][column] == '1') {
                    int newRow, newColumn, node1Id, node2Id;
                    node1Id = getNodeId(row, totalColumns, column);

                    // Up
                    newRow = row - 1; newColumn = column;
                    node2Id = getNodeId(newRow, totalColumns, newColumn);
                    if (newRow >= 0 && grid[newRow][newColumn] == '1') {
                        uf.union(node1Id, node2Id);
                    }

                    // Down
                    newRow = row + 1; newColumn = column;
                    node2Id = getNodeId(newRow, totalColumns, newColumn);
                    if (newRow < totalRows && grid[newRow][newColumn] == '1') {
                        uf.union(node1Id, node2Id);
                    }

                    // Left
                    newRow = row; newColumn = column - 1;
                    node2Id = getNodeId(newRow, totalColumns, newColumn);
                    if (newColumn >= 0 && grid[newRow][newColumn] == '1') {
                        uf.union(node1Id, node2Id);
                    }

                    // Right
                    newRow = row; newColumn = column + 1;
                    node2Id = getNodeId(newRow, totalColumns, newColumn);
                    if (newColumn < totalColumns && grid[newRow][newColumn] == '1') {
                        uf.union(node1Id, node2Id);
                    }
                }
            }
        }

        return uf.setCount;
    }

    private int getNodeId(int row, int totalColumns, int column) {
        return row * totalColumns + column;
    }

    private int dfsApproach(char[][] grid) {
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
