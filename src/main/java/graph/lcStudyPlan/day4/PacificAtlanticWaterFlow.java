package graph.lcStudyPlan.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/pacific-atlantic-water-flow/
public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> coordinates = new ArrayList<>();

        int totalRows = heights.length;
        int totalColumns = heights[0].length;

        // the logic is to reverse the problem- find a way from each ocean to each cell
        boolean[][] pacific = new boolean[totalRows][totalColumns];
        boolean[][] atlantic = new boolean[totalRows][totalColumns];

        for (int row = 0; row < totalRows; row++) {
            dfs(heights, row, 0, -1, pacific);
            dfs(heights, row, totalColumns - 1, -1, atlantic);
        }

        for (int column = 0; column < totalColumns; column++) {
            dfs(heights, 0, column, -1, pacific);
            dfs(heights, totalRows - 1, column, -1, atlantic);
        }

        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (pacific[row][column] && atlantic[row][column])
                    coordinates.add(Arrays.asList(row, column));
            }
        }

        return coordinates;
    }

    public void dfs(int[][] height, int row, int column, int previous, boolean[][] ocean) {
        if (row < 0 || row >= height.length || column < 0 || column >= height[0].length || ocean[row][column])
            return;

        if (height[row][column] < previous)
            return;

        ocean[row][column] = true;

        dfs(height, row - 1, column, height[row][column], ocean);
        dfs(height, row + 1, column, height[row][column], ocean);
        dfs(height, row, column - 1, height[row][column], ocean);
        dfs(height, row, column + 1, height[row][column], ocean);
    }
}
