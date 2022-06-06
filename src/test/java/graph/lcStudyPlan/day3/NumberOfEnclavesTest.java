package graph.lcStudyPlan.day3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfEnclavesTest {
    private NumberOfEnclaves noe = new NumberOfEnclaves();
    private int[][] grid;

    @Test
    public void sampleInput1() {
        grid = new int[][]{{0, 0, 0, 0},
                           {1, 0, 1, 0},
                           {0, 1, 1, 0},
                           {0, 0, 0, 0}};

        assertEquals(3, noe.numEnclaves(grid));
    }

    @Test
    public void sampleInput2() {
        grid = new int[][]{{0, 1, 1, 0},
                           {0, 0, 1, 0},
                           {0, 0, 1, 0},
                           {0, 0, 0, 0}};

        assertEquals(0, noe.numEnclaves(grid));
    }

    @Test
    public void sampleInput3() {
        grid = new int[][]{{0, 0, 0, 0},
                           {0, 0, 0, 0},
                           {0, 0, 0, 0}};

        assertEquals(0, noe.numEnclaves(grid));
    }

    @Test
    public void sampleInput4() {
        grid = new int[][]{{1, 1, 1, 1},
                           {1, 1, 1, 1}};

        assertEquals(0, noe.numEnclaves(grid));
    }
}
