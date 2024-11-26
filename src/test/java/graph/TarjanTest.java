package graph;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TarjanTest {
    private final Tarjan tarjan = new Tarjan();
    private List<List<Integer>> edges;

    @Test
    public void sampleInput1() {
        edges = List.of(List.of(0, 1), List.of(1, 2), List.of(2, 0), List.of(1, 3));

        List<List<Integer>> bridges = tarjan.findBridges(4, edges);

        assertEquals(1, bridges.size());
        assertArrayEquals(new int[]{1, 3}, bridges.get(0).stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput2() {
        edges = List.of(List.of(0, 1));

        List<List<Integer>> bridges = tarjan.findBridges(2, edges);

        assertEquals(1, bridges.size());
        assertArrayEquals(new int[]{0, 1}, bridges.get(0).stream().mapToInt(x -> x).toArray());
    }
}
