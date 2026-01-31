/*
 * LeetCode 7. Reverse Integer
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Given a signed 32-bit integer x, return x with its digits reversed.
 * - If reversing x causes the value to go outside the signed 32-bit integer range
 *   [-2^31, 2^31 - 1], then return 0.
 * - The environment does not allow storing 64-bit integers.
 *
 * Approach / Algorithm:
 * - Initialize a variable res to store the reversed number.
 * - Extract the last digit of x using x % 10.
 * - Before adding the digit to res, check for overflow and underflow:
 *   - If res is greater than Integer.MAX_VALUE / 10, or equal to it and the digit
 *     is greater than 7, return 0.
 *   - If res is less than Integer.MIN_VALUE / 10, or equal to it and the digit
 *     is less than -8, return 0.
 * - Update res by multiplying it by 10 and adding the digit.
 * - Remove the last digit from x by dividing it by 10.
 * - Repeat until x becomes 0.
 *
 * Time Complexity: O(n)
 *   - n = number of digits in the integer.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Handles negative numbers correctly.
 * - Prevents integer overflow and underflow explicitly.
 * - Returns 0 when reversed integer exceeds 32-bit range.
 */

class Solution {
    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int digit = x % 10;

            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && digit > 7) {
                return 0;
            }

            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && digit < -8) {
                return 0;
            }

            res = res * 10 + digit;
            x /= 10;
        }

        return res;
    }
}

