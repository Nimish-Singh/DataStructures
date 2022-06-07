package graph.lcStudyPlan.day4;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/as-far-from-land-as-possible/
public class AsFarFromLand {
    private int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxDistance(int[][] grid) {
        return bfsApproach(grid);

        // A DP solution is given here-
        // https://leetcode.com/problems/as-far-from-land-as-possible/discuss/422691/7ms-DP-solution-with-example-beats-100
    }

    private int bfsApproach(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int totalRows = grid.length;
        int totalColumns = grid[0].length;
        boolean[][] visited = new boolean[totalRows][totalColumns];

        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (grid[row][column] == 1) {
                    queue.offer(new int[]{row, column});
                    visited[row][column] = true;
                }
            }
        }

        if (queue.size() == 0 || queue.size() == totalRows * totalColumns)
            return -1;

        int distance = 0;
        while (!queue.isEmpty()) {
            int atThisLevel = queue.size();

            for (int index = 0; index < atThisLevel; index++) {
                int[] currentCell = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int newRow = currentCell[0] + DIRECTIONS[i][0];
                    int newColumn = currentCell[1] + DIRECTIONS[i][1];

                    if (newRow >= 0 && newRow < totalRows && newColumn >= 0 && newColumn < totalColumns
                            && !visited[newRow][newColumn] && grid[newRow][newColumn] == 0) {
                        visited[newRow][newColumn] = true;
                        queue.offer(new int[]{newRow, newColumn});
                    }
                }
            }
            distance++;
        }
        return distance - 1;
    }
}
