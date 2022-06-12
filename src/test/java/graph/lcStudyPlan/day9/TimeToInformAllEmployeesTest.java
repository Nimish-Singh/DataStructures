package graph.lcStudyPlan.day9;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeToInformAllEmployeesTest {
    private TimeToInformAllEmployees t = new TimeToInformAllEmployees();
    private int[] manager;
    private int[] informTime;
    private int headId;

    @Test
    public void sampleInput1() {
        headId = 0;
        manager = new int[]{-1};
        informTime = new int[]{0};

        assertEquals(0, t.numOfMinutes(1, headId, manager, informTime));
    }

    @Test
    public void sampleInput2() {
        headId = 2;
        manager = new int[]{2, 2, -1, 2, 2, 2};
        informTime = new int[]{0, 0, 1, 0, 0, 0};

        assertEquals(1, t.numOfMinutes(6, headId, manager, informTime));
    }

    @Test
    public void sampleInput3() {
        headId = 6;
        manager = new int[]{1, 2, 3, 4, 5, 6, -1};
        informTime = new int[]{0, 6, 5, 4, 3, 2, 1};

        assertEquals(21, t.numOfMinutes(7, headId, manager, informTime));
    }

    @Test
    public void sampleInput4() {
        headId = 0;
        manager = new int[]{-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        informTime = new int[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};

        assertEquals(3, t.numOfMinutes(15, headId, manager, informTime));
    }
}
