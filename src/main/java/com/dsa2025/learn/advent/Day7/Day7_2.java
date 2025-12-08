package com.dsa2025.learn.advent.Day7;

import java.util.Arrays;

public class Day7_2 {

    static String[] grid = {
            ".......S.......",
            "...............",
            ".......^.......",
            "...............",
            "......^.^......",
            "...............",
            ".....^.^.^.....",
            "...............",
            "....^.^...^....",
            "...............",
            "...^.^...^.^...",
            "...............",
            "..^...^.....^..",
            "...............",
            ".^.^.^.^.^...^.",
            "..............."
    };

    static int rows, cols;
    static long[][] memo;

    public static void main(String[] args) {
        rows = grid.length;
        cols = grid[0].length();

        int[] start = findStart(grid);
        if (start[0] == -1) {
            System.out.println(0);
            return;
        }

        memo = new long[rows][cols];
        for (int r = 0; r < rows; r++) {
            Arrays.fill(memo[r], -1L);
        }

        long timelines = dfs(start[0] + 1, start[1]);
        System.out.println("Part 2 (Timelines): " + timelines);
    }

    // DFS: number of timelines from position (r, c)
    private static long dfs(int r, int c) {
// Out of bounds = 1 completed timeline
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return 1L;
        }

        if (memo[r][c] != -1L) {
            return memo[r][c];
        }

        char cell = grid[r].charAt(c);
        long result;

        if (cell == '.') {
            result = dfs(r + 1, c); // Continue straight
        } else if (cell == '^') {
            result = dfs(r + 1, c - 1) + // Left timeline
                    dfs(r + 1, c + 1); // Right timeline
        } else {
            result = dfs(r + 1, c); // 'S' or other: continue
        }

        memo[r][c] = result;
        return result;
    }

    private static int[] findStart(String[] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length(); c++) {
                if (grid[r].charAt(c) == 'S') {
                    return new int[]{r, c};
                }
            }
        }
        return new int[]{-1, -1};
    }

}