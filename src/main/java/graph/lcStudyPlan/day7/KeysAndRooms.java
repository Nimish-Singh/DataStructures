package graph.lcStudyPlan.day7;

import java.util.List;

// https://leetcode.com/problems/keys-and-rooms/
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        dfs(rooms, 0, visited);

        boolean allVisited = true;

        for (boolean room : visited)
            allVisited = allVisited && room;

        return allVisited;
    }

    private void dfs(List<List<Integer>> rooms, int currentRoom, boolean[] visited) {
        visited[currentRoom] = true;
        for (int key : rooms.get(currentRoom)) {
            if (!visited[key])
                dfs(rooms, key, visited);
        }
    }
}
