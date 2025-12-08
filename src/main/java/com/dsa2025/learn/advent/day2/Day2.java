package com.dsa2025.learn.advent.day2;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static List<Ranges> parseRanges(String input) {
        List<Ranges> ranges = new ArrayList<>();
        String[] range = input.split(",");

        for (String r : range) {
            String[] parts = r.trim().split("-");
            if (parts.length == 2) {
                try {
                    long start = Long.parseLong(parts[0]);
                    long end = Long.parseLong(parts[1]);
                    if (start <= end) {
                        ranges.add(new Ranges(start, end));
                    }
                } catch (NumberFormatException e) {
                    // Skip invalid ranges
                }
            }
        }
        return ranges;
    }


    public static void main(String[] args) {
        String input = "9191896883-9191940271,457499-518693,4952-6512,960-1219,882220-1039699,2694-3465,3818-4790,166124487-166225167,759713819-759869448,4821434-4881387,7271-9983,1182154-1266413,810784-881078,802-958,1288-1491,45169-59445,25035-29864,379542-433637,287-398,75872077-75913335,653953-689335,168872-217692,91-113,475-590,592-770,310876-346156,2214325-2229214,85977-112721,51466993-51620441,8838997-8982991,534003-610353,32397-42770,17-27,68666227-68701396,1826294188-1826476065,1649-2195,141065204-141208529,7437352-7611438,10216-13989,33-44,1-16,49-74,60646-73921,701379-808878";

        List<Ranges> ranges = parseRanges(input);

        Long sum = getSumOfInvalidId(ranges);
        Long sum_two = getSumOfInvalidIdPart2(ranges);
        System.out.println(sum);
        System.out.println(sum_two);
    }

    private static Long getSumOfInvalidIdPart2(List<Ranges> ranges) {

        long sum = 0L;
        for (Ranges ranges_input : ranges) {
            Long firstId = ranges_input.getFirstId();
            Long secondId = ranges_input.getSecondId();

            for (long i = firstId; i <= secondId; i++) {
               if (checkInvalidId(i)) {
                   sum += i;
               }

            }
        }
        return sum;
    }

    private static boolean checkInvalidId(long i) {
        boolean isInvalid = false;

        String input = Long.toString(i);
        int length = input.length();
        if (length % 2 == 0) {
            int half = length / 2;
            String firstHalf = input.substring(0, half);
            String secondHalf = input.substring(half);
            if (firstHalf.equals(secondHalf)) {
                isInvalid = true;
            }
        }

        if (!isInvalid) {
            for (int len = 1; len * 2 <= length && !isInvalid; len++) {
                if (length % len != 0) continue;

                String part = input.substring(0, len);
                int repeat = length / len;

                StringBuilder sb = new StringBuilder();
                sb.append(part.repeat(repeat));
                if (sb.toString().equals(input)) {
                    isInvalid = true;
                }
            }
        }

        return isInvalid;
    }

    private static Long getSumOfInvalidId(List<Ranges> ranges) {
        long sum = 0L;
        for (Ranges ranges_input : ranges) {
            Long firstId = ranges_input.getFirstId();
            Long secondId = ranges_input.getSecondId();

            for (long i = firstId; i <= secondId; i++) {
                String input = Long.toString(i);
                int length = input.length();
                if (length % 2 == 0) {
                    int half = length / 2;
                    String firstHalf = input.substring(0, half);
                    String secondHalf = input.substring(half);
                    if (firstHalf.equals(secondHalf)) {
                        sum += i;
                    }
                }

            }
        }
        return sum;
    }
}

/****
 *   Example 1: s = “123123” (should be invalid)
 * •  s.length()  is 6.
 * len = 1
 * • Condition  len * 2 <= 6  →  1 * 2 <= 6  → true, so enter.
 * •  6 % 1 == 0  → pass to continue .
 * •  part = s.substring(0, 1) = "1" .
 * •  repeat = 6 / 1 = 6 .
 * • Inner loop builds  sb = "1"  six times →  "111111" .
 * •  "111111".equals("123123")  → false → do not return, go to next  len .
 * len = 2
 * •  2 * 2 <= 6  → true.
 * •  6 % 2 == 0  → pass.
 * •  part = s.substring(0, 2) = "12" .
 * •  repeat = 6 / 2 = 3 .
 * • Inner loop builds  "12"  three times →  "121212" .
 * •  "121212".equals("123123")  → false → next  len .
 * len = 3
 * •  3 * 2 <= 6  → true.
 * •  6 % 3 == 0  → pass.
 * •  part = s.substring(0, 3) = "123" .
 * •  repeat = 6 / 3 = 2 .
 * • Inner loop builds  "123"  twice →  "123123" .
 * •  "123123".equals("123123")  → true →  return true; .
 * So  "123123"  is detected as: block  "123"  repeated 2 times.
 * Example 2: s = “12121212” (also invalid)
 * •  s.length()  is 8.
 * len = 1
 * •  1 * 2 <= 8  → true.
 * •  8 % 1 == 0  → pass.
 * •  part = "1" ,  repeat = 8 .
 * • Build  "11111111" ; not equal to  "12121212"  → continue.
 * len = 2
 * •  2 * 2 <= 8  → true.
 * •  8 % 2 == 0  → pass.
 * •  part = s.substring(0, 2) = "12" .
 * •  repeat = 8 / 2 = 4 .
 * • Build  "12"  4 times →  "12121212" .
 * • Equals  s  →  return true; .
 * So  "12121212"  is treated as  "12"  repeated 4 times.
 * Example 3: s = “12312” (should be valid)
 * •  s.length()  is 5.
 * len = 1
 * •  1 * 2 <= 5  → true.
 * •  5 % 1 == 0  → pass.
 * •  part = "1" ,  repeat = 5 , build  "11111"  → not equal.
 * len = 2
 * •  2 * 2 <= 5  →  4 <= 5  → true.
 * •  5 % 2 != 0  → continue (skip this len), because 5 cannot be tiled by blocks of length 2.
 * Loop stops after  len = 2  because next would be  len = 3  and  3 * 2 <= 5  is false.
 * No  return true  happened, so the method reaches the end and returns  false .  "12312"  is not “some block repeated at least twice”.
 * Example 4: s = “999” (still invalid for part 2)
 * •  s.length()  is 3.
 * len = 1
 * •  1 * 2 <= 3  → true.
 * •  3 % 1 == 0  → pass.
 * •  part = "9" ,  repeat = 3 .
 * • Build  "9"  three times →  "999" .
 * • Equals  s  →  return true; .
 * So  "999"  is treated as block  "9"  repeated 3 times.
 */
