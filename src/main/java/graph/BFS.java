package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BFS {
    public List<Integer> traverse(AdjacencyMatrix graph, int startNode) {
        List<Integer> traversal = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.getNumberOfNodes()];
        queue.add(startNode);
        do {
            startNode = queue.remove();
            traversal.add(startNode);
            visited[startNode] = true;
            graph.getAdjacentNodesUndirected(startNode).forEach(node -> {
                if (!visited[node])
                    queue.add(node);
            });
        } while(!queue.isEmpty());
        return traversal;
    }
}
