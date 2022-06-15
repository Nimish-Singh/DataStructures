package graph.lcStudyPlan.day11;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/water-and-jug-problem/
public class WaterAndJugProblem {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity == targetCapacity)
            return true;
        if (jug1Capacity % 2 == 0 && jug2Capacity % 2 == 0 && targetCapacity % 2 != 0)//cannot measure odd capacity using even capacity jugs
            return false;
        if (jug1Capacity + jug2Capacity < targetCapacity)
            return false;

        Set<String> visited = new HashSet<>();
        visited.add("0,0"); // Jug1, Jug2
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(0, 0)); // Jug1, Jug2

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> currentState = queue.poll();
            if (currentState.getKey() + currentState.getValue() == targetCapacity)
                return true;
            visited.add(currentState.getKey() + "," + currentState.getValue());

            int newJug1State, newJug2State;

            // Transfer jug1 to jug2
            newJug1State = currentState.getKey() - Math.min(currentState.getKey(), jug2Capacity - currentState.getValue());
            newJug2State = currentState.getValue() + Math.min(currentState.getKey(), jug2Capacity - currentState.getValue());
            if (!visited.contains(newJug1State + "," + newJug2State))
                queue.offer(new Pair<>(newJug1State, newJug2State));

            // Transfer jug2 to jug1
            newJug1State = currentState.getKey() + Math.min(currentState.getValue(), jug1Capacity - currentState.getKey());
            newJug2State = currentState.getValue() - Math.min(currentState.getValue(), jug1Capacity - currentState.getKey());
            if (!visited.contains(newJug1State + "," + newJug2State))
                queue.offer(new Pair<>(newJug1State, newJug2State));

            // Empty jug1
            newJug1State = 0;
            newJug2State = currentState.getValue();
            if (!visited.contains(newJug1State + "," + newJug2State))
                queue.offer(new Pair<>(newJug1State, newJug2State));

            // Empty jug2
            newJug1State = currentState.getKey();
            newJug2State = 0;
            if (!visited.contains(newJug1State + "," + newJug2State))
                queue.offer(new Pair<>(newJug1State, newJug2State));

            // Fill jug1 full
            newJug1State = jug1Capacity;
            newJug2State = currentState.getValue();
            if (!visited.contains(newJug1State + "," + newJug2State))
                queue.offer(new Pair<>(newJug1State, newJug2State));

            // Fill jug2 full
            newJug1State = currentState.getKey();
            newJug2State = jug2Capacity;
            if (!visited.contains(newJug1State + "," + newJug2State))
                queue.offer(new Pair<>(newJug1State, newJug2State));
        }
        return false;
    }
}
