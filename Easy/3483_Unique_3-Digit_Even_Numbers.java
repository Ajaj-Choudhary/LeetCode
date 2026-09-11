/*
 * LeetCode 3483. Unique 3-Digit Even Numbers
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - Given an array of digits, determine the number of distinct three-digit
 *   even numbers that can be formed using these digits.
 * - Each copy of a digit can be used at most once per number.
 * - The number cannot have a leading zero.
 *
 * Constraints:
 *
 * - 3 <= digits.length <= 10
 * - 0 <= digits[i] <= 9
 *
 * Key Observation:
 *
 * - Store the frequency of each digit so that repeated digits can be used
 *   only when enough copies exist.
 * - Enumerate every possible hundreds, tens, and even units digit.
 * - Check whether the required digit frequencies are available.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;

        for (int h = 1; h <= 9; h++) {
            for (int t = 0; t <= 9; t++) {
                for (int u = 0; u <= 8; u += 2) {
                    if (valid(freq, u, t, h)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean valid(int[] freq, int h, int t, int u) {
        if (h == t && t == u) {
            return freq[h] >= 3;
        }
        if (h == t) {
            return freq[h] >= 2 && freq[u] >= 1;
        }
        if (h == u) {
            return freq[h] >= 2 && freq[t] >= 1;
        }
        if (t == u) {
            return freq[t] >= 2 && freq[h] >= 1;
        }
        return freq[h] >= 1 && freq[t] >= 1 && freq[u] >= 1;
    }
}