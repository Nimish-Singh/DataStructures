package graph.lcStudyPlan.day13;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class MinVerticesToReachAllNodesTest {
    private MinVerticesToReachAllNodes min = new MinVerticesToReachAllNodes();
    private List<List<Integer>> edges;

    @Test
    public void sampleInput1() {
        edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(2, 5));
        edges.add(Arrays.asList(3, 4));
        edges.add(Arrays.asList(4, 2));
        assertArrayEquals(new int[]{0, 3}, min.findSmallestSetOfVertices(6, edges).stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput2() {
        edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(2, 1));
        edges.add(Arrays.asList(3, 1));
        edges.add(Arrays.asList(1, 4));
        edges.add(Arrays.asList(2, 4));
        assertArrayEquals(new int[]{0, 2, 3}, min.findSmallestSetOfVertices(5, edges).stream().mapToInt(x -> x).toArray());
    }
}
