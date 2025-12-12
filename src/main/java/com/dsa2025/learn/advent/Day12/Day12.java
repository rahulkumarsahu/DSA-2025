package com.dsa2025.learn.advent.Day12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day12 {
    //Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day_12.txt

    // Represents a single shape variant (normalized coordinates)
    static class ShapeVariant {
        int height, width;
        List<int[]> cells; // r, c offsets relative to top-left (0,0)

        public ShapeVariant(List<String> lines) {
            cells = new ArrayList<>();
            int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;
            int maxR = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;

            // First pass to find bounds
            for (int r = 0; r < lines.size(); r++) {
                for (int c = 0; c < lines.get(r).length(); c++) {
                    if (lines.get(r).charAt(c) == '#') {
                        minR = Math.min(minR, r);
                        minC = Math.min(minC, c);
                        maxR = Math.max(maxR, r);
                        maxC = Math.max(maxC, c);
                    }
                }
            }

            // Normalize coordinates to (0,0)
            this.height = maxR - minR + 1;
            this.width = maxC - minC + 1;

            for (int r = 0; r < lines.size(); r++) {
                for (int c = 0; c < lines.get(r).length(); c++) {
                    if (lines.get(r).charAt(c) == '#') {
                        cells.add(new int[]{r - minR, c - minC});
                    }
                }
            }
        }

        private ShapeVariant(int h, int w, List<int[]> c) {
            this.height = h;
            this.width = w;
            this.cells = c;
        }

        public int area() { return cells.size(); }

        // Generate all unique orientations (rotations + flips)
        public static List<ShapeVariant> generatePermutations(List<String> rawShape) {
            Set<String> seen = new HashSet<>();
            List<ShapeVariant> variants = new ArrayList<>();

            ShapeVariant base = new ShapeVariant(rawShape);
            addIfUnique(base, variants, seen);

            // Rotate 3 times
            ShapeVariant current = base;
            for (int i = 0; i < 3; i++) {
                current = current.rotate();
                addIfUnique(current, variants, seen);
            }

            // Flip base and rotate 3 times
            current = base.flip();
            addIfUnique(current, variants, seen);
            for (int i = 0; i < 3; i++) {
                current = current.rotate();
                addIfUnique(current, variants, seen);
            }
            return variants;
        }

        private static void addIfUnique(ShapeVariant sv, List<ShapeVariant> list, Set<String> seen) {
            // Sort cells to create a canonical string key for deduplication
            List<int[]> sorted = new ArrayList<>(sv.cells);
            sorted.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

            StringBuilder sb = new StringBuilder();
            sb.append(sv.height).append("x").append(sv.width).append(":");
            for (int[] p : sorted) sb.append(p[0]).append(",").append(p[1]).append(";");

            if (seen.add(sb.toString())) {
                list.add(sv);
            }
        }

        private ShapeVariant rotate() {
            List<int[]> newCells = new ArrayList<>();
            // Rotate 90 deg clockwise: (r, c) -> (c, H - 1 - r)
            for (int[] p : cells) {
                newCells.add(new int[]{p[1], this.height - 1 - p[0]});
            }
            return normalize(newCells);
        }

        private ShapeVariant flip() {
            List<int[]> newCells = new ArrayList<>();
            // Flip horizontal: (r, c) -> (r, W - 1 - c)
            for (int[] p : cells) {
                newCells.add(new int[]{p[0], this.width - 1 - p[1]});
            }
            return normalize(newCells);
        }

        private ShapeVariant normalize(List<int[]> rawCells) {
            int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;
            int maxR = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;
            for (int[] p : rawCells) {
                minR = Math.min(minR, p[0]);
                minC = Math.min(minC, p[1]);
                maxR = Math.max(maxR, p[0]);
                maxC = Math.max(maxC, p[1]);
            }
            List<int[]> norm = new ArrayList<>();
            for (int[] p : rawCells) {
                norm.add(new int[]{p[0] - minR, p[1] - minC});
            }
            return new ShapeVariant(maxR - minR + 1, maxC - minC + 1, norm);
        }
    }

    public static void main(String[] args) {
        String filename = args.length > 0 ? args[0] : "//Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day_12.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("Processing file: " + filename);
            long startTime = System.currentTimeMillis();

            solvePuzzle(reader);

            long duration = System.currentTimeMillis() - startTime;
            System.out.println("Execution time: " + duration + "ms");

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + filename);
            System.err.println("Please ensure 'input.txt' is in the current directory or provide a path as an argument.");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void solvePuzzle(BufferedReader reader) throws Exception {
        String line;

        Map<Integer, List<ShapeVariant>> shapeDefinitions = new HashMap<>();
        List<String> currentShapeLines = new ArrayList<>();
        int currentShapeId = -1;

        List<String> regionTasks = new ArrayList<>();

        // 1. Parsing Line-by-Line
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            if (line.matches("\\d+:")) {
                // If we were parsing a shape, finish it
                if (currentShapeId != -1) {
                    shapeDefinitions.put(currentShapeId, ShapeVariant.generatePermutations(currentShapeLines));
                }
                // Start new shape
                currentShapeId = Integer.parseInt(line.replace(":", ""));
                currentShapeLines = new ArrayList<>();
            } else if (line.contains("x") && line.contains(":")) {
                // This is a region task line.
                // If we were parsing a shape just before this, finish it.
                if (currentShapeId != -1 && !currentShapeLines.isEmpty()) {
                    shapeDefinitions.put(currentShapeId, ShapeVariant.generatePermutations(currentShapeLines));
                    currentShapeId = -1;
                    currentShapeLines.clear();
                }
                regionTasks.add(line);
            } else {
                // Must be part of the current shape grid
                currentShapeLines.add(line);
            }
        }
        // Flush final shape if file ended abruptly
        if (currentShapeId != -1 && !currentShapeLines.isEmpty()) {
            shapeDefinitions.put(currentShapeId, ShapeVariant.generatePermutations(currentShapeLines));
        }

        System.out.println("Loaded " + shapeDefinitions.size() + " unique present shapes.");
        System.out.println("Found " + regionTasks.size() + " regions to check.\n");

        // 2. Processing Regions
        int solvedCount = 0;

        for (String task : regionTasks) {
            String[] parts = task.split(": ");
            String[] dims = parts[0].split("x");
            int W = Integer.parseInt(dims[0]);
            int H = Integer.parseInt(dims[1]);

            String[] counts = parts[1].trim().split("\\s+");
            List<Integer> presentsToFit = new ArrayList<>();

            // Reconstruct the full list of presents for this region
            for (int i = 0; i < counts.length; i++) {
                int count = Integer.parseInt(counts[i]);
                for (int k = 0; k < count; k++) presentsToFit.add(i);
            }

            // Optimization: Sort presents by Area (Largest first)
            // This allows the backtracking to fail faster if big pieces don't fit
            presentsToFit.sort((a, b) -> {
                int areaA = shapeDefinitions.get(a).get(0).area();
                int areaB = shapeDefinitions.get(b).get(0).area();
                return areaB - areaA;
            });

            // Pre-check Total Area
            int totalArea = 0;
            for(int id : presentsToFit) totalArea += shapeDefinitions.get(id).get(0).area();

            boolean possible = false;
            // Optimization: If total area of presents > grid area, don't even try
            if (totalArea <= W * H) {
                possible = backtrack(new boolean[H][W], presentsToFit, 0, shapeDefinitions);
            }

            // Optional: Print progress
            // System.out.println("Region " + parts[0] + " with presents " + parts[1] + " -> " + (possible ? "Fits!" : "No"));
            if (possible) solvedCount++;
        }

        System.out.println("Total regions that fit: " + solvedCount);
    }

    // 3. Recursive Backtracking Solver
    private static boolean backtrack(boolean[][] grid, List<Integer> presents, int idx, Map<Integer, List<ShapeVariant>> definitions) {
        if (idx == presents.size()) {
            return true; // All presents placed successfully
        }

        int presentId = presents.get(idx);
        List<ShapeVariant> variants = definitions.get(presentId);
        int H = grid.length;
        int W = grid[0].length;

        // Iterate through grid
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                // Optimization: If this cell is occupied, we cannot anchor a new piece here.
                // (Since all ShapeVariants are normalized to have (0,0) as a '#', the anchor must be empty)
                if (grid[r][c]) continue;

                for (ShapeVariant var : variants) {
                    if (canPlace(grid, r, c, var)) {
                        place(grid, r, c, var, true);

                        if (backtrack(grid, presents, idx + 1, definitions)) {
                            return true;
                        }

                        place(grid, r, c, var, false); // Backtrack
                    }
                }
            }
        }

        return false;
    }

    private static boolean canPlace(boolean[][] grid, int r, int c, ShapeVariant var) {
        int H = grid.length;
        int W = grid[0].length;

        // Bounds check relative to shape dimensions
        if (r + var.height > H || c + var.width > W) return false;

        // Collision check
        for (int[] offset : var.cells) {
            // Because we already checked outer bounds (height/width), we just need to check if grid is occupied
            if (grid[r + offset[0]][c + offset[1]]) return false;
        }
        return true;
    }

    private static void place(boolean[][] grid, int r, int c, ShapeVariant var, boolean state) {
        for (int[] offset : var.cells) {
            grid[r + offset[0]][c + offset[1]] = state;
        }
    }

}
