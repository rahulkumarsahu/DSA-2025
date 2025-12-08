package com.dsa2025.learn.advent.Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day6 {

    //6957525317641
    //6957525317641
    public static void main(String[] args) throws IOException {
        // 1. Read all lines from the file
        List<String> lines = Files.readAllLines(Paths.get("/Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day_5.txt"));
        if (lines.size() < 5) {
            throw new IllegalStateException("Need at least 5 lines: 4 number rows + 1 op row");
        }

        // 2. Parse the first 4 lines into integers (as 2D array)
        //    Split on whitespace, so alignment/spaces do not matter.
        List<int[]> numberRows = new ArrayList<>();
        int columns = -1;

        for (int r = 0; r < 4; r++) {
            String line = lines.get(r).trim();
            String[] parts = line.split("\\s+");   // split by spaces/tabs
            if (columns == -1) {
                columns = parts.length;
            } else if (parts.length != columns) {
                throw new IllegalStateException("Row " + r + " has different column count");
            }

            int[] rowNums = new int[columns];
            for (int c = 0; c < columns; c++) {
                rowNums[c] = Integer.parseInt(parts[c]);
            }
            numberRows.add(rowNums);
        }

        // Convert List<int[]> to int[4][columns]
        int[][] nums = new int[4][columns];
        for (int r = 0; r < 4; r++) {
            nums[r] = numberRows.get(r);
        }

        // 3. Parse the 5th line: operations between columns, like "+ * + * ..."
        String opLine = lines.get(4).trim();
        String[] opParts = opLine.split("\\s+");
        if (opParts.length != columns) {
            throw new IllegalStateException("Number of ops != number of columns");
        }

        char[] ops = new char[columns];
        for (int c = 0; c < columns; c++) {
            ops[c] = opParts[c].charAt(0);   // '+' or '*'
        }

        // 4. For each column: apply the operator to the 4 numbers in that column
        long total = 0L;

        for (int c = 0; c < columns; c++) {
            char op = ops[c];
            long result = (op == '+') ? 0L : 1L;

            for (int r = 0; r < 4; r++) {
                int value = nums[r][c];
                if (op == '+') {
                    result += value;
                } else if (op == '*') {
                    result *= value;
                } else {
                    throw new IllegalStateException("Unknown operator: " + op);
                }
            }

            total += result;
        }

        // 5. Print final answer
        System.out.println("Grand total = " + total);
    }

}
