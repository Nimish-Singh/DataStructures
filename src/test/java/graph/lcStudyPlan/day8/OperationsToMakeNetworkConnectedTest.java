package graph.lcStudyPlan.day8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationsToMakeNetworkConnectedTest {
    private OperationsToMakeNetworkConnected ops = new OperationsToMakeNetworkConnected();
    private int[][] connections;

    @Test
    public void sampleInput1() {
        connections = new int[][]{{0, 1},
                                  {0, 2},
                                  {1, 2}};

        assertEquals(1, ops.makeConnected(4, connections));
    }

    @Test
    public void sampleInput2() {
        connections = new int[][]{{0, 1},
                                  {0, 2},
                                  {0, 3},
                                  {1, 2},
                                  {1, 3}};

        assertEquals(2, ops.makeConnected(6, connections));
    }

    @Test
    public void sampleInput3() {
        connections = new int[][]{{0, 1},
                                  {0, 2},
                                  {0, 3},
                                  {1, 2}};

        assertEquals(-1, ops.makeConnected(6, connections));
    }
}
