package graph.lcStudyPlan.day5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortestClearPathTest {
    private ShortestClearPath scl = new ShortestClearPath();
    private int[][] grid;

    @Test
    public void sampleInput1() {
        grid = new int[][]{{0, 1},
                           {1, 0}};

        assertEquals(2, scl.shortestPathBinaryMatrix(grid));
    }

    @Test
    public void sampleInput2() {
        grid = new int[][]{{0, 0, 0},
                           {1, 1, 0},
                           {1, 1, 0}};

        assertEquals(4, scl.shortestPathBinaryMatrix(grid));
    }

    @Test
    public void sampleInput3() {
        grid = new int[][]{{1, 0, 0},
                           {1, 1, 0},
                           {1, 1, 0}};

        assertEquals(-1, scl.shortestPathBinaryMatrix(grid));
    }

    @Test
    public void sampleInput4() {
        grid = new int[][]{{0, 1, 1, 0, 0, 0},
                           {0, 1, 0, 1, 1, 0},
                           {0, 1, 1, 0, 1, 0},
                           {0, 0, 0, 1, 1, 0},
                           {1, 1, 1, 1, 1, 0},
                           {1, 1, 1, 1, 1, 0}};

        assertEquals(14, scl.shortestPathBinaryMatrix(grid));
    }
}
