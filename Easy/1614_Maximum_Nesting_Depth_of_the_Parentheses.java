/*
 * LeetCode 1614. Maximum Nesting Depth of the Parentheses
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - Given a valid parentheses string s, return its nesting depth.
 * - The nesting depth is the maximum number of nested parentheses.
 *
 * Constraints:
 *
 * - 1 <= s.length <= 100
 * - s consists of digits 0-9 and the characters '+', '-', '(', and ')'.
 * - s is a valid parentheses string.
 *
 * Key Observation:
 *
 * - Increase the current depth when encountering '(' and decrease it for ')'.
 * - Track the maximum depth reached during the traversal.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int maxDepth(String s) {
        int level = 0;
        int maxLevel = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                level++;
                maxLevel = Math.max(maxLevel, level);
            } else if (c == ')') {
                level--;
            }
        }

        return maxLevel;
    }
}