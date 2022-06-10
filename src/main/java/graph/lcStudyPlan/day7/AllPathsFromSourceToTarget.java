package graph.lcStudyPlan.day7;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/all-paths-from-source-to-target/
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> allPaths = new ArrayList<>();

        dfs(graph, 0, currentPath, allPaths);

        return allPaths;
    }

    private void dfs(int[][] graph, int currentNode, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (currentNode == graph.length - 1) {
            List<Integer> pathToBeAdded = new ArrayList<>(currentPath);
            pathToBeAdded.add(currentNode);
            allPaths.add(pathToBeAdded);
            return;
        }

        ArrayList<Integer> pathStill = new ArrayList<>(currentPath);
        pathStill.add(currentNode);

        for (int node : graph[currentNode]) {
            dfs(graph, node, pathStill, allPaths);
        }
        pathStill.remove(pathStill.size() - 1);
    }
}
