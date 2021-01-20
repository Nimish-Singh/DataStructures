package graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DFSTest {
    private AdjacencyMatrix graph = new AdjacencyMatrix(6);
    private DFS dfs = new DFS();

    @Before
    public void setUp() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

    }

    @Test
    public void shouldGiveDFSTraversal() {
        assertArrayEquals(new int[]{1, 3, 5, 0, 2, 4}, dfs.traverse(graph, 1).stream().mapToInt(x -> x).toArray());
    }
}
