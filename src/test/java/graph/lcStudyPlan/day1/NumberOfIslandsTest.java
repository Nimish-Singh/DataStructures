package graph.lcStudyPlan.day1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfIslandsTest {
    private NumberOfIslands noi = new NumberOfIslands();
    private char[][] grid;

    @Test
    public void sampleInput1() {
        grid = new char[][]{{'1', '1', '1', '1', '0'},
                            {'1', '1', '0', '1', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '0', '0', '0'}};

        assertEquals(1, noi.numIslands(grid));
    }

    @Test
    public void sampleInput2() {
        grid = new char[][]{{'1', '1', '0', '0', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '1', '0', '0'},
                            {'0', '0', '0', '1', '1'}};

        assertEquals(3, noi.numIslands(grid));
    }

    @Test
    public void sampleInput3() {
        grid = new char[][]{{'0', '0', '0', '0', '0'}};

        assertEquals(0, noi.numIslands(grid));
    }

    @Test
    public void sampleInput4() {
        grid = new char[][]{{'1', '0'},
                            {'0', '1'}};

        assertEquals(2, noi.numIslands(grid));
    }
}
