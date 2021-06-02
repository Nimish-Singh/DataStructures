package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GroupTest {
    private Group group = new Group();

    @Test
    public void sampleInput1() {
        List<List<Integer>> edges = new ArrayList<>();
        assertEquals(3, group.findNumber(3, edges));
    }

    @Test
    public void sampleInput2() {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 0));
        edges.add(Arrays.asList(1, 1));
        edges.add(Arrays.asList(2, 2));
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 0));
        assertEquals(2, group.findNumber(3, edges));
    }

    @Test
    public void sampleInput3() {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(1, 3));
        edges.add(Arrays.asList(2, 4));
        edges.add(Arrays.asList(6, 7));
        assertEquals(5, group.findNumber(10, edges));
    }
}
