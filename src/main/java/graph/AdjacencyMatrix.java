package graph;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdjacencyMatrix {
    private int[][] matrix;

    AdjacencyMatrix(int numberOfNodes) {
        matrix = new int[numberOfNodes][numberOfNodes];
    }

    public void addEdge(int u, int v) {
        matrix[u][v] = 1;
    }

    public void addEdge(int u, int v, int weight) {
        matrix[u][v] = weight;
    }

    public void removeEdge(int u, int v) {
        matrix[u][v] = 0;
    }

    public List<Integer> getAdjacentNodes(int node) {
        return IntStream.range(0, matrix[0].length)
                .filter(x -> matrix[node][x] != 0)
                .boxed()
                .collect(Collectors.toList());
    }

    public boolean areAdjacent(int u, int v) {
        return matrix[u][v] != 0;
    }

    public int getWeightOfEdgeBetween(int u, int v) {
        return matrix[u][v];
    }
}
