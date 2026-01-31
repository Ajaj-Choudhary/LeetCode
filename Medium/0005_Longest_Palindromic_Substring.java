/*
 * LeetCode 5. Longest Palindromic Substring
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Given a string s, return the longest palindromic substring in s.
 *
 * Approach / Algorithm:
 * - Use the expand-around-center technique.
 * - A palindrome can be centered at:
 *   - A single character (odd-length palindrome).
 *   - Two adjacent characters (even-length palindrome).
 * - For each index i in the string:
 *   - Expand around center (i, i) to find odd-length palindromes.
 *   - Expand around center (i, i + 1) to find even-length palindromes.
 * - During expansion, if characters match:
 *   - Update the result if the current palindrome is longer.
 * - Continue this process for all indices.
 *
 * Time Complexity: O(n^2)
 *   - n = length of the string.
 *   - Each expansion can take O(n) time in the worst case.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space (excluding output substring).
 *
 * Important Details / Edge Cases:
 * - Handles strings of length 1 correctly.
 * - Works for both even and odd length palindromes.
 * - Returns the first longest palindrome if multiple exist.
 */

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";

        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (res.length() < r - l + 1) {
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (res.length() < r - l + 1) {
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        return res;
    }
}

