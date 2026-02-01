/*
 * LeetCode 8. String to Integer (atoi)
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Implement the myAtoi(string s) function, which converts a string
 *   to a 32-bit signed integer.
 * - The function discards leading whitespace, handles an optional
 *   sign (+ or -), reads digits until a non-digit character is found,
 *   and clamps the value within the 32-bit signed integer range
 *   [-2^31, 2^31 - 1].
 *
 * Approach / Algorithm:
 * - If the input string is null or empty after trimming, return 0.
 * - Trim leading and trailing whitespace.
 * - Determine the sign by checking the first character.
 * - Iterate through the string while characters are digits:
 *   - Convert each digit and build the number incrementally.
 *   - Before updating the result, check for overflow or underflow.
 *   - If overflow/underflow occurs, return Integer.MAX_VALUE or
 *     Integer.MIN_VALUE accordingly.
 * - Apply the sign and return the final result.
 *
 * Time Complexity: O(n)
 *   - n = length of the string.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Handles leading whitespaces.
 * - Correctly processes optional '+' or '-' sign.
 * - Stops parsing at the first non-digit character.
 * - Properly clamps values exceeding 32-bit integer limits.
 */

class Solution {
    public int myAtoi(String s) {
        if (s == null)
            return 0;

        s = s.trim();
        if (s.length() == 0)
            return 0;

        int i = 0;
        boolean positive = true;

        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            positive = s.charAt(i) == '+';
            i++;
        }

        int result = 0;

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return positive ? result : -result;
    }
}

