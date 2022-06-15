package graph.lcStudyPlan.day12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Character.forDigit;
import static java.lang.Character.getNumericValue;

// https://leetcode.com/problems/open-the-lock/
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadEndSet = Arrays.stream(deadends).collect(Collectors.toSet());
        String startCombo = "0000";

        if (deadEndSet.contains(startCombo))
            return -1;

        Set<String> visited = new HashSet<>();
        visited.add(startCombo);

        Queue<String> combos = new LinkedList<>();
        combos.offer(startCombo);

        int turns = 0;

        while (!combos.isEmpty()) {
            int currentLevel = combos.size();

            for (int i = 0; i < currentLevel; i++) {
                String currentCombo = combos.poll();

                if (target.equals(currentCombo))
                    return turns;

                char[] chars = currentCombo.toCharArray();
                for (int index = 0; index < chars.length; index++) {
                    char currentChar = chars[index];
                    int currentNum = getNumericValue(currentChar);

                    char nextTurn = forDigit((currentNum + 1) % 10, 10);
                    char previousTurn = forDigit(currentNum == 0 ? 9 : (currentNum - 1) % 10, 10);

                    chars[index] = nextTurn;
                    String nextTurnString = new String(chars);
                    if (!deadEndSet.contains(nextTurnString) && !visited.contains(nextTurnString)) {
                        visited.add(nextTurnString);
                        combos.offer(nextTurnString);
                    }

                    chars[index] = previousTurn;
                    String preTurnString = new String(chars);
                    if (!deadEndSet.contains(preTurnString) && !visited.contains(preTurnString)) {
                        visited.add(preTurnString);
                        combos.offer(preTurnString);
                    }
                    chars[index] = currentChar;
                }
            }
            turns++;
        }
        return -1;
    }
}
