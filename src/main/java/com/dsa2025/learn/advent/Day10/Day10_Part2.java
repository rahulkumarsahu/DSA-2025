package com.dsa2025.learn.advent.Day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day10_Part2 {
    ///Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day_10.txt
    public static void main(String[] args) throws Exception {
        String filename = "/Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day_10.txt";

        List<String> machines = readMachinesFromFile(filename);
        int totalPresses = 0;

        for (String machine : machines) {
            int presses = solveMachine(machine);
            System.out.println("Machine: " + presses + " presses");
            totalPresses += presses;
        }

        System.out.println("TOTAL JOLTAGE PRESSES: " + totalPresses);
    }

    static List<String> readMachinesFromFile(String filename) throws IOException {
        List<String> machines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) machines.add(line);
            }
        }
        return machines;
    }

    static int solveMachine(String line) {
        String[] parts = line.split(" ");

        // Parse target
        int[] target = parseJoltages(parts[parts.length - 1]);
        int C = target.length;

        // Parse buttons
        List<int[]> rawButtons = new ArrayList<>();
        for (int i = 1; i < parts.length - 1; i++) {
            if (parts[i].startsWith("(") && parts[i].endsWith(")")) {
                String inside = parts[i].substring(1, parts[i].length() - 1);
                int[] eff = new int[C];
                if (!inside.isEmpty()) {
                    for (String s : inside.split(",")) {
                        int idx = Integer.parseInt(s.trim());
                        if (idx >= 0 && idx < C) {
                            eff[idx] += 1;
                        }
                    }
                }
                // keep only useful buttons
                boolean useful = false;
                for (int v : eff) if (v != 0) { useful = true; break; }
                if (useful) rawButtons.add(eff);
            }
        }

        if (rawButtons.isEmpty()) {
            for (int t : target) if (t != 0) return 0;
            return 0;
        }

        // Order buttons: more "powerful" / more counters first → better pruning
        int B = rawButtons.size();
        int[][] buttons = new int[B][C];
        for (int i = 0; i < B; i++) buttons[i] = rawButtons.get(i);

        Integer[] order = new Integer[B];
        for (int i = 0; i < B; i++) order[i] = i;
        Arrays.sort(order, (i, j) -> {
            int si = 0, sj = 0;
            for (int k = 0; k < C; k++) {
                si += buttons[i][k];
                sj += buttons[j][k];
            }
            return Integer.compare(sj, si); // descending total contribution
        });

        int[][] orderedButtons = new int[B][C];
        for (int i = 0; i < B; i++) {
            orderedButtons[i] = buttons[order[i]];
        }

        // Precompute max presses per button: pressing more than this cannot help
        int[] maxPress = new int[B];
        for (int i = 0; i < B; i++) {
            int m = 0;
            for (int c = 0; c < C; c++) {
                if (orderedButtons[i][c] > 0) {
                    int local = target[c] / orderedButtons[i][c];
                    if (local > m) m = local;
                }
            }
            maxPress[i] = m;
        }

        // Precompute per-counter min step size from remaining buttons for heuristic
        int[][] minStepFrom = new int[B + 1][C]; // from index i to end
        for (int c = 0; c < C; c++) {
            minStepFrom[B][c] = Integer.MAX_VALUE;
        }
        for (int i = B - 1; i >= 0; i--) {
            for (int c = 0; c < C; c++) {
                int here = orderedButtons[i][c] > 0 ? orderedButtons[i][c] : Integer.MAX_VALUE;
                minStepFrom[i][c] = Math.min(here, minStepFrom[i + 1][c]);
            }
        }

        int[] current = new int[C];
        int[] best = {Integer.MAX_VALUE};

        dfs(0, orderedButtons, target, current, 0, maxPress, minStepFrom, best);

        return best[0] == Integer.MAX_VALUE ? 0 : best[0];
    }

    static int[] parseJoltages(String token) {
        String s = token.trim();
        if (s.startsWith("{")) s = s.substring(1);
        if (s.endsWith("}")) s = s.substring(0, s.length() - 1);
        String[] ps = s.split(",");
        int[] res = new int[ps.length];
        for (int i = 0; i < ps.length; i++) {
            res[i] = Integer.parseInt(ps[i].trim());
        }
        return res;
    }

    static void dfs(int idx,
                    int[][] buttons,
                    int[] target,
                    int[] current,
                    int curPress,
                    int[] maxPress,
                    int[][] minStepFrom,
                    int[] best) {

        int B = buttons.length;
        int C = target.length;

        // Prune if already worse than best
        if (curPress >= best[0]) return;

        // Check overshoot and compute remaining by counter
        int[] remaining = new int[C];
        for (int c = 0; c < C; c++) {
            if (current[c] > target[c]) return; // invalid branch
            remaining[c] = target[c] - current[c];
        }

        // If all buttons used
        if (idx == B) {
            // valid only if exactly target
            for (int c = 0; c < C; c++) {
                if (remaining[c] != 0) return;
            }
            best[0] = Math.min(best[0], curPress);
            return;
        }

        // Lower bound heuristic: minimal extra presses needed from idx..end
        int lbExtra = 0;
        for (int c = 0; c < C; c++) {
            if (remaining[c] == 0) continue;
            int step = minStepFrom[idx][c];
            if (step == Integer.MAX_VALUE) {
                // no remaining button can ever increase this counter → impossible path
                return;
            }
            // ceil(remaining / step)
            int need = (remaining[c] + step - 1) / step;
            if (need > lbExtra) lbExtra = need;
        }
        if (curPress + lbExtra >= best[0]) return; // cannot beat current best

        int[] btn = buttons[idx];

        // Try k presses for this button (0..maxPress[idx])
        // Trying from 0 up to max works fine; you can also try from big to small.
        // Maintain cumulative effect to avoid repeated loops.
        int[] add = new int[C]; // k * btn
        for (int k = 0; k <= maxPress[idx]; k++) {
            // Apply cumulative add
            boolean ok = true;
            for (int c = 0; c < C; c++) {
                int val = current[c] + add[c];
                if (val > target[c]) {
                    ok = false;
                    break;
                }
            }
            if (!ok) break;

            // Push current + add downwards
            for (int c = 0; c < C; c++) {
                current[c] += add[c];
            }

            dfs(idx + 1, buttons, target, current, curPress + k, maxPress, minStepFrom, best);

            // Undo current + add for next k
            for (int c = 0; c < C; c++) {
                current[c] -= add[c];
            }

            // Increase add by one more press for next k+1
            if (k < maxPress[idx]) {
                for (int c = 0; c < C; c++) {
                    add[c] += btn[c];
                }
            }
        }
    }
}
