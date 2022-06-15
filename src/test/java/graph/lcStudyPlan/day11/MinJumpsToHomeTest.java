package graph.lcStudyPlan.day11;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinJumpsToHomeTest {
    private MinJumpsToHome min = new MinJumpsToHome();
    private int[] forbidden;

    @Test
    public void sampleInput1() {
        forbidden = new int[]{14, 4, 18, 1, 15};
        assertEquals(3, min.minimumJumps(forbidden, 3, 15, 9));
    }

    @Test
    public void sampleInput2() {
        forbidden = new int[]{3, 6, 8, 12, 16, 20};
        assertEquals(-1, min.minimumJumps(forbidden, 15, 13, 11));
    }

    @Test
    public void sampleInput3() {
        forbidden = new int[]{1, 6, 2, 14, 5, 17, 4};
        assertEquals(2, min.minimumJumps(forbidden, 16, 9, 7));
    }

    @Test
    public void sampleInput4() {
        forbidden = new int[]{162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98};
        assertEquals(121, min.minimumJumps(forbidden, 29, 98, 80));
    }
}
