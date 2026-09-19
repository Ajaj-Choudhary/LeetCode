/*
 * LeetCode 1358. Number of Substrings Containing All Three Characters
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given a string s consisting only of characters a, b, and c.
 * - Return the number of substrings containing at least one occurrence
 *   of all three characters a, b, and c.
 *
 * Constraints:
 *
 * - 3 <= s.length <= 5000
 * - s consists only of characters a, b, and c.
 *
 * Key Observation:
 *
 * - Store the last occurrence index of each character a, b, and c.
 * - For every position i, the smallest last occurrence represents the
 *   earliest valid starting position for a substring ending at i.
 * - Therefore, min(last[0], last[1], last[2]) + 1 gives the number of
 *   valid substrings ending at i.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int numberOfSubstrings(String s) {
        int[] last = {-1, -1, -1};

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;

            ans += Math.min(last[0], Math.min(last[1], last[2])) + 1;
        }

        return ans;
    }
}