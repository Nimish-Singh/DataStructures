package graph.lcStudyPlan.day2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfClosedIslandsTest {
    private NumberOfClosedIslands nci = new NumberOfClosedIslands();
    private int[][] grid;

    @Test
    public void sampleInput1() {
        grid = new int[][]{{1, 1, 1, 1, 1, 1, 1, 0},
                           {1, 0, 0, 0, 0, 1, 1, 0},
                           {1, 0, 1, 0, 1, 1, 1, 0},
                           {1, 0, 0, 0, 0, 1, 0, 1},
                           {1, 1, 1, 1, 1, 1, 1, 0}};

        assertEquals(2, nci.closedIsland(grid));
    }

    @Test
    public void sampleInput2() {
        grid = new int[][]{{0, 0, 1, 0, 0},
                           {0, 1, 0, 1, 0},
                           {0, 1, 1, 1, 0}};

        assertEquals(1, nci.closedIsland(grid));
    }

    @Test
    public void sampleInput3() {
        grid = new int[][]{{1, 1, 1, 1, 1, 1, 1},
                           {1, 0, 0, 0, 0, 0, 1},
                           {1, 0, 1, 1, 1, 0, 1},
                           {1, 0, 1, 0, 1, 0, 1},
                           {1, 0, 1, 1, 1, 0, 1},
                           {1, 0, 0, 0, 0, 0, 1},
                           {1, 1, 1, 1, 1, 1, 1}};

        assertEquals(2, nci.closedIsland(grid));
    }

    @Test
    public void sampleInput4() {
        grid = new int[][]{{1, 1, 1},
                           {1, 1, 1}};

        assertEquals(0, nci.closedIsland(grid));
    }

    @Test
    public void sampleInput5() {
        grid = new int[][]{{0, 0},
                           {0, 0}};

        assertEquals(0, nci.closedIsland(grid));
    }
}
