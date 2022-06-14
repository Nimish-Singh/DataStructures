package graph.lcStudyPlan.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/shortest-path-with-alternating-colors/
public class ShortestPathWithAlternatingColours {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] pathLengths = new int[n];
        Arrays.fill(pathLengths, -1);

        List<Integer>[] reds = new ArrayList[n];
        List<Integer>[] blues = new ArrayList[n];

        // Preparing array of all red edges
        for (int[] edge : redEdges) {
            if (reds[edge[0]] == null)
                reds[edge[0]] = new ArrayList<>();
            reds[edge[0]].add(edge[1]);
        }

        // Preparing array of all blue edges
        for (int[] edge : blueEdges) {
            if (blues[edge[0]] == null)
                blues[edge[0]] = new ArrayList<>();
            blues[edge[0]].add(edge[1]);
        }

        // Colours represented as: 1=red, 2=blue, 0=node-0 (special case)
        // These colours help in easier alternating between coloured edges
        Queue<int[]> queue = new LinkedList<>(); // Will have data as (node, originating edge colour)
        queue.offer(new int[]{0, 0});
        int pathSoFar = 0;
        Set<String> visited = new HashSet<>(); // To avoid self loops

        while (!queue.isEmpty()) {
            int currentLevel = queue.size();

            for (int index = 0; index < currentLevel; index++) {
                int[] currentNode = queue.poll();
                String keyToCheck = currentNode[0] + " " + currentNode[1]; // Check if we have got to this node with this colour

                if (visited.contains(keyToCheck))
                    continue;

                visited.add(keyToCheck);

                if (pathLengths[currentNode[0]] == -1)
                    pathLengths[currentNode[0]] = pathSoFar;

                // These 2 "if" checks help in alternating colour
                if (currentNode[1] == 1 || currentNode[1] == 0)
                    if (blues[currentNode[0]] != null)
                        for (int neighbour : blues[currentNode[0]])
                            queue.add(new int[]{neighbour, 2});

                if (currentNode[1] == 2 || currentNode[1] == 0)
                    if (reds[currentNode[0]] != null)
                        for (int neighbour : reds[currentNode[0]])
                            queue.add(new int[]{neighbour, 1});
            }
            pathSoFar++;
        }
        return pathLengths;
    }
}
