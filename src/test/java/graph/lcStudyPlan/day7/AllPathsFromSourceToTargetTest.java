package graph.lcStudyPlan.day7;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AllPathsFromSourceToTargetTest {
    private AllPathsFromSourceToTarget pathsToTarget = new AllPathsFromSourceToTarget();
    private int[][] graph;

    @Test
    public void sampleInput1() {
        graph = new int[][]{{1, 2},
                            {3},
                            {3},
                            {}};

        List<List<Integer>> paths = pathsToTarget.allPathsSourceTarget(graph);
        assertEquals(2, paths.size());
        assertArrayEquals(new int[]{0, 1, 3}, paths.get(0).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{0, 2, 3}, paths.get(1).stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput2() {
        graph = new int[][]{{4, 3, 1},
                            {3, 2, 4},
                            {3},
                            {4},
                            {}};

        List<List<Integer>> paths = pathsToTarget.allPathsSourceTarget(graph);
        assertEquals(5, paths.size());
        assertArrayEquals(new int[]{0, 4}, paths.get(0).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{0, 3, 4}, paths.get(1).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{0, 1, 3, 4}, paths.get(2).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, paths.get(3).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{0, 1, 4}, paths.get(4).stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput3() {
        graph = new int[][]{{1, 2},
                            {3},
                            {},
                            {}};

        List<List<Integer>> paths = pathsToTarget.allPathsSourceTarget(graph);
        assertEquals(1, paths.size());
        assertArrayEquals(new int[]{0, 1, 3}, paths.get(0).stream().mapToInt(x -> x).toArray());
    }
}
