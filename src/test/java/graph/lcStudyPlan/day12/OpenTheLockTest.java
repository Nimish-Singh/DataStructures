package graph.lcStudyPlan.day12;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OpenTheLockTest {
    private OpenTheLock open = new OpenTheLock();
    private String[] deadEnds;

    @Test
    public void sampleInput1() {
        deadEnds = new String[]{"0201", "0101", "0102", "1212", "2002"};
        assertEquals(6, open.openLock(deadEnds, "0202"));
    }

    @Test
    public void sampleInput2() {
        deadEnds = new String[]{"8888"};
        assertEquals(1, open.openLock(deadEnds, "0009"));
    }

    @Test
    public void sampleInput3() {
        deadEnds = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        assertEquals(-1, open.openLock(deadEnds, "8888"));
    }

    @Test
    public void sampleInput4() {
        deadEnds = new String[]{"0000"};
        assertEquals(-1, open.openLock(deadEnds, "8888"));
    }
}
