package graph.lcStudyPlan.day10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
public class ReorderRoutes {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, Set<Integer>> neighbours = new HashMap<>();
        Set<String> edges = new HashSet<>();

        // Make graph undirected
        for (int[] connection : connections) {
            edges.add(connection[0] + " to " + connection[1]);
            neighbours.computeIfAbsent(connection[0], k -> new HashSet<>());
            neighbours.computeIfAbsent(connection[1], k -> new HashSet<>());
            neighbours.get(connection[0]).add(connection[1]);
            neighbours.get(connection[1]).add(connection[0]);
        }

        boolean[] visited = new boolean[n]; // We need visited because now we have undirected graph

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int minReorder = 0;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (Integer neighbour : neighbours.get(currentNode)) {
                if (visited[neighbour])
                    continue;
                visited[neighbour] = true;
                queue.offer(neighbour);
                if (edges.contains(currentNode + " to " + neighbour))
                    minReorder++;
            }
        }

        return minReorder;
    }
}
