package graph.lcStudyPlan.day12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/minimum-genetic-mutation/
public class MinGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end))
            return 0;

        Set<String> bankSet = Arrays.stream(bank).collect(Collectors.toSet());
        char[] letters = {'A', 'C', 'G', 'T'};

        if (!bankSet.contains(end))
            return -1;

        Set<String> visited = new HashSet<>();
        visited.add(start);
        Queue<String> mutations = new LinkedList<>();
        mutations.offer(start);

        int steps = 0;
        while (!mutations.isEmpty()) {
            int currentLevel = mutations.size();

            for (int i = 0; i < currentLevel; i++) {
                String currentMutation = mutations.poll();
                if (currentMutation.equals(end))
                    return steps;

                char[] mutChars = currentMutation.toCharArray();
                for (int index = 0; index < currentMutation.length(); index++) {
                    char currentChar = mutChars[index];

                    for (char letter : letters) {
                        if (letter == mutChars[index])
                            continue;

                        mutChars[index] = letter;
                        String tempMut = new String(mutChars);

                        if (bankSet.contains(tempMut) && !visited.contains(tempMut)) {
                            mutations.offer(tempMut);
                            visited.add(tempMut);
                        }
                    }
                    mutChars[index] = currentChar;
                }
            }
            steps++;
        }
        return -1;
    }
}
