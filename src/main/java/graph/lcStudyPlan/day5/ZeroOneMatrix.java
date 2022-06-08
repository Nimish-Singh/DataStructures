package graph.lcStudyPlan.day5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/01-matrix/
public class ZeroOneMatrix {
    private int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] updateMatrix(int[][] mat) {
//        return bfsApproach(mat);

        return dpApproach(mat);
    }

    private int[][] dpApproach(int[][] mat) {
        int totalRows = mat.length;
        int totalColumns = mat[0].length;
        int[][] distances = new int[totalRows][totalColumns];
        for (int[] distance : distances)
            Arrays.fill(distance, Integer.MAX_VALUE - 11000); // 11000 as per problem constraints

        // top left to bottom right DP
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (mat[row][column] == 0) {
                    distances[row][column] = 0;
                    continue;
                }

                if (row > 0)
                    distances[row][column] = Math.min(distances[row][column], distances[row - 1][column] + 1);

                if (column > 0)
                    distances[row][column] = Math.min(distances[row][column], distances[row][column - 1] + 1);
            }
        }

        // bottom right to top left DP
        for (int row = totalRows - 1; row >= 0; row--) {
            for (int column = totalColumns - 1; column >= 0; column--) {
                if (row < totalRows - 1)
                    distances[row][column] = Math.min(distances[row][column], distances[row + 1][column] + 1);

                if (column < totalColumns - 1)
                    distances[row][column] = Math.min(distances[row][column], distances[row][column + 1] + 1);
            }
        }
        return distances;
    }

    private int[][] bfsApproach(int[][] mat) {
        int totalRows = mat.length;
        int totalColumns = mat[0].length;
        int[][] distances = new int[totalRows][totalColumns];
        Queue<int[]> queue = new LinkedList<>();

        // initialise distances matrix
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (mat[row][column] == 0) {
                    queue.offer(new int[]{row, column});
                    distances[row][column] = 0;
                } else
                    distances[row][column] = -1;
            }
        }

        // spread outward from all zeroes in the beginning
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();

            for (int index = 0; index < currentLevel; index++) {
                int[] currentCell = queue.poll();

                for (int[] direction : DIRECTIONS) {
                    int newX = currentCell[0] + direction[0];
                    int newY = currentCell[1] + direction[1];

                    if (newX >= 0 && newX < totalRows && newY >= 0 && newY < totalColumns && distances[newX][newY] == -1) {
                        distances[newX][newY] = distances[currentCell[0]][currentCell[1]] + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        return distances;
    }
}
