/*
 * LeetCode 3090. Maximum Length Substring With Two Occurrences
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - Given a string s, return the maximum length of a substring.
 * - The substring must contain at most two occurrences of each character.
 *
 * Constraints:
 *
 * - 2 <= s.length <= 100
 * - s consists only of lowercase English letters.
 *
 * Key Observation:
 *
 * - Start a new substring from each index and maintain the frequency of each character.
 * - Stop extending the current substring when any character occurs more than twice, and update the maximum length for every valid substring.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */

class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLength = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] count = new int[26];

            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                count[c - 'a']++;

                if (count[c - 'a'] > 2) {
                    break;
                }

                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }
}