package graph.lcStudyPlan.day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/possible-bipartition/
public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] colour = new int[n + 1]; // 0 = no group; 1 or 2 = specific group

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adjacencyList.add(i, new ArrayList<>());

        for (int[] dislike : dislikes) {
            adjacencyList.get(dislike[0]).add(dislike[1]);
            adjacencyList.get(dislike[1]).add(dislike[0]); // because if 1 dislikes 2, then both of them can't be in same group
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int node = 1; node <= n; node++) { // for disconnected nodes too
            if (colour[node] == 0) {
                colour[node] = 1;
                queue.offer(node);

                while (!queue.isEmpty()) {
                    Integer currentNode = queue.poll();

                    for (int neighbour : adjacencyList.get(currentNode)) {
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
