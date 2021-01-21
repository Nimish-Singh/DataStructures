package graph;

import java.util.Arrays;
import java.util.stream.IntStream;

// Single source multiple destination shortest distance, with no negative weights
public class Djikstra {
    private boolean[] visited;
    private int[] distance;

    public void traverse(AdjacencyMatrix graph, int startNode) {
        visited = new boolean[graph.getNumberOfNodes()];
        distance = new int[graph.getNumberOfNodes()];
        IntStream.range(0, distance.length).forEach(index -> distance[index] = Integer.MAX_VALUE);

        distance[startNode] = 0;

        for (int i = 0; i < distance.length; i++) {
            int nextNode = minimumDistance();
            visited[nextNode] = true;

            graph.getAdjacentNodesUndirected(nextNode).forEach(node -> {
                // Because weight considers graph as directed, we need to modify
                // addEdge method to make it behave like undirected graph
                if (!visited[node] && distance[nextNode] + graph.getWeightOfEdgeBetween(nextNode, node) < distance[node])
                    distance[node] = distance[nextNode] + graph.getWeightOfEdgeBetween(nextNode, node);
            });
        }

        Arrays.stream(distance).forEach(System.out::println);
    }

    private int minimumDistance() {
        int min = Integer.MAX_VALUE;
        int minNode = -1;
        for (int i = 0; i < distance.length; i++)
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minNode = i;
            }
        return minNode;
    }
}
