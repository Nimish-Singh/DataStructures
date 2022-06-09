package graph.lcStudyPlan.day6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortestBridgeTest {
    private ShortestBridge sb = new ShortestBridge();
    private int[][] grid;

    @Test
    public void sampleInput1() {
        grid = new int[][]{{0, 1},
                           {1, 0}};

        assertEquals(1, sb.shortestBridge(grid));
    }

    @Test
    public void sampleInput2() {
        grid = new int[][]{{0, 1, 0},
                           {0, 0, 0},
                           {0, 0, 1}};

        assertEquals(2, sb.shortestBridge(grid));
    }

    @Test
    public void sampleInput3() {
        grid = new int[][]{{1, 1, 1, 1, 1},
                           {1, 0, 0, 0, 1},
                           {1, 0, 1, 0, 1},
                           {1, 0, 0, 0, 1},
                           {1, 1, 1, 1, 1}};

        assertEquals(1, sb.shortestBridge(grid));
    }
}
