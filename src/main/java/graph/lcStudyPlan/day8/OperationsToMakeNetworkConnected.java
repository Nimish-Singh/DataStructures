package graph.lcStudyPlan.day8;

// https://leetcode.com/problems/number-of-operations-to-make-network-connected/
public class OperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        int totalEdges = connections.length;
        if (totalEdges < n - 1)
            return -1;

        DisjointSet ds = new DisjointSet(n);

        for (int[] connection : connections) {
            ds.union(connection[0], connection[1]);
        }
        return ds.getSetCount() - 1;
    }
}
