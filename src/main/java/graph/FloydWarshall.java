package graph;

// Shortest distances between each pair of nodes, even with negative weight (but no negative cycle)
public class FloydWarshall {

    public int shortestDistance(AdjacencyMatrix graph, int sourceNode, int destinationNode) {
        int nodes = graph.getNumberOfNodes();
        int[][] paths = new int[nodes][nodes];

        for (int i = 0; i < nodes; i++)
            for (int j = 0; j < nodes; j++) {
                if (i == j)
                    paths[i][j] = 0;
                else
                    paths[i][j] = graph.getWeightOfEdgeBetween(i, j) == 0 ? Integer.MAX_VALUE : graph.getWeightOfEdgeBetween(i, j);
            }

        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (i == j)
                        paths[i][j] = 0;
                    else if (!(paths[i][k] == Integer.MAX_VALUE || paths[k][j] == Integer.MAX_VALUE))
                        paths[i][j] = Math.min(paths[i][j], paths[i][k] + paths[k][j]);
                }
            }
        }
        return paths[sourceNode][destinationNode];
    }
}
