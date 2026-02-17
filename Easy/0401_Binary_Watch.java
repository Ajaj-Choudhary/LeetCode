/*
 * LeetCode 401. Binary Watch
 * Difficulty: Easy
 *
 * Problem Statement:
 * - A binary watch has:
 *     • 4 LEDs for hours (0–11)
 *     • 6 LEDs for minutes (0–59)
 * - Each LED represents a binary digit (0 or 1).
 * - Given an integer turnedOn, return all possible valid times
 *   the watch could represent.
 *
 * Rules:
 * - Hour must NOT contain leading zero (e.g., "01:00" ❌).
 * - Minute must always be two digits (e.g., "10:02" ✔).
 *
 * Approach / Algorithm:
 * - Iterate through all possible hours (0–11).
 * - Iterate through all possible minutes (0–59).
 * - Count the number of 1-bits in:
 *       hour + minute
 * - If total number of set bits equals turnedOn,
 *   add the formatted time to result.
 *
 * - Use Integer.bitCount(x) to count number of 1s in binary.
 *
 * Time Complexity: O(12 × 60) ≈ O(1)
 *   - Constant because range is fixed.
 *
 * Space Complexity: O(1)
 *   - Result size is bounded by small constant.
 *
 * Important Details:
 * - Use String.format("%02d", minute) to ensure
 *   minute always has two digits.
 * - No need for backtracking — brute force works
 *   because constraints are small.
 */

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {

                if (Integer.bitCount(hour) + 
                    Integer.bitCount(minute) == turnedOn) {

                    result.add(hour + ":" + 
                               String.format("%02d", minute));
                }
            }
        }

        return result;
    }
}

