package graph.lcStudyPlan.day14;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximalNetworkRankTest {
    private MaximalNetworkRank rank = new MaximalNetworkRank();
    private int[][] roads;

    @Test
    public void sampleInput1() {
        roads = new int[][]{{0, 1},
                            {0, 3},
                            {1, 2},
                            {1, 3}};
        assertEquals(4, rank.maximalNetworkRank(4, roads));
    }

    @Test
    public void sampleInput2() {
        roads = new int[][]{{0, 1},
                            {0, 3},
                            {1, 2},
                            {1, 3},
                            {2, 3},
                            {2, 4}};
        assertEquals(5, rank.maximalNetworkRank(5, roads));
    }

    @Test
    public void sampleInput3() {
        roads = new int[][]{{0, 1},
                            {1, 2},
                            {2, 3},
                            {2, 4},
                            {5, 6},
                            {5, 7}};
        assertEquals(5, rank.maximalNetworkRank(8, roads));
    }
}
