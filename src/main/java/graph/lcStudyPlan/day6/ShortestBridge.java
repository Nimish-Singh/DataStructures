package graph.lcStudyPlan.day6;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/shortest-bridge/
public class ShortestBridge {
    private int[][] DIRECTIONS = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int shortestBridge(int[][] grid) {
        int totalRows = grid.length;
        int totalColumns = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;

        // DFS to find one of the islands
        // marking cell = 2 is similar to saying that it is visited
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (grid[row][column] == 1) {
                    dfs(grid, row, column, queue);
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }

        // bfs from all cells of the found island to travel water and reach the second island
        int bridgeLength = 0;
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();

            for (int index = 0; index < currentLevel; index++) {
                int[] currentCell = queue.poll();

                for (int[] direction : DIRECTIONS) {
                    int newRow = currentCell[0] + direction[0];
                    int newColumn = currentCell[1] + direction[1];

                    if (newRow < 0 || newRow >= totalRows || newColumn < 0 || newColumn >= totalColumns || grid[newRow][newColumn] == 2)
                        continue;

                    if (grid[newRow][newColumn] == 1)
                        return bridgeLength;

                    grid[newRow][newColumn] = 2;
                    queue.offer(new int[]{newRow, newColumn});
                }
            }
            bridgeLength++;
        }
        return bridgeLength;
    }

    private void dfs(int[][] grid, int row, int column, Queue<int[]> queue) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length)
            return;

        if (grid[row][column] == 0 || grid[row][column] == 2)
            return;

        grid[row][column] = 2;
        queue.offer(new int[]{row, column});

        for (int[] direction : DIRECTIONS) {
            dfs(grid, row + direction[0], column + direction[1], queue);
        }
    }
}
