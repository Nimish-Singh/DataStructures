package graph;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdjacencyListTest {
    private AdjacencyList graph = new AdjacencyList(5);

    @Test
    public void shouldAddEdgeToGraph() {
        assertFalse(graph.areAdjacent(1, 2));
        graph.addEdge(1, 2);
        assertTrue(graph.areAdjacent(1, 2));
        assertFalse(graph.areAdjacent(2, 1));
    }

    @Test
    public void shouldRemoveEdgeFromGraph() {
        graph.addEdge(1, 2);
        assertTrue(graph.areAdjacent(1, 2));
        graph.removeEdge(1, 2);
        assertFalse(graph.areAdjacent(1, 2));
        assertFalse(graph.areAdjacent(2, 1));
    }

    @Test
    public void shouldAddEdgeWithWeight() {
        assertEquals(0, graph.getWeightOfEdgeBetween(2, 3));
        graph.addEdge(2, 3, 12);
        assertEquals(12, graph.getWeightOfEdgeBetween(2, 3));
    }

    @Test
    public void shouldTellIfNodesAreAdjacent() {
        assertFalse(graph.areAdjacent(1, 3));
        graph.addEdge(1, 3);
        assertTrue(graph.areAdjacent(1, 3));
    }

    @Test
    public void shouldReturnAdjacentNodes() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        List<Integer> adjacentNodes = graph.getAdjacentNodes(0);
        adjacentNodes.sort(Integer::compareTo);
        assertArrayEquals(new int[]{1, 3, 4}, adjacentNodes.stream().mapToInt(x -> x).toArray());
    }
}
