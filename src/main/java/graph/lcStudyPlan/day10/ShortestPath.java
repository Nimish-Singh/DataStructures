package graph.lcStudyPlan.day10;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/shortest-path-visiting-all-nodes/
public class ShortestPath {
    public int shortestPathLength(int[][] graph) {
        if (graph.length == 1)
            return 0;

        int nodes = graph.length;
        int endingMask = (1 << nodes) - 1;
        boolean[][] visited = new boolean[nodes][endingMask];
        Queue<int[]> queue = new LinkedList<>();

        for (int index = 0; index < nodes; index++) {
            queue.offer(new int[]{index, 1 << index});
            visited[index][1 << index] = true;
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();

            for (int index = 0; index < currentLevel; index++) {
                int[] currentPair = queue.poll();
                int node = currentPair[0];
                int mask = currentPair[1];

                for (int neighbour : graph[node]) {
                    int nextMask = mask | (1 << neighbour);
                    if (nextMask == endingMask)
                        return steps + 1;

                    if (!visited[neighbour][nextMask]) {
                        visited[neighbour][nextMask] = true;
                        queue.offer(new int[]{neighbour, nextMask});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
