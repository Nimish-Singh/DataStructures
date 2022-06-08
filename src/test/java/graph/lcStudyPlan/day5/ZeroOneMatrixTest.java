package graph.lcStudyPlan.day5;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ZeroOneMatrixTest {
    private ZeroOneMatrix zom = new ZeroOneMatrix();
    private int[][] mat;

    @Test
    public void sampleInput1() {
        mat = new int[][]{{0, 0, 0},
                          {0, 1, 0},
                          {0, 0, 0}};

        int[][] distances = zom.updateMatrix(mat);
        assertArrayEquals(new int[]{0, 0, 0}, distances[0]);
        assertArrayEquals(new int[]{0, 1, 0}, distances[1]);
        assertArrayEquals(new int[]{0, 0, 0}, distances[2]);
    }

    @Test
    public void sampleInput2() {
        mat = new int[][]{{0, 0, 0},
                          {0, 1, 0},
                          {1, 1, 1}};

        int[][] distances = zom.updateMatrix(mat);
        assertArrayEquals(new int[]{0, 0, 0}, distances[0]);
        assertArrayEquals(new int[]{0, 1, 0}, distances[1]);
        assertArrayEquals(new int[]{1, 2, 1}, distances[2]);
    }
}
