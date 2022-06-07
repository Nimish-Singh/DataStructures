package graph.lcStudyPlan.day4;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PacificAtlanticWaterFlowTest {
    private PacificAtlanticWaterFlow pawf = new PacificAtlanticWaterFlow();
    private int[][] heights;

    @Test
    public void sampleInput1() {
        heights = new int[][]{{1, 2, 2, 3, 5},
                               {3, 2, 3, 4, 4},
                               {2, 4, 5, 3, 1},
                               {6, 7, 1, 4, 5},
                               {5, 1, 1, 2, 4}};

        List<List<Integer>> coordinates = pawf.pacificAtlantic(heights);

        assertEquals(7, coordinates.size());
        assertArrayEquals(new int[]{0, 4}, coordinates.get(0).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{1, 3}, coordinates.get(1).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{1, 4}, coordinates.get(2).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{2, 2}, coordinates.get(3).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{3, 0}, coordinates.get(4).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{3, 1}, coordinates.get(5).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{4, 0}, coordinates.get(6).stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput2() {
        heights = new int[][]{{2, 1},
                              {1, 2}};

        List<List<Integer>> coordinates = pawf.pacificAtlantic(heights);

        assertEquals(4, coordinates.size());
        assertArrayEquals(new int[]{0, 0}, coordinates.get(0).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{0, 1}, coordinates.get(1).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{1, 0}, coordinates.get(2).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{1, 1}, coordinates.get(3).stream().mapToInt(x -> x).toArray());
    }
}
