package graph.lcStudyPlan.day6;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
public class NearestExitFromEntranceInMaze {
    private int[][] DIRECTIONS = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int totalRows = maze.length;
        int totalColumns = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();

        maze[entrance[0]][entrance[1]] = '+';
        queue.offer(new int[]{entrance[0], entrance[1]});

        int minSteps = 0;
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();
            minSteps++;

            for (int index = 0; index < currentLevel; index++) {
                int[] currentCell = queue.poll();

                for (int[] direction : DIRECTIONS) {
                    int newX = currentCell[0] + direction[0];
                    int newY = currentCell[1] + direction[1];

                    if (newX < 0 || newX >= totalRows || newY < 0 || newY >= totalColumns || maze[newX][newY] == '+')
                        continue;

                    if (newX == 0 || newX == totalRows - 1 || newY == 0 || newY == totalColumns - 1)
                        return minSteps;

                    maze[newX][newY] = '+';
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return -1;
    }
}
