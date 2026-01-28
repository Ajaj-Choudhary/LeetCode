/*
 * LeetCode 58. Length of Last Word
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given a string s consisting of words and spaces,
 *   return the length of the last word in the string.
 * - A word is defined as a maximal substring consisting of non-space characters.
 *
 * 🧠 Approach / Algorithm:
 * - First, remove any leading and trailing spaces using trim().
 * - Find the index of the last space character in the trimmed string.
 * - The last word starts immediately after this space.
 * - Return the length of the substring from that position to the end of the string.
 *
 * Time Complexity: O(n)
 *   - n = length of the string.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Handles strings with trailing spaces.
 * - Works correctly when the string contains only one word.
 * - trim() ensures no extra spaces affect the result.
 */

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.lastIndexOf(' ');
        return s.substring(i + 1).length();
    }
}
