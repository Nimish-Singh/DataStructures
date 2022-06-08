package graph.lcStudyPlan.day5;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class ShortestClearPath {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        queue.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[n][n];
        int[][] directions = {{1, 1}, {1, 0}, {0, 1}, {-1, 1}, {-1, 0}, {0, -1}, {1, -1}, {-1, -1}};

        int pathLength = 0;
        while (!queue.isEmpty()) {
            pathLength++;
            int currentLength = queue.size();

            for (int index = 0; index < currentLength; index++) {
                int[] currentCell = queue.poll();
                int currentX = currentCell[0];
                int currentY = currentCell[1];

                if (currentX == n - 1 && currentY == n - 1)
                    return pathLength;

                for (int[] direction : directions) {
                    int newX = currentX + direction[0];
                    int newY = currentY + direction[1];

                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY] == 0) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return -1;
    }
}
