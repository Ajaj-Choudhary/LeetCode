/*
 * LeetCode 2904. Shortest and Lexicographically Smallest Beautiful String
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - You are given a binary string s and a positive integer k.
 * - A substring is beautiful if it contains exactly k occurrences of '1'.
 * - Return the lexicographically smallest beautiful substring among those with the shortest length, or an empty string if none exists.
 *
 * Constraints:
 *
 * - 1 <= s.length <= 100
 * - 1 <= k <= s.length
 *
 * Key Observation:
 *
 * - Store the positions of all '1' characters. Every shortest beautiful substring must start and end at two '1' positions that contain exactly k ones between them.
 * - For each group of k consecutive '1' positions, calculate its length and compare equal-length candidates lexicographically.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(n)
 */

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int[] pos = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                pos[total++] = i;
        }

        String ans = "";
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i + k <= total; i++) {
            int start = pos[i];
            int end = pos[i + k - 1];
            int len = end - start + 1;

            if (len < minLen) {
                minLen = len;
                ans = s.substring(start, end + 1);
            } else if (len == minLen) {
                String candidate = s.substring(start, end + 1);
                if (candidate.compareTo(ans) < 0) {
                    ans = candidate;
                }
            }
        }

        return ans;
    }
}