package graph.lcStudyPlan.day8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfProvincesTest {
    private NumberOfProvinces nop = new NumberOfProvinces();
    private int[][] isConnected;

    @Test
    public void sampleInput1() {
        isConnected = new int[][]{{1, 1, 0},
                                  {1, 1, 0},
                                  {0, 0, 1}};

        assertEquals(2, nop.findCircleNum(isConnected));
    }

    @Test
    public void sampleInput2() {
        isConnected = new int[][]{{1, 0, 0},
                                  {0, 1, 0},
                                  {0, 0, 1}};

        assertEquals(3, nop.findCircleNum(isConnected));
    }
}
