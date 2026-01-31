/*
 * LeetCode 3. Longest Substring Without Repeating Characters
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Given a string s, find the length of the longest substring
 *   without repeating characters.
 *
 * Approach / Algorithm:
 * - Use the sliding window technique with two pointers.
 * - Maintain a left pointer (l) and a right pointer (r) to represent
 *   the current window.
 * - Use an array `hash` of size 256 to store the last index of each character.
 * - Initialize all values in the hash array to -1.
 * - Traverse the string using the right pointer:
 *   - If the current character was seen before and its last index
 *     is within the current window, move the left pointer to
 *     one position after its last occurrence.
 *   - Update the maximum length of the substring.
 *   - Update the last seen index of the current character.
 * - Continue until the right pointer reaches the end of the string.
 *
 * Time Complexity: O(n)
 *   - n = length of the string.
 *
 * Space Complexity: O(1)
 *   - Uses constant space (fixed-size array of 256 characters).
 *
 * Important Details / Edge Cases:
 * - Handles empty strings correctly.
 * - Works for all ASCII characters.
 * - Sliding window ensures no repeated characters in the current substring.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, maxLen = 0, n = s.length();
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        while (r < n) {
            if (hash[s.charAt(r)] != -1 && hash[s.charAt(r)] >= l) {
                l = hash[s.charAt(r)] + 1;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            hash[s.charAt(r)] = r++;
        }
        return maxLen;
    }
}

