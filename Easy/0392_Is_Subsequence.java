/*
 * LeetCode 392. Is Subsequence
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * - A subsequence is a new string formed by deleting some or none of the characters from the original string without changing the relative positions of the remaining characters.
 *
 * Constraints:
 *
 * - 0 <= s.length <= 100
 * - 0 <= t.length <= 10^4
 * - s and t consist only of lowercase English letters.
 *
 * Key Observation:
 *
 * - Use two pointers to traverse both strings and advance the pointer of s whenever a matching character is found in t.
 * - If all characters of s are matched, s is a subsequence of t.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        int left = 0;

        for (int right = 0; right < t.length() && left < s.length(); right++) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }
        }

        return left == s.length();
    }
}