package graph.lcStudyPlan.day12;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinGeneticMutationTest {
    private MinGeneticMutation min = new MinGeneticMutation();
    private String[] bank;

    @Test
    public void sampleInput1() {
        bank = new String[]{"AACCGGTA"};
        assertEquals(1, min.minMutation("AACCGGTT", "AACCGGTA", bank));
    }

    @Test
    public void sampleInput2() {
        bank = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        assertEquals(2, min.minMutation("AACCGGTT", "AAACGGTA", bank));
    }


    @Test
    public void sampleInput3() {
        bank = new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        assertEquals(3, min.minMutation("AAAAACCC", "AACCCCCC", bank));
    }
}
