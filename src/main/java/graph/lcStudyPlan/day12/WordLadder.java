package graph.lcStudyPlan.day12;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/word-ladder/
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> allowedWords = new HashSet<>(wordList);

        if (!allowedWords.contains(endWord))
            return 0;

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int minSqeuenceLength = 1;
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();

            for (int i = 0; i < currentLevel; i++) {
                String currentWord = queue.poll();

                if (endWord.equals(currentWord))
                    return minSqeuenceLength;

                char[] chars = currentWord.toCharArray();
                for (int index = 0; index < chars.length; index++) {
                    char currentChar = chars[index];

                    for (int ascii = 97; ascii <= 122; ascii++) {
                        chars[index] = (char) ascii;

                        String charsString = new String(chars);

                        if (!visited.contains(charsString) && allowedWords.contains(charsString)) {
                            visited.add(charsString);
                            queue.offer(charsString);
                        }
                    }
                    chars[index] = currentChar;
                }
            }
            minSqeuenceLength++;
        }
        return 0;
    }
}
