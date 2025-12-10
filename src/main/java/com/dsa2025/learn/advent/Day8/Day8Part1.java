package com.dsa2025.learn.advent.Day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day8Part1 {

    static class Point {
        int x, y, z;
        int groupID;

        public Point(int x, int y, int z, int id) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.groupID = id;
        }
    }

    static class Connection implements Comparable<Connection> {
        Point p1;
        Point p2;
        double distance;

        public Connection(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;

            this.distance = Math.sqrt(Math.pow(p1.x - p2.x, 2) +
                    Math.pow(p1.y - p2.y, 2) +
                    Math.pow(p1.z - p2.z, 2));
        }

        @Override
        public int compareTo(Connection other) {
            return Double.compare(this.distance, other.distance);
        }
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();

        try {
            File file = new File("/Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day_8.txt"); // Make sure your input file is named this
            Scanner scanner = new Scanner(file);

            int idCounter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0].trim());
                int y = Integer.parseInt(parts[1].trim());
                int z = Integer.parseInt(parts[2].trim());

                points.add(new Point(x, y, z, idCounter));
                idCounter++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: input.txt file not found.");
            return;
        }

        List<Connection> allConnections = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                // Create a connection for every possible pair
                allConnections.add(new Connection(points.get(i), points.get(j)));
            }
        }


        Collections.sort(allConnections);

        int maxConnections = 1000;

        for (int i = 0; i < Math.min(maxConnections, allConnections.size()); i++) {
            Connection c = allConnections.get(i);

            int id1 = c.p1.groupID;
            int id2 = c.p2.groupID;

            if (id1 == id2) {
                continue;
            }

            for (Point p : points) {
                if (p.groupID == id2) {
                    p.groupID = id1;
                }
            }
        }

        Map<Integer, Integer> circuitSizes = new HashMap<>();

        for (Point p : points) {
            circuitSizes.put(p.groupID, circuitSizes.getOrDefault(p.groupID, 0) + 1);
        }

        List<Integer> sizes = new ArrayList<>(circuitSizes.values());
        sizes.sort(Collections.reverseOrder()); // Sort largest to smallest

        long result = 1;
        System.out.println("Top circuit sizes:");
        for (int i = 0; i < Math.min(3, sizes.size()); i++) {
            int size = sizes.get(i);
            System.out.println("- " + size);
            result *= size;
        }

        System.out.println("\nFinal Answer (Product of top 3): " + result);
    }


}
