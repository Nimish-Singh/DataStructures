package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConnectedComponentsTest {
    private ConnectedComponents components = new ConnectedComponents();

    @Test
    public void sampleInput1() {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(1, 3));
        edges.add(Arrays.asList(2, 4));
        edges.add(Arrays.asList(6, 7));
        assertEquals(8, components.findEfficiency(10, edges));
    }

    @Test
    public void sampleInput2() {
        List<List<Integer>> edges = new ArrayList<>();
        assertEquals(5, components.findEfficiency(5, edges));
    }

    @Test
    public void sampleInput3() {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(2, 3));
        edges.add(Arrays.asList(3, 4));
        assertEquals(3, components.findEfficiency(5, edges));
    }
}
