package graph.lcStudyPlan.day12;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordLadderTest {
    private WordLadder wl = new WordLadder();
    private List<String> wordList;

    @Test
    public void sampleInput1() {
        wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        assertEquals(5, wl.ladderLength("hit", "cog", wordList));
    }

    @Test
    public void sampleInput2() {
        wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
        assertEquals(0, wl.ladderLength("hit", "cog", wordList));
    }
}
