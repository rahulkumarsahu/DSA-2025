package com.dsa2025.learn.advent.Day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day10 {

    public static void main(String[] args) {
        String filename = "/Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day_10.txt";

        try {
            List<String> machines = readMachinesFromFile(filename);
            int totalPresses = 0;

            for (String machine : machines) {
                int minPresses = solveMachine(machine);
                totalPresses += minPresses;
                System.out.println("Machine: " + minPresses + " presses");
            }
            System.out.println(totalPresses);

        } catch (IOException e) {
        }
    }

    static List<String> readMachinesFromFile(String filename) throws IOException {
        List<String> machines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    machines.add(line);
                }
            }
        }
        return machines;
    }

    static int solveMachine(String line) {
        String[] parts = line.split(" ");

        String targetPattern = parts[0].replace("[", "").replace("]", "");
        int numLights = targetPattern.length();
        boolean[] targetOn = new boolean[numLights];

        for (int i = 0; i < numLights; i++) {
            targetOn[i] = (targetPattern.charAt(i) == '#');
        }

        List<boolean[]> buttons = new ArrayList<>();
        for (int i = 1; i < parts.length; i++) {
            if (parts[i].startsWith("(") && parts[i].endsWith(")")) {
                String btnStr = parts[i].replace("(", "").replace(")", "");
                boolean[] btnLights = new boolean[numLights];

                for (String pos : btnStr.split(",")) {
                    int lightPos = Integer.parseInt(pos.trim());
                    if (lightPos < numLights) {
                        btnLights[lightPos] = true;
                    }
                }
                buttons.add(btnLights);
            }
        }

        int minPresses = Integer.MAX_VALUE;
        int numButtons = buttons.size();

        for (int combo = 0; combo < (1 << numButtons); combo++) {
            boolean[] currentLights = new boolean[numLights];

            int pressCount = 0;
            for (int b = 0; b < numButtons; b++) {
                if ((combo & (1 << b)) != 0) {
                    for (int light = 0; light < numLights; light++) {
                        if (buttons.get(b)[light]) {
                            currentLights[light] = !currentLights[light];
                        }
                    }
                    pressCount++;
                }
            }

            boolean matches = true;
            for (int light = 0; light < numLights; light++) {
                if (currentLights[light] != targetOn[light]) {
                    matches = false;
                    break;
                }
            }

            if (matches) {
                minPresses = Math.min(minPresses, pressCount);
            }
        }

        return minPresses == Integer.MAX_VALUE ? 0 : minPresses;
    }
}
