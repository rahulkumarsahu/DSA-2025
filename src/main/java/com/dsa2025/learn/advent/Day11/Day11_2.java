package com.dsa2025.learn.advent.Day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day11_2 {

    static Map<String, List<String>> network = new HashMap<>();

    static Map<String, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("/Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day_11.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(":");
                String source = parts[0].trim();

                if (parts.length > 1) {
                    List<String> destinations = new ArrayList<>();
                    for (String dest : parts[1].trim().split(" ")) {
                        destinations.add(dest.trim());
                    }
                    network.put(source, destinations);
                }
            }
            scanner.close();

            long result = countPaths("svr", false, false);

            System.out.println("Total valid paths: " + result);

        } catch (FileNotFoundException e) {
            System.err.println("Error: 'input.txt' not found.");
        }
    }

    static long countPaths(String current, boolean seenDAC, boolean seenFFT) {
        if (current.equals("dac")) seenDAC = true;
        if (current.equals("fft")) seenFFT = true;

        if (current.equals("out")) {
            return (seenDAC && seenFFT) ? 1 : 0;
        }

        String key = current + "|" + seenDAC + "|" + seenFFT;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (!network.containsKey(current)) {
            return 0;
        }

        long totalPaths = 0;
        for (String neighbor : network.get(current)) {
            totalPaths += countPaths(neighbor, seenDAC, seenFFT);
        }

        memo.put(key, totalPaths);
        return totalPaths;
    }
}
