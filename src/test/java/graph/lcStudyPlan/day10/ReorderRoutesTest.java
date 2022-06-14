package graph.lcStudyPlan.day10;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReorderRoutesTest {
    private ReorderRoutes rr = new ReorderRoutes();
    private int[][] connections;

    @Test
    public void sampleInput1() {
        connections = new int[][]{{0, 1},
                                  {1, 3},
                                  {2, 3},
                                  {4, 0},
                                  {4, 5}};

        assertEquals(3, rr.minReorder(6, connections));
    }

    @Test
    public void sampleInput2() {
        connections = new int[][]{{1, 0},
                                  {1, 2},
                                  {3, 2},
                                  {3, 4}};

        assertEquals(2, rr.minReorder(5, connections));
    }

    @Test
    public void sampleInput3() {
        connections = new int[][]{{1, 0},
                                  {2, 0}};

        assertEquals(0, rr.minReorder(3, connections));
    }
}
