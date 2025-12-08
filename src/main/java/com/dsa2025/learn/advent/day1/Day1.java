package com.dsa2025.learn.advent.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/rahulkumar/Documents/Learning/DSA-2025/inputs/input_day1.txt"))) {
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

        int password = getTheActualPassword(inputs);

        int newPassword = getTheNewActualPassword(inputs);

        System.out.println(newPassword);

        System.out.println(password);

    }

    private static int getTheNewActualPassword(String[] inputs) {

        int initial = 50;
        int count = 0;

        for (String input : inputs) {
            char category = input.charAt(0);
            int input_data = Integer.parseInt(input.substring(1));

            if (category == 'L') {
                while (input_data > 0) {
                    if (initial == 0) {
                        count += 1;
                    }
                    initial -= 1;
                    if (initial < 0) {
                        initial = 99;
                    }
                    input_data -= 1;
                }
            } else if (category == 'R') {
                while (input_data > 0) {
                    if (initial == 0) {
                        count += 1;
                    }
                    initial += 1;
                    if (initial > 99) {
                        initial = 0;
                    }
                    input_data -= 1;
                }
            }
        }

        return count;
    }

    private static int getTheActualPassword(String[] inputs) {
        int count = 0;
        int initial = 50;

        for (String input: inputs) {
            char category = input.charAt(0);
            int input_data = Integer.parseInt(input.substring(1));

            if (input_data > 100) {
                input_data = input_data % 100;
            }

            if (input_data > initial && category == 'L') {
                initial = 100 - (input_data - initial);
            } else if (input_data <= initial && category == 'L') {
                initial = initial - input_data;
            } else if (input_data  + initial > 100 && category == 'R') {
                initial = (initial + input_data) - 100;
            } else if (input_data + initial <= 100 && category == 'R') {
                initial = initial + input_data;
            }

            //System.out.println("Input is " +  input + " After movement " + initial);

            if (initial == 100 || initial == 0) {
                initial = 0;
                count++;
            }
        }
        return count;
    }
}
