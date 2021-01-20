package graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BFSTest {
    private AdjacencyMatrix graph = new AdjacencyMatrix(6);
    private BFS bfs = new BFS();

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
        assertArrayEquals(new int[]{1, 0, 3, 2, 5, 4}, bfs.traverse(graph, 1).stream().mapToInt(x -> x).toArray());
    }
}
