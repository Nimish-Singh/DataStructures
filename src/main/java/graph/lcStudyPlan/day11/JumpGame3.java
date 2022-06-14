package graph.lcStudyPlan.day11;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/jump-game-iii/
public class JumpGame3 {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int currentLevel = queue.size();

            for (int index = 0; index < currentLevel; index++) {
                int currentIndex = queue.poll();

                if (arr[currentIndex] == 0)
                    return true;

                int leftIndex = currentIndex - arr[currentIndex];
                int rightIndex = currentIndex + arr[currentIndex];

                if (leftIndex >= 0 && !visited[leftIndex]) {
                    visited[leftIndex] = true;
                    queue.offer(leftIndex);
                }

                if (rightIndex < arr.length && !visited[rightIndex]) {
                    visited[rightIndex] = true;
                    queue.offer(rightIndex);
                }
            }
        }
        return false;
    }
}
