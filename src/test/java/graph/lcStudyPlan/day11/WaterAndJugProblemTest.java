package graph.lcStudyPlan.day11;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WaterAndJugProblemTest {
    private WaterAndJugProblem wj = new WaterAndJugProblem();

    @Test
    public void sampleInput1() {
        assertTrue(wj.canMeasureWater(3, 5, 4));
    }

    @Test
    public void sampleInput2() {
        assertTrue(wj.canMeasureWater(1, 2, 3));
    }

    @Test
    public void sampleInput3() {
        assertFalse(wj.canMeasureWater(2, 6, 5));
    }
}
