package com.dsa2025.learn.advent.Day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        // 1. Determine Input File
        String filename = "/Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day_10.txt"; // Default filename
        if (args.length > 0) {
            filename = args[0];
        }

        File file = new File(filename);
        if (!file.exists()) {
            System.err.println("Error: File '" + filename + "' not found.");
            System.err.println("Please create 'input.txt' or provide a filename as an argument.");
            return;
        }

        System.out.println("Reading input from: " + filename);
        List<Machine> machines = new ArrayList<>();

        // 2. Parse Input File
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    machines.add(parseMachine(line));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        if (machines.isEmpty()) {
            System.out.println("No machines found in the file.");
            return;
        }

        // 3. Solve for each machine
        long totalPresses = 0;
        int machineCount = 1;

        for (Machine m : machines) {
            long presses = solveILP(m);
            if (presses == Long.MAX_VALUE) {
                System.out.println("Machine " + machineCount + ": No valid configuration found.");
            } else {
                System.out.println("Machine " + machineCount + ": Minimum presses = " + presses);
                totalPresses += presses;
            }
            machineCount++;
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Total minimal button presses required: " + totalPresses);
    }

    // --- ILP Solver (Branch and Bound) ---

    /**
     * Finds the minimum sum of vector x such that Ax = b, x >= 0, x is integer.
     */
    private static long solveILP(Machine m) {
        // Global minimum for this machine (initialized to infinity)
        long[] minTotal = {Long.MAX_VALUE};

        // Start recursive search
        // buttonIndex: 0, currentPresses: 0, currentResiduals: targets
        search(m, 0, 0, m.targets, minTotal);

        return minTotal[0];
    }

    private static void search(Machine m, int btnIdx, long currentPresses, int[] residuals, long[] minTotal) {
        // Pruning: If current cost already exceeds the best found, stop.
        if (currentPresses >= minTotal[0]) {
            return;
        }

        // Base Case: Processed all buttons
        if (btnIdx == m.buttons.size()) {
            // Check if all residuals are exactly 0 (valid solution)
            boolean allZero = true;
            for (int r : residuals) {
                if (r != 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                minTotal[0] = Math.min(minTotal[0], currentPresses);
            }
            return;
        }

        // Recursive Step: Try pressing the current button k times.
        List<Integer> buttonEffects = m.buttons.get(btnIdx);
        int maxK = Integer.MAX_VALUE;

        // Determine upper bound for k based on residuals
        // If a button increments a counter, we can't press it more times than the residual amount allows.
        boolean affectsAny = false;
        for (int affectedIndex : buttonEffects) {
            affectsAny = true;
            if (residuals[affectedIndex] < 0) {
                maxK = -1; // Already invalid state
                break;
            }
            // The button adds 1 to the counter at 'affectedIndex'
            // So we can press it at most 'residuals[affectedIndex]' times
            maxK = Math.min(maxK, residuals[affectedIndex]);
        }

        if (!affectsAny) maxK = 0; // Prevent infinite loop if button does nothing
        if (maxK < 0) return; // Invalid path

        // Branching: Try all feasible integer values for k (0 to maxK)
        // We iterate downwards (maxK to 0) to try greedy solutions first,
        // which helps find a "good enough" minTotal early for better pruning.
        for (int k = maxK; k >= 0; k--) {
            int[] nextResiduals = residuals.clone();
            boolean possible = true;

            for (int affectedIndex : buttonEffects) {
                nextResiduals[affectedIndex] -= k;
                // Double check negative residuals (should cover by maxK, but safety first)
                if (nextResiduals[affectedIndex] < 0) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                search(m, btnIdx + 1, currentPresses + k, nextResiduals, minTotal);
            }
        }
    }

    // --- Parsing Logic ---

    private static Machine parseMachine(String line) {
        // Example Input: [.##.] (3) (1,3) ... {3,5,4,7}

        // 1. Extract Targets (Joltage Requirements) inside {}
        Pattern pTargets = Pattern.compile("\\{([\\d,]+)\\}");
        Matcher mTargets = pTargets.matcher(line);
        int[] targets = new int[0];
        if (mTargets.find()) {
            String[] parts = mTargets.group(1).split(",");
            targets = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                targets[i] = Integer.parseInt(parts[i]);
            }
        }

        // 2. Extract Buttons inside ()
        // We find all occurrences of (x,y,z)
        Pattern pButtons = Pattern.compile("\\(([\\d,]+)\\)");
        Matcher mButtons = pButtons.matcher(line);
        List<List<Integer>> buttons = new ArrayList<>();

        while (mButtons.find()) {
            String content = mButtons.group(1);
            String[] parts = content.split(",");
            List<Integer> effects = new ArrayList<>();
            for (String part : parts) {
                if (!part.isEmpty()) {
                    effects.add(Integer.parseInt(part));
                }
            }
            buttons.add(effects);
        }

        return new Machine(buttons, targets);
    }

    // Helper class to store machine data
    static class Machine {
        List<List<Integer>> buttons; // List of buttons, each is a list of affected indices
        int[] targets;               // Target values for each counter

        public Machine(List<List<Integer>> buttons, int[] targets) {
            this.buttons = buttons;
            this.targets = targets;
        }
    }
}
