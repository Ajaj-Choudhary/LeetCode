/*
 * LeetCode 3211. Generate Binary Strings Without Adjacent Zeros
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given a positive integer n, generate all binary strings of length n.
 * - Every substring of length 2 must contain at least one '1'.
 * - Return all valid strings in any order.
 *
 * Constraints:
 *
 * - 1 <= n <= 16
 *
 * Key Observation:
 *
 * - Use backtracking to build the string character by character.
 * - '1' can always be added, while '0' can only be added when the previous character is not '0'.
 *
 * Time Complexity: O(2^n)
 * Space Complexity: O(n) excluding the output
 */

class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int n, StringBuilder current, List<String> result) {
        if (current.length() == n) {
            result.add(current.toString());
            return;
        }

        current.append('1');
        backtrack(n, current, result);
        current.deleteCharAt(current.length() - 1);

        if (current.length() == 0 || current.charAt(current.length() - 1) != '0') {
            current.append('0');
            backtrack(n, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}