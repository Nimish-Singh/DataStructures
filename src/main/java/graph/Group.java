package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/* Given a graph, find the number of groups that can be formed in the graph. A group is defined as the set of nodes
which have an edge between one another (similar to connected components)
 */
public class Group {
    private List<List<Integer>> adjacencyList = new ArrayList<>();
    private int groups = 0;

    public int findNumber(int vertices, List<List<Integer>> edges) {
        IntStream.range(0, vertices)
                .forEach(index -> adjacencyList.add(index, new ArrayList<>()));

        edges.stream().filter(edge -> !edge.get(0).equals(edge.get(1)))
                .forEach(edge -> {
                    adjacencyList.get(edge.get(0)).add(edge.get(1));
                    adjacencyList.get(edge.get(1)).add(edge.get(0));
                });

        boolean[] visited = new boolean[vertices];
        for (int vertex = 0; vertex < vertices; vertex++) {
            if (!visited[vertex]) {
                dfs(vertex, visited);
                groups++;
            }
        }
        return groups;
    }

    private void dfs(int vertex, boolean[] visited) {
        if (!visited[vertex]) {
            visited[vertex] = true;

            for (int neighbour : adjacencyList.get(vertex)) {
                if (!visited[neighbour]) {
                    dfs(neighbour, visited);
                }
            }
        }
    }
}
