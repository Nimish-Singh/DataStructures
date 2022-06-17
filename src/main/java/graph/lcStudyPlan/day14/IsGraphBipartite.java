package graph.lcStudyPlan.day14;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/is-graph-bipartite/
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int totalNodes = graph.length;
        int[] colour = new int[totalNodes];

        Queue<Integer> queue = new LinkedList<>();

        for (int node = 0; node < totalNodes; node++) {
            if (colour[node] == 0) {
                colour[node] = 1;
                queue.offer(node);

                while (!queue.isEmpty()) {
                    Integer currentNode = queue.poll();

                    for (int neighbour : graph[currentNode]) {
                        if (colour[neighbour] == 0) {
                            colour[neighbour] = colour[currentNode] == 1 ? 2 : 1;
                            queue.offer(neighbour);
                        } else {
                            if (colour[neighbour] == colour[currentNode])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
