package graph.lcStudyPlan.day13;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
public class MinVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegrees = new int[n];

        for (List<Integer> edge : edges) {
            indegrees[edge.get(1)]++;
        }

        List<Integer> vertices = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            if (indegrees[index] == 0)
                vertices.add(index);
        }
        return vertices;
    }
}
