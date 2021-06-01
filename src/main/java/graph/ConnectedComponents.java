package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/* Find efficiency of an undirected graph where,
efficiency = sum of individual efficiencies of connected components.
Individual efficiency = ceil (square root (number of nodes in the connected component) ) */
public class ConnectedComponents {
    private List<List<Integer>> adjacencyList = new ArrayList<>();
    private int numberOfNodes = 0;
    private int efficiency = 0;

    public int findEfficiency(int vertices, List<List<Integer>> edges) {
        IntStream.range(0, vertices)
                .forEach(index -> adjacencyList.add(index, new ArrayList<>()));

        edges.forEach(edge -> {
            adjacencyList.get(edge.get(0)).add(edge.get(1));
            adjacencyList.get(edge.get(1)).add(edge.get(0));
        });

        boolean[] visited = new boolean[vertices];
        for (int vertex = 0; vertex < vertices; vertex++) {
            if (!visited[vertex]) {
                numberOfNodes = 1;
                dfs(vertex, visited);
                efficiency += Math.ceil(Math.sqrt(numberOfNodes));
            }
        }
        return efficiency;
    }

    private void dfs(int vertex, boolean[] visited) {
        if (!visited[vertex]) {
            visited[vertex] = true;

            for (int neighbour : adjacencyList.get(vertex)) {
                if (!visited[neighbour]) {
                    ++numberOfNodes;
                    dfs(neighbour, visited);
                }
            }
        }
    }
}
