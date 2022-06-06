package graph.lcStudyPlan.day3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfSubIslandsTest {
    private NumberOfSubIslands nosi = new NumberOfSubIslands();
    private int[][] grid1;
    private int[][] grid2;

    @Test
    public void sampleInput1() {
        grid1 = new int[][]{{1, 1, 1, 0, 0},
                            {0, 1, 1, 1, 1},
                            {0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0},
                            {1, 1, 0, 1, 1}};

        grid2 = new int[][]{{1, 1, 1, 0, 0},
                            {0, 0, 1, 1, 1},
                            {0, 1, 0, 0, 0},
                            {1, 0, 1, 1, 0},
                            {0, 1, 0, 1, 0}};

        assertEquals(3, nosi.countSubIslands(grid1, grid2));
    }

    @Test
    public void sampleInput2() {
        grid1 = new int[][]{{1, 0, 1, 0, 1},
                            {1, 1, 1, 1, 1},
                            {0, 0, 0, 0, 0},
                            {1, 1, 1, 1, 1},
                            {1, 0, 1, 0, 1}};

        grid2 = new int[][]{{0, 0, 0, 0, 0},
                            {1, 1, 1, 1, 1},
                            {0, 1, 0, 1, 0},
                            {0, 1, 0, 1, 0},
                            {1, 0, 0, 0, 1}};

        assertEquals(2, nosi.countSubIslands(grid1, grid2));
    }

    @Test
    public void sampleInput3() {
        grid1 = new int[][]{{1, 0},
                            {1, 1},
                            {1, 0}};

        grid2 = new int[][]{{0, 0},
                            {0, 0},
                            {0, 0}};

        assertEquals(0, nosi.countSubIslands(grid1, grid2));
    }
}
