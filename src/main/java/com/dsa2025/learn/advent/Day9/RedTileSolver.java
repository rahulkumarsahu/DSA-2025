package com.dsa2025.learn.advent.Day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RedTileSolver {

    // Simple Point class to store coordinates
    static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        String filename = "/Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day_9.txt";

        try {
            List<Point> polygon = readInput(filename);

            if (polygon.size() < 4) {
                System.out.println("Error: Polygon must have at least 4 vertices.");
                return;
            }

            long result = solvePartTwo(polygon);
            System.out.println("Largest Area (Part 2): " + result);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Main logic for Part 2
    private static long solvePartTwo(List<Point> poly) {
        long maxArea = 0;
        int n = poly.size();

        // Iterate through every unique pair of vertices (red tiles)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Point p1 = poly.get(i);
                Point p2 = poly.get(j);

                // Calculate area inclusive of boundary tiles
                // Area = (width + 1) * (height + 1) is not quite right for standard geometry
                // but standard for grid puzzles like this (e.g. AoC).
                // However, standard area is usually just width * height.
                // Re-reading prompt: "between 2,5 and 9,7" (width 8, height 3) -> area 24.
                // |9-2| + 1 = 8. |7-5| + 1 = 3. 8*3=24.
                // So yes, the formula is (|x1-x2| + 1) * (|y1-y2| + 1).
                long width = Math.abs(p1.x - p2.x) + 1;
                long height = Math.abs(p1.y - p2.y) + 1;
                long area = width * height;

                // Optimization: Only run expensive checks if this rectangle is potentially the new max
                if (area > maxArea) {
                    if (isRectValid(p1, p2, poly)) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    // Validates if a rectangle formed by p1 and p2 is strictly inside/on-boundary of the polygon
    private static boolean isRectValid(Point r1, Point r2, List<Point> poly) {
        long minX = Math.min(r1.x, r2.x);
        long maxX = Math.max(r1.x, r2.x);
        long minY = Math.min(r1.y, r2.y);
        long maxY = Math.max(r1.y, r2.y);

        // r1 and r2 are existing vertices, so they are valid.
        // We must check the other two constructed corners.
        Point c3 = new Point(maxX, minY);
        Point c4 = new Point(minX, maxY);

        // 1. Check if corners are valid (inside or on boundary)
        if (isInsideOrBoundary(c3, poly)) return false;
        if (isInsideOrBoundary(c4, poly)) return false;

        // 2. Check if any polygon edge cuts through the INTERIOR of the rectangle.
        // If an edge passes through, it means part of the rectangle lies outside.
        for (int i = 0; i < poly.size(); i++) {
            Point pA = poly.get(i);
            Point pB = poly.get((i + 1) % poly.size());

            // Since the problem states adjacent tiles are on same row/col, edges are rectilinear.

            // Vertical Edge Check
            if (pA.x == pB.x) {
                // Does the edge X fall strictly inside the rectangle X range?
                if (pA.x > minX && pA.x < maxX) {
                    // Check for Y overlap
                    long edgeMinY = Math.min(pA.y, pB.y);
                    long edgeMaxY = Math.max(pA.y, pB.y);

                    long overlapMin = Math.max(edgeMinY, minY);
                    long overlapMax = Math.min(edgeMaxY, maxY);

                    if (overlapMin < overlapMax) return false;
                }
            }
            // Horizontal Edge Check
            else if (pA.y == pB.y) {
                // Does the edge Y fall strictly inside the rectangle Y range?
                if (pA.y > minY && pA.y < maxY) {
                    // Check for X overlap
                    long edgeMinX = Math.min(pA.x, pB.x);
                    long edgeMaxX = Math.max(pA.x, pB.x);

                    long overlapMin = Math.max(edgeMinX, minX);
                    long overlapMax = Math.min(edgeMaxX, maxX);

                    if (overlapMin < overlapMax) return false;
                }
            }
        }

        return true;
    }

    // Standard Ray Casting algorithm for Point-in-Polygon
    private static boolean isInsideOrBoundary(Point p, List<Point> poly) {
        // First check if point lies exactly on any edge
        for (int i = 0; i < poly.size(); i++) {
            Point p1 = poly.get(i);
            Point p2 = poly.get((i + 1) % poly.size());
            if (isOnSegment(p, p1, p2)) return false;
        }

        // Ray casting
        boolean inside = false;
        int j = poly.size() - 1;
        for (int i = 0; i < poly.size(); i++) {
            Point pi = poly.get(i);
            Point pj = poly.get(j);

            // Check if horizontal ray from P crosses the edge (pi, pj)
            // ((pi.y > p.y) != (pj.y > p.y)) checks if one point is above and one below
            if ((pi.y > p.y) != (pj.y > p.y)) {
                // Calculate intersection X coordinate
                double intersectX = (double)(pj.x - pi.x) * (p.y - pi.y) / (pj.y - pi.y) + pi.x;
                if (p.x < intersectX) {
                    inside = !inside;
                }
            }
            j = i;
        }
        return !inside;
    }

    // Helper to check if point P is on segment AB
    private static boolean isOnSegment(Point p, Point a, Point b) {
        // Check collinearity and bounds
        // For rectilinear inputs, simple coordinate checks suffice
        boolean withinX = p.x >= Math.min(a.x, b.x) && p.x <= Math.max(a.x, b.x);
        boolean withinY = p.y >= Math.min(a.y, b.y) && p.y <= Math.max(a.y, b.y);

        if (a.x == b.x) { // Vertical segment
            return p.x == a.x && withinY;
        } else if (a.y == b.y) { // Horizontal segment
            return p.y == a.y && withinX;
        } else {
            // General case (though input is likely rectilinear)
            // Cross product could be used here, but let's stick to simple bound checks
            // assuming the point is strictly on the line defined by A-B.
            // Since we only need this for the boundary check of exact coordinates:
            return false; // Should not happen for rectilinear edges unless diagonals exist
        }
    }

    // Reads X,Y coordinates from file
    private static List<Point> readInput(String filename) throws IOException {
        List<Point> points = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    long x = Long.parseLong(parts[0].trim());
                    long y = Long.parseLong(parts[1].trim());
                    points.add(new Point(x, y));
                }
            }
        }
        return points;
    }
}
