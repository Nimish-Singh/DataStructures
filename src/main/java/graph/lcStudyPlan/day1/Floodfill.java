package graph.lcStudyPlan.day1;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/flood-fill/
public class Floodfill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Pair<Integer, Integer>> toFill = new LinkedList<>();
        int totalRows = image.length;
        int totalColumns = image[0].length;
        int colourToReplace = image[sr][sc];
        boolean[][] alreadyColoured = new boolean[totalRows][totalColumns];
        toFill.offer(new Pair<>(sr, sc));

        while (!toFill.isEmpty()) {
            Pair<Integer, Integer> currentCell = toFill.poll();
            Integer row = currentCell.getKey();
            Integer column = currentCell.getValue();
            alreadyColoured[row][column] = true;

            if (row - 1 >= 0 && !alreadyColoured[row - 1][column] && image[row - 1][column] == colourToReplace) {
                alreadyColoured[row - 1][column] = true;
                toFill.offer(new Pair<>(row - 1, column));
            }

            if (row + 1 < totalRows && !alreadyColoured[row + 1][column] && image[row + 1][column] == colourToReplace) {
                alreadyColoured[row + 1][column] = true;
                toFill.offer(new Pair<>(row + 1, column));
            }

            if (column - 1 >= 0 && !alreadyColoured[row][column - 1] && image[row][column - 1] == colourToReplace) {
                alreadyColoured[row][column - 1] = true;
                toFill.offer(new Pair<>(row, column - 1));
            }

            if (column + 1 < totalColumns && !alreadyColoured[row][column + 1] && image[row][column + 1] == colourToReplace) {
                alreadyColoured[row][column + 1] = true;
                toFill.offer(new Pair<>(row, column + 1));
            }
        }

        for (int row = 0; row < totalRows; row++)
            for (int column = 0; column < totalColumns; column++)
                if (alreadyColoured[row][column])
                    image[row][column] = newColor;

        return image;
    }
}

/*
Can also change this solution to proper DFS as:

call dfs(image, sr, sc, color, newColor); with:

public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }

This will eliminate the need for queue or boolean array
 */