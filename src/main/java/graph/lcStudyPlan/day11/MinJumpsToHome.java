package graph.lcStudyPlan.day11;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/minimum-jumps-to-reach-home/
public class MinJumpsToHome {
    public int minimumJumps(int[] forbidden, int forwardJump, int backwardJump, int home) {
        int furthest = home + forwardJump + backwardJump;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>(); // cant make it Queue<int[]> because them the visited check doesn't work correctly
        queue.offer(new Pair<>(1, 0)); // direction & position. Direction 1 = forward, -1 = backward
        Set<Pair<Integer, Integer>> visitedVector = new HashSet<>(queue);

        for (int position : forbidden) {
            visitedVector.add(new Pair<>(1, position));
            visitedVector.add(new Pair<>(-1, position));
            furthest = Math.max(furthest, position + forwardJump + backwardJump);
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();
            for (int index = 0; index < currentLevel; index++) {
                Pair<Integer, Integer> currentVector = queue.poll();
                int direction = currentVector.getKey(), position = currentVector.getValue();
                if (position == home)
                    return steps;

                Pair<Integer, Integer> forward = new Pair<>(1, position + forwardJump);
                Pair<Integer, Integer> backward = new Pair<>(-1, position - backwardJump);
                if (forward.getValue() <= furthest && !visitedVector.contains(forward)) {
                    visitedVector.add(forward);
                    queue.offer(forward);
                }
                if (direction == 1 && backward.getValue() >= 0 && !visitedVector.contains(backward)) {
                    visitedVector.add(backward);
                    queue.offer(backward);
                }
            }
            ++steps;
        }
        return -1;
    }
}
