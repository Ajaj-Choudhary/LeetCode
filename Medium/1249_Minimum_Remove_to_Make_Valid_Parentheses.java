/*
 * LeetCode 1249. Minimum Remove to Make Valid Parentheses
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given a string containing parentheses and lowercase English characters.
 * - Remove the minimum number of parentheses so that the resulting string is valid.
 * - Return any valid resulting string.
 *
 * Constraints:
 *
 * - 1 <= s.length <= 10^5
 * - s[i] is a lowercase English character, '(' or ')'.
 *
 * Key Observation:
 *
 * - Store the indices of unmatched '(' using a stack.
 * - Mark unmatched ')' and remaining unmatched '(' for removal.
 * - Build the result by skipping the marked characters.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (stack.isEmpty()) {
                    chars[i] = '*';
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            chars[stack.pop()] = '*';
        }

        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (c != '*') {
                result.append(c);
            }
        }

        return result.toString();
    }
}