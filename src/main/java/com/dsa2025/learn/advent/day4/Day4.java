package com.dsa2025.learn.advent.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4 {

    private static final int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
    };

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day4.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] inputs = lines.toArray(new String[0]);

       // int count = getCount(inputs);


        int removalCount = getCountPart2(inputs);

       // System.out.println(count);

        System.out.println(removalCount);
    }


    private static int getCountPart2(String[] input) {
        int rows = input.length;
        int cols = input[0].length();
        int totalCount = 0;
        String[] grid = input.clone();

        boolean removedAny;
        do {
            removedAny = false;
            List<int[]> toRemove = new ArrayList<>();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i].charAt(j) == '@') {
                        int countAdj = countAdj(grid, i, j, rows, cols);
                        if (countAdj < 4) {
                            toRemove.add(new int[]{i, j});
                        }
                    }
                }
            }

            for (int[] pos : toRemove) {
                int r = pos[0], c = pos[1];
                grid[r] = grid[r].substring(0, c) + '@' + grid[r].substring(c + 1);
                StringBuilder sb = new StringBuilder(grid[r]);
                sb.setCharAt(c, '.');
                grid[r] = sb.toString();
                totalCount++;
                removedAny = true;
            }
        } while (removedAny);

        return totalCount;
    }

    private static int countAdj(String[] grid, int row, int col, int rows, int cols) {
        int count = 0;

        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                    grid[newRow].charAt(newCol) == '@') {
                count++;
            }
        }
        return count;
    }

    /**
    private static int getCount(String[] input) {

        int rows = input.length;
        int cols = input[0].length();
        int count = 0;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (input[i].charAt(j) == '@') {
                    int countAdj = countAdj(input, i, j, rows, cols);
                    if (countAdj < 4) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static int countAdj(String[] grid, int row, int col, int rows, int cols) {

        int count = 0;

        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            // so here we are andeling corner cases
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow].charAt(newCol) == '@') {
                count++;
            }
        }
        return count;
    }
     **/
}
