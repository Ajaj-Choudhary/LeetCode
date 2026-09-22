/*
 * LeetCode 409. Longest Palindrome
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - Given a string s consisting of lowercase and uppercase English letters,
 *   return the length of the longest palindrome that can be built with those
 *   letters.
 * - Letters are case-sensitive.
 *
 * Constraints:
 *
 * - 1 <= s.length <= 2000
 * - s consists of lowercase and/or uppercase English letters only.
 *
 * Key Observation:
 *
 * - Every pair of equal characters can contribute 2 characters to the
 *   palindrome.
 * - After using all possible pairs, at most one unpaired character can be
 *   placed in the center of the palindrome.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        int length = 0;

        for (char ch : s.toCharArray()) {
            freq[ch]++;
            if (freq[ch] == 2) {
                length += 2;
                freq[ch] = 0;
            }
        }

        for (int count : freq) {
            if (count > 0) {
                return length + 1;
            }
        }

        return length;
    }
}