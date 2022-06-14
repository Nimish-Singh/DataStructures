package graph.lcStudyPlan.day11;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JumpGame3Test {
    private JumpGame3 jg = new JumpGame3();
    private int[] arr;

    @Test
    public void sampleInput1() {
        arr = new int[]{4, 2, 3, 0, 3, 1, 2};
        assertTrue(jg.canReach(arr, 5));
    }

    @Test
    public void sampleInput2() {
        arr = new int[]{4, 2, 3, 0, 3, 1, 2};
        assertTrue(jg.canReach(arr, 0));
    }

    @Test
    public void sampleInput3() {
        arr = new int[]{3, 0, 2, 1, 2};
        assertFalse(jg.canReach(arr, 2));
    }
}
