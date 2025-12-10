package com.dsa2025.learn.advent.Day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Part 2:
 *  * Find the largest axis-aligned rectangle such that:
 *  *  - Two opposite corners are red tiles (from the input list).
 *  *  - Every tile inside the rectangle (including its boundary) is either red or green.
 *  *
 *  * Input: lines "x,y" with coordinates of red tiles in order.
 *  * Adjacent tiles in the list are connected by straight horizontal/vertical green segments,
 *  * and the list forms a closed loop. The inside of this loop is also green.
 */
public class Day9Part2 {

    static class Point {
        int x, y;
        public Point(int x, int y) { this.x = x; this.y = y; }
    }

    public static void main(String[] args) {
        List<Point> redTiles = new ArrayList<>();
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        try {
            Scanner scanner = new Scanner(new File("/Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day_9.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0].trim());
                int y = Integer.parseInt(parts[1].trim());
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
                redTiles.add(new Point(x, y));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }


    }
}
