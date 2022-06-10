package graph.lcStudyPlan.day7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KeysAndRoomsTest {
    private KeysAndRooms kr = new KeysAndRooms();
    private List<List<Integer>> rooms;

    @Test
    public void sampleInput1() {
        rooms = new ArrayList<>();
        rooms.add(Collections.singletonList(1));
        rooms.add(Collections.singletonList(2));
        rooms.add(Collections.singletonList(3));
        rooms.add(Collections.emptyList());

        assertTrue(kr.canVisitAllRooms(rooms));
    }

    @Test
    public void sampleInput2() {
        rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Collections.singletonList(2));
        rooms.add(Collections.singletonList(0));

        assertFalse(kr.canVisitAllRooms(rooms));
    }
}
