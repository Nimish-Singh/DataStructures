package graph.lcStudyPlan.day6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NearestExitFromEntranceInMazeTest {
    private NearestExitFromEntranceInMaze ne = new NearestExitFromEntranceInMaze();
    private char[][] maze;
    private int[] entrance;

    @Test
    public void sampleInput1() {
        maze = new char[][]{{'+', '+', '.', '+'},
                            {'.', '.', '.', '+'},
                            {'+', '+', '+', '.'}};
        entrance = new int[]{1, 2};

        assertEquals(1, ne.nearestExit(maze, entrance));
    }

    @Test
    public void sampleInput2() {
        maze = new char[][]{{'+', '+', '+'},
                            {'.', '.', '.'},
                            {'+', '+', '+'}};
        entrance = new int[]{1, 0};

        assertEquals(2, ne.nearestExit(maze, entrance));
    }

    @Test
    public void sampleInput3() {
        maze = new char[][]{{'.', '+'}};
        entrance = new int[]{0, 0};

        assertEquals(-1, ne.nearestExit(maze, entrance));
    }
}
