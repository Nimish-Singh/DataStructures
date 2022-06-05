package graph.lcStudyPlan;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxAreaOfIslandTest {
    private MaxAreaOfIsland ma = new MaxAreaOfIsland();
    private int[][] grid;

    @Test
    public void sampleInput1() {
        grid = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}};

        assertEquals(0, ma.maxAreaOfIsland(grid));
    }

    @Test
    public void sampleInput2() {
        grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                           {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                           {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                           {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                           {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                           {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                           {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                           {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        assertEquals(6, ma.maxAreaOfIsland(grid));
    }

    @Test
    public void sampleInput3() {
        grid = new int[][]{{1, 1},
                           {1, 1}};

        assertEquals(4, ma.maxAreaOfIsland(grid));
    }
}
