package graph.lcStudyPlan.day14;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PossibleBipartitionTest {
    private PossibleBipartition pb = new PossibleBipartition();
    private int[][] dislikes;

    @Test
    public void sampleInput1() {
        dislikes = new int[][]{{1, 2},
                               {1, 3},
                               {2, 4}};
        assertTrue(pb.possibleBipartition(4, dislikes));
    }

    @Test
    public void sampleInput2() {
        dislikes = new int[][]{{1, 2},
                               {1, 3},
                               {2, 3}};
        assertFalse(pb.possibleBipartition(3, dislikes));
    }

    @Test
    public void sampleInput3() {
        dislikes = new int[][]{{1, 2},
                               {2, 3},
                               {3, 4},
                               {4, 5},
                               {1, 5}};
        assertFalse(pb.possibleBipartition(5, dislikes));
    }
}
