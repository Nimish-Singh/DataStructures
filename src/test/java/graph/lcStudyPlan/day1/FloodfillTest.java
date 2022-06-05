package graph.lcStudyPlan.day1;

import graph.lcStudyPlan.day1.Floodfill;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FloodfillTest {
    private Floodfill ff = new Floodfill();

    @Test
    public void sampleInput1() {
        int[][] image = new int[][]{{1, 1, 1},
                                    {1, 1, 0},
                                    {1, 0, 1}};

        int[][] floodFilled = ff.floodFill(image, 1, 1, 2);
        assertArrayEquals(new int[]{2, 2, 2}, floodFilled[0]);
        assertArrayEquals(new int[]{2, 2, 0}, floodFilled[1]);
        assertArrayEquals(new int[]{2, 0, 1}, floodFilled[2]);
    }

    @Test
    public void sampleInput2() {
        int[][] image = new int[][]{{0, 0, 0},
                                    {0, 0, 0}};

        int[][] floodFilled = ff.floodFill(image, 0, 0, 2);
        assertArrayEquals(new int[]{2, 2, 2}, floodFilled[0]);
        assertArrayEquals(new int[]{2, 2, 2}, floodFilled[1]);
    }
}
