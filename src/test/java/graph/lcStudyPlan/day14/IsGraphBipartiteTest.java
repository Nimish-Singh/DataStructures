package graph.lcStudyPlan.day14;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsGraphBipartiteTest {
    private IsGraphBipartite bipartite = new IsGraphBipartite();
    private int[][] graph;

    @Test
    public void sampleInput1() {
        graph = new int[][]{{1, 2, 3},
                            {0, 2},
                            {0, 1, 3},
                            {0, 2}};
        assertFalse(bipartite.isBipartite(graph));
    }

    @Test
    public void sampleInput2() {
        graph = new int[][]{{1, 3},
                            {0, 2},
                            {1, 3},
                            {0, 2}};
        assertTrue(bipartite.isBipartite(graph));
    }

    @Test
    public void sampleInput3() {
        graph = new int[][]{{},
                            {2, 4, 6},
                            {1, 4, 8, 9},
                            {7, 8},
                            {1, 2, 8, 9},
                            {6, 9},
                            {1, 5, 7, 8, 9},
                            {3, 6, 9},
                            {2, 3, 4, 6, 9},
                            {2, 4, 5, 6, 7, 8}};
        assertFalse(bipartite.isBipartite(graph));
    }
}
