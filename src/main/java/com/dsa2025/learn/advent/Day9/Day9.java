package com.dsa2025.learn.advent.Day9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day9 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        List<Point> redTiles = new ArrayList<>();

        try {
            File myFile = new File("/Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day_9.txt");
            Scanner fileReader = new Scanner(myFile);

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0].trim());
                int y = Integer.parseInt(parts[1].trim());
                redTiles.add(new Point(x, y));
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
        }

        long maxArea = 0;

        for (int i = 0; i < redTiles.size(); i++) {
            Point p1 = redTiles.get(i);

            for (Point p2 : redTiles) {
                long width = Math.abs(p1.x - p2.x) + 1;
                long height = Math.abs(p1.y - p2.y) + 1;

                long currentArea = width * height;

                if (currentArea > maxArea) {
                    maxArea = currentArea;
                }
            }
        }

        System.out.println(maxArea);

    }
}
