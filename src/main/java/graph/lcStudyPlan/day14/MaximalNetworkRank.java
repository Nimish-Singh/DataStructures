package graph.lcStudyPlan.day14;

// https://leetcode.com/problems/maximal-network-rank/
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] indegrees = new int[n];
        boolean[][] connected = new boolean[n][n];

        for (int[] road : roads) {
            indegrees[road[0]]++;
            indegrees[road[1]]++;
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
        }

        int maxDegree = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int newDegree = indegrees[i] + indegrees[j] - (connected[i][j] ? 1 : 0);

                maxDegree = Math.max(maxDegree, newDegree);
            }
        }

        return maxDegree;
    }
}
