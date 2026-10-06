/*
 * LeetCode 921. Minimum Add to Make Parentheses Valid
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given a parentheses string s, insert the minimum number of parentheses to make it valid.
 * - Return the minimum number of insertions required.
 *
 * Constraints:
 *
 * - 1 <= s.length <= 1000
 * - s[i] is '(' or ')'.
 *
 * Key Observation:
 *
 * - Track unmatched opening parentheses using open.
 * - For an unmatched closing parenthesis, one opening parenthesis is required.
 * - At the end, all remaining unmatched opening parentheses also need closing parentheses.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    count++;
                }
            }
        }

        return open + count;
    }
}