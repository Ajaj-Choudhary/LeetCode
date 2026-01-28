/*
 * LeetCode 14. Longest Common Prefix
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given an array of strings, find the longest common prefix among all strings.
 * - If there is no common prefix, return an empty string "".
 *
 * 🧠 Approach / Algorithm:
 * - This solution uses a horizontal scanning approach by comparing characters column-wise.
 * - Take the first string as a reference.
 * - Iterate through each character of the first string using an index i.
 * - For the current character:
 *   - Compare it with the character at the same index i in all other strings.
 * - If:
 *   - Any string is shorter than index i, or
 *   - The character at index i does not match,
 *   → return the result built so far.
 * - If all strings match the character, append it to the result.
 * - Continue until all characters of the first string are checked.
 * - This ensures we stop as soon as the prefix breaks, making the solution efficient.
 *
 * Time Complexity: O(n × m)
 *   - n = number of strings
 *   - m = length of the shortest string
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space (excluding output).
 *
 * Important Details / Edge Cases:
 * - Assumes the input array is non-empty.
 * - Handles strings of different lengths.
 * - Early termination improves efficiency.
 * - If the first string is empty, the result is empty.
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c)
                    return res.toString();
            }
            res.append(c);
        }
        return res.toString();
    }
}
