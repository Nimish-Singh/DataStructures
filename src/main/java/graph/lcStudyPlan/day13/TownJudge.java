package graph.lcStudyPlan.day13;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

// https://leetcode.com/problems/find-the-town-judge/
public class TownJudge {
    public int findJudge(int n, int[][] trust) {
//        return firstApproach(n, trust);

        return fasterApproach(n, trust);
    }

    private int fasterApproach(int n, int[][] trust) {
        int[] truster = new int[n + 1];
        int[] trusted = new int[n + 1];
        for (int[] trustRow : trust) {
            truster[trustRow[0]]++; // outdegree represented as -1
            trusted[trustRow[1]]++; // indegree represented as 1
        }
        for (int index = 1; index <= n; index++) {
            if (trusted[index] - truster[index] == n - 1)
                return index;
        }
        return -1;
    }

    private int firstApproach(int n, int[][] trust) {
        if (n == 1 && (trust == null || trust.length == 0))
            return 1;

        if (trust == null || trust.length == 0)
            return -1;

        Map<Integer, Set<Integer>> indegree = new HashMap<>();
        Map<Integer, Set<Integer>> outdegree = new HashMap<>();

        for (int[] trustRow : trust) {
            outdegree.computeIfAbsent(trustRow[0], k -> new HashSet<>());
            outdegree.get(trustRow[0]).add(trustRow[1]);

            indegree.computeIfAbsent(trustRow[1], k -> new HashSet<>());
            indegree.get(trustRow[1]).add(trustRow[0]);
        }

        Optional<Integer> maxIndegreeNode = indegree.keySet()
                .stream()
                .max(Comparator.comparingInt(k -> indegree.get(k).size()));

        if (indegree.get(maxIndegreeNode.get()).size() != n - 1)
            return -1;

        return outdegree.containsKey(maxIndegreeNode.get()) ? -1 : maxIndegreeNode.get();
    }
}
