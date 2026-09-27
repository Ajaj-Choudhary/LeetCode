/*
 * LeetCode 1190. Reverse Substrings Between Each Pair of Parentheses
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given a string containing lowercase English letters and parentheses.
 * - Reverse the strings inside each pair of matching parentheses, starting from the innermost pair.
 * - Return the resulting string without any parentheses.
 *
 * Constraints:
 *
 * - 1 <= s.length <= 2000
 * - s consists of lowercase English letters and parentheses.
 * - All parentheses in s are balanced.
 *
 * Key Observation:
 *
 * - Store the matching index of every pair of parentheses using a stack.
 * - When a parenthesis is encountered, jump to its matching pair and reverse the traversal direction.
 * - This avoids explicitly reversing substrings and processes each character in linear time.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        int direction = 1;

        for (int i = 0; i >= 0 && i < n;) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == ')') {
                i = pair[i];
                direction = -direction;
            } else {
                result.append(ch);
            }

            i += direction;
        }

        return result.toString();
    }
}