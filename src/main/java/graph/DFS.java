package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public List<Integer> traverse(AdjacencyMatrix graph, int startNode) {
        List<Integer> traversal = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.getNumberOfNodes()];
        stack.add(startNode);
        do {
            startNode = stack.pop();
            traversal.add(startNode);
            visited[startNode] = true;
            graph.getAdjacentNodesUndirected(startNode).forEach(node -> {
                if (!visited[node])
                    stack.add(node);
            });
        } while(!stack.isEmpty());
        return traversal;
    }
}
