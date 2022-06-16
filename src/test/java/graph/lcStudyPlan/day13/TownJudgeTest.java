package graph.lcStudyPlan.day13;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TownJudgeTest {
    private TownJudge judge = new TownJudge();
    private int[][] trust;

    @Test
    public void sampleInput1() {
        trust = new int[][]{{1, 2}};
        assertEquals(2, judge.findJudge(2, trust));
    }

    @Test
    public void sampleInput2() {
        trust = new int[][]{{1, 3},
                            {2, 3}};
        assertEquals(3, judge.findJudge(3, trust));
    }

    @Test
    public void sampleInput3() {
        trust = new int[][]{{1, 3},
                            {2, 3},
                            {3, 1}};
        assertEquals(-1, judge.findJudge(3, trust));
    }

    @Test
    public void sampleInput4() {
        trust = new int[][]{};
        assertEquals(1, judge.findJudge(1, trust));
    }

    @Test
    public void sampleInput5() {
        trust = new int[][]{};
        assertEquals(-1, judge.findJudge(2, trust));
    }
}
