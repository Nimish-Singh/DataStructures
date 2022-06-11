package graph.lcStudyPlan.day8;

// https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int totalCities = isConnected.length;
        DisjointSet ds = new DisjointSet(totalCities);

        for (int row = 0; row < isConnected.length; row++) {
            for (int column = 0; column < isConnected[0].length; column++) {
                if (isConnected[row][column] == 1 && row != column) {
                    ds.union(row, column);
                }
            }
        }

        return ds.getSetCount();
    }
}
