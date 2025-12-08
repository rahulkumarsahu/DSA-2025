package com.dsa2025.learn.advent.day5;

import java.math.BigInteger;
import java.util.*;

public class Day5_Part2 {

    public static void main(String[] args) {
        String input = """
                """;

        List<BigInteger[]> ranges = new ArrayList<>();
        Scanner scanner = new Scanner(input);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) break;
            if (!line.contains("-")) continue;

            String[] parts = line.split("-");
            ranges.add(new BigInteger[] {
                    new BigInteger(parts[0]),
                    new BigInteger(parts[1])
            });
        }

        ranges.sort(Comparator.comparing(a -> a[0]));  // sort by start [web:1][web:4]

        List<BigInteger[]> merged = new ArrayList<>();
        for (BigInteger[] range : ranges) {
            if (merged.isEmpty()) {
                merged.add(range);
                continue;
            }

            BigInteger[] last = merged.get(merged.size() - 1);
            if (range[0].compareTo(last[1].add(BigInteger.ONE)) > 0) { // disjoint
                merged.add(range);
            } else { // overlap or adjacent
                last[1] = last[1].max(range[1]);
            }
        }

        BigInteger total = BigInteger.ZERO;  // [web:11][web:19]
        System.out.println("Ranges parsed: " + ranges.size());
        System.out.println("Merged ranges:");
        for (BigInteger[] r : merged) {
            BigInteger length = r[1].subtract(r[0]).add(BigInteger.ONE); // [web:22][web:24]
            total = total.add(length);
            System.out.println("  " + r[0] + "-" + r[1] + " (" + length + " IDs)");
        }

        System.out.println("\nTotal unique fresh ingredient IDs: " + total);
    }
}
