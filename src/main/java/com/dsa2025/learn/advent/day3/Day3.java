package com.dsa2025.learn.advent.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class Day3 {

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day3.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] inputs = lines.toArray(new String[0]);

        int sum1 = getSumPart1(inputs);

        BigInteger sum2 = getSumPart2(inputs);

        System.out.println(sum2.longValue());

    }

    private static BigInteger getSumPart2(String[] inputs) {

        BigInteger sum = BigInteger.ZERO;

        for (String input : inputs) {

            int[] numberList = new int[input.length()];
            String[] numbers = input.split("");
            int i = 0;
            for (String s : numbers) {
                numberList[i] = Integer.parseInt(s);
                i++;
            }

            int idx = 0;

            StringBuilder number = new StringBuilder();

            for (int numbersLeft = 11; numbersLeft > -1; numbersLeft--) {
                List<Integer> res = findLargest(numberList, numbersLeft, idx);
                idx = res.get(0);
                number.append(res.get(1));
            }

            sum = sum.add(new BigInteger(number.toString()));


        }

        return sum;
    }

    private static List<Integer> findLargest(int[] numberList, int numbersLeft, int idx) {

        int newIdx = 0;
        int largest = 0;
        for (int i = idx; i < numberList.length - numbersLeft; i++) {

            if (numberList[i] > largest) {
                largest = numberList[i];
                newIdx = i + 1;
            }
        }

        return Arrays.asList(newIdx, largest);


    }

    private static int getSumPart1(String[] inputs) {

        int total = 0;

        for (String line : inputs) {
            int best = 0;

            for (int i = 0; i < line.length(); i++) {
                int first = line.charAt(i) - '0';
                for (int j = i + 1; j < line.length(); j++) {
                    int second = line.charAt(j) - '0';
                    int val = first * 10 + second;
                    if (val > best) {
                        best = val;
                    }
                }
            }

            total += best;
        }
        return total;
    }
}