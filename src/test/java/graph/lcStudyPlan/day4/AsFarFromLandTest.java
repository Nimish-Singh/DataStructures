package graph.lcStudyPlan.day4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AsFarFromLandTest {
    private AsFarFromLand afl = new AsFarFromLand();
    private int[][] grid;

    @Test
    public void sampleInput1() {
        grid = new int[][]{{1, 0, 1},
                           {0, 0, 0},
                           {1, 0, 1}};

        assertEquals(2, afl.maxDistance(grid));
    }

    @Test
    public void sampleInput2() {
        grid = new int[][]{{1, 0, 0},
                           {0, 0, 0},
                           {0, 0, 0}};

        assertEquals(4, afl.maxDistance(grid));
    }

    @Test
    public void sampleInput3() {
        grid = new int[][]{{1, 1, 1},
                           {1, 1, 1},
                           {1, 1, 1}};

        assertEquals(-1, afl.maxDistance(grid));
    }

    @Test
    public void sampleInput4() {
        grid = new int[][]{{0, 0},
                           {0, 0},
                           {0, 0}};

        assertEquals(-1, afl.maxDistance(grid));
    }
}
