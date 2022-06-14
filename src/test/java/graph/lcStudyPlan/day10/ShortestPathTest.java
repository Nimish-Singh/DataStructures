package graph.lcStudyPlan.day10;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortestPathTest {
    private ShortestPath sp = new ShortestPath();
    private int[][] graph;

    @Test
    public void sampleInput1() {
        graph = new int[][]{{1, 2, 3},
                            {0},
                            {0},
                            {0}};
        assertEquals(4, sp.shortestPathLength(graph));
    }

    @Test
    public void sampleInput2() {
        graph = new int[][]{{1},
                            {0, 2, 4},
                            {1, 3, 4},
                            {2},
                            {1, 2}};
        assertEquals(4, sp.shortestPathLength(graph));
    }
}
