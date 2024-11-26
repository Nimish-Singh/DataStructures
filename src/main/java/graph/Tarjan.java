package graph;

import java.util.*;

// https://www.geeksforgeeks.org/bridge-in-a-graph/
public class Tarjan {
    private int timer = 0;
    private int[] disc, low;
    private List<List<Integer>> answer = new ArrayList<>();
    private Map<Integer, List<Integer>> adj = new HashMap<>();

    public List<List<Integer>> findBridges(int n, List<List<Integer>> edges) {
        disc = new int[n];
        Arrays.fill(disc, -1);
        low = new int[n];

        for (int i = 0; i < n; i++)
            adj.put(i, new ArrayList<>());

        for (List<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        dfs(0, -1);
        return answer;
    }

    private void dfs(int node, int parent) {
        disc[node] = low[node] = ++timer;
        for (int neighbour : adj.get(node)) {
            if (neighbour == parent)
                continue;

            if (disc[neighbour] == -1) {
                dfs(neighbour, node);
                low[node] = Math.min(low[node], low[neighbour]);
            } else {
                low[node] = Math.min(low[node], disc[neighbour]);
            }

            if (low[neighbour] > disc[node])
                answer.add(Arrays.asList(node, neighbour));
        }
    }
}
