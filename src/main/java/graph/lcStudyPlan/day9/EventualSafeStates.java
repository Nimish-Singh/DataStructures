package graph.lcStudyPlan.day9;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/find-eventual-safe-states/
public class EventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // Logic: every path from a node in graph will either lead to a terminal node or a cycle
        return dfsApproachWithMemo(graph);
    }

    private List<Integer> dfsApproachWithMemo(int[][] graph) {
        Map<Integer, Boolean> memo = new HashMap<>();

        // Mark terminal nodes as true, ie, safe
        for (int index = 0; index < graph.length; index++) {
            if (graph[index].length == 0)
                memo.put(index, true);
        }

        // Check all nodes to mark safe/unsafe
        for (int index = 0; index < graph.length; index++) {
            memo.put(index, dfs(graph, index, new HashSet<>(), memo));
        }

        // Create answer list
        List<Integer> answer = new ArrayList<>();
        for (int index = 0; index < graph.length; index++) {
            if (memo.get(index))
                answer.add(index);
        }
        return answer;
    }

    private boolean dfs(int[][] graph, int node, Set<Integer> visited, Map<Integer, Boolean> memo) {
        if (memo.containsKey(node))
            return memo.get(node);

        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        for (int neighbour : graph[node]) {
            boolean isNeighbourSafe = dfs(graph, neighbour, visited, memo);
            // Neighbour being safe is on its own. Neighbour being unsafe can be because of itself or because of current node
            // Hence not adding to memo for case=false
            if (isNeighbourSafe) {
                memo.put(neighbour, true);
            } else {
                return false;
            }
        }

        // Check other paths which don't involve this node
        visited.remove(node);

        return true;
    }
}
