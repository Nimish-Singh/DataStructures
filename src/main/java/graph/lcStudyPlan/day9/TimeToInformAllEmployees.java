package graph.lcStudyPlan.day9;

import java.util.Arrays;

// https://leetcode.com/problems/time-needed-to-inform-all-employees/
public class TimeToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n <= 1)
            return 0;

        int timeNeeded = 0;
        int[] times = new int[n];
        Arrays.fill(times, -1);
        for (int index = 0; index < n; index++) {
           int currentTimeCounter = 0;
           int currEmployee = index;

           while (currEmployee != headID) {
               if (times[currEmployee] != -1)
                   break;
               currentTimeCounter += informTime[manager[currEmployee]];
               currEmployee = manager[currEmployee];
           }

           if (currentTimeCounter > timeNeeded)
               timeNeeded = currentTimeCounter;
        }
        return timeNeeded;
    }
}
