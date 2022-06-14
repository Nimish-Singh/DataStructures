package graph.lcStudyPlan.day10;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ShortestPathWithAlternatingColoursTest {
    private ShortestPathWithAlternatingColours sp = new ShortestPathWithAlternatingColours();
    private int[][] redEdges;
    private int[][] blueEdges;

    @Test
    public void SampleInput1() {
        redEdges = new int[][]{{0, 1},
                               {1, 2}};
        blueEdges = new int[][]{};

        assertArrayEquals(new int[] {0, 1, -1}, sp.shortestAlternatingPaths(3, redEdges, blueEdges));
    }

    @Test
    public void SampleInput2() {
        redEdges = new int[][]{{0, 1}};
        blueEdges = new int[][]{{2, 1}};

        assertArrayEquals(new int[] {0, 1, -1}, sp.shortestAlternatingPaths(3, redEdges, blueEdges));
    }
}
