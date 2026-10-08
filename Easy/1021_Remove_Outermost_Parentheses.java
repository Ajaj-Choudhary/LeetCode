/*
 * LeetCode 1021. Remove Outermost Parentheses
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - Given a valid parentheses string s, consider its primitive decomposition.
 * - Remove the outermost pair of parentheses from every primitive string.
 * - Return the resulting string.
 *
 * Constraints:
 *
 * - 1 <= s.length <= 10^5
 * - s[i] is either '(' or ')'.
 * - s is a valid parentheses string.
 *
 * Key Observation:
 *
 * - Track the current nesting level.
 * - An opening parenthesis is outermost when the current level is 0.
 * - A closing parenthesis is outermost when the level becomes 0 after decrementing.
 * - Append only parentheses that are not outermost.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                if (level > 0) {
                    sb.append(ch);
                }
                level++;

            } else if (ch == ')') {
                level--;
                if (level > 0) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}