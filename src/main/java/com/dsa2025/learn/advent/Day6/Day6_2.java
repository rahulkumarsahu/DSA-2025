package com.dsa2025.learn.advent.Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day6_2 {

    //Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day_5.txt

    public static void main(String[] args) throws IOException {
        // 1. Read all lines from the worksheet file
        List<String> lines = Files.readAllLines(Paths.get("//Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day_5.txt"));

        int rowCount = lines.size();
        int opRowIndex = rowCount - 1;      // last line = operations
        int digitRowCount = rowCount - 1;   // all rows above = digits

        System.out.println(rowCount);
        System.out.println(opRowIndex);
        System.out.println(digitRowCount);

        // 2. Find maximum width (number of columns)
        int colCount = 0;
        for (String line : lines) {
            colCount = Math.max(colCount, line.length());
        }

        // 3. Copy input into a rectangular char grid, padding with spaces
        char[][] grid = new char[rowCount][colCount];
        for (int r = 0; r < rowCount; r++) {
            String line = lines.get(r);
            for (int c = 0; c < colCount; c++) {
                grid[r][c] = (c < line.length()) ? line.charAt(c) : ' ';
            }
        }

        System.out.println("=== GRID ===");
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                char ch = grid[r][c];
                // show spaces as '.' so you can see blanks clearly
                System.out.print(ch == ' ' ? '.' : ch);
            }
            System.out.println();
        }
        System.out.println("============");

        long grandTotal = 0L;
        int blockStartCol = 0;   // left boundary of current problem block

        // 4. Scan columns; a fully blank column separates problems
        for (int c = 0; c <= colCount; c++) {
            boolean isSeparator = isBlankColumn(grid, rowCount, c);

            if (isSeparator) {
                if (blockStartCol < c) {
                    // We have a problem spanning columns [blockStartCol, c)
                    char op = grid[opRowIndex][blockStartCol]; // operator at bottom left of block
                    if (op == '+' || op == '*') {
                        long value = evaluateBlockRightToLeft(
                                grid, digitRowCount, blockStartCol, c, op
                        );
                        grandTotal += value;
                    }
                }
                // Next block starts after this blank column
                blockStartCol = c + 1;
            }
        }

        System.out.println("Grand total (part 2) = " + grandTotal);
    }

    // Check if column c is completely blank (or beyond right edge)
    private static boolean isBlankColumn(char[][] grid, int rowCount, int c) {
        if (c >= grid[0].length) {
            return true; // treat beyond-right as blank sentinel
        }
        for (int r = 0; r < rowCount; r++) {
            if (grid[r][c] != ' ') {
                return false;
            }
        }
        return true;
    }

    // Evaluate one problem block using cephalopod rules (right-to-left, column-wise)
    private static long evaluateBlockRightToLeft(char[][] grid,
                                                 int digitRowCount,
                                                 int startCol,
                                                 int endCol,
                                                 char op) {

        long result = (op == '+') ? 0L : 1L;

        // 1) Walk columns from rightmost (endCol - 1) down to leftmost (startCol)
        for (int c = endCol - 1; c >= startCol; c--) {
            int number = 0;
            boolean hasDigit = false;

            // 2) Build the number in this column:
            //    read digits from top row (0) down to digitRowCount-1
            for (int r = 0; r < digitRowCount; r++) {
                System.out.println(digitRowCount);
                System.out.println("_______");
                char ch = grid[r][c];
                if (Character.isDigit(ch)) {
                    number = number * 10 + (ch - '0');
                    hasDigit = true;
                }
            }
            System.out.println(number);

            // If this column had no digits, skip it
            if (!hasDigit) {
                continue;
            }

            // 3) Combine into result using the operator for this block
            if (op == '+') {
                result += number;
            } else { // op == '*'
                result *= number;
            }
        }

        return result;
    }
}
