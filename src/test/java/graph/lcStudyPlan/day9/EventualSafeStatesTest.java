package graph.lcStudyPlan.day9;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class EventualSafeStatesTest {
    private EventualSafeStates safeStates = new EventualSafeStates();
    private int[][] graph;

    @Test
    public void sampleInput1() {
        graph = new int[][]{{1, 2},
                            {2, 3},
                            {5},
                            {0},
                            {5},
                            {},
                            {}};
        assertArrayEquals(new int[] {2, 4, 5, 6}, safeStates.eventualSafeNodes(graph).stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput2() {
        graph = new int[][]{{1, 2, 3, 4},
                            {1, 2},
                            {3, 4},
                            {0, 4},
                            {}};
        assertArrayEquals(new int[] {4}, safeStates.eventualSafeNodes(graph).stream().mapToInt(x -> x).toArray());
    }
}
