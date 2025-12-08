package com.dsa2025.learn.advent.Day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day8 {

    static class Point {
        int x, y, z;
        int groupID;

        Point(int x, int y, int z, int id) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.groupID = id; // each starts in its own group
        }
    }

    static class Connection implements Comparable<Connection> {
        Point p1;
        Point p2;
        double distance;

        Connection(Point a, Point b) {
            this.p1 = a;
            this.p2 = b;
            long dx = (long)a.x - b.x;
            long dy = (long)a.y - b.y;
            long dz = (long)a.z - b.z;
            this.distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
        }

        @Override
        public int compareTo(Connection other) {
            return Double.compare(this.distance, other.distance);
        }
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();

        // 1. Read input
        try {
            File file = new File("/Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day_8.txt");
            Scanner scanner = new Scanner(file);
            int id = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0].trim());
                int y = Integer.parseInt(parts[1].trim());
                int z = Integer.parseInt(parts[2].trim());
                points.add(new Point(x, y, z, id));
                id++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("input.txt not found");
            return;
        }

        int n = points.size();
        if (n == 0) {
            System.out.println("No points");
            return;
        }

        List<Connection> all = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                all.add(new Connection(points.get(i), points.get(j)));
            }
        }

        Collections.sort(all);


        int groups = n;
        Point lastA = null;
        Point lastB = null;

        for (Connection c : all) {
            if (groups == 1) break;

            int id1 = c.p1.groupID;
            int id2 = c.p2.groupID;

            if (id1 == id2) {
                continue;
            }

            lastA = c.p1;
            lastB = c.p2;

            for (Point p : points) {
                if (p.groupID == id2) {
                    p.groupID = id1;
                }
            }

            groups--;
        }
        assert lastA != null;
        long product = (long) lastA.x * (long) lastB.x;
        System.out.println("Product: " + product);
    }
}
