/*
 * LeetCode 66. Plus One
 * Difficulty: Easy
 *
 * Problem Statement:
 * - You are given a large integer represented as an array of digits.
 * - Each digit is stored such that the most significant digit is at the head of the array.
 * - Increment the integer by one and return the resulting array of digits.
 *
 * 🧠 Approach / Algorithm:
 * - Traverse the digits array from right to left.
 * - If the current digit is less than 9:
 *   - Increment it by 1.
 *   - Return the updated array immediately (no further carry needed).
 * - If the current digit is 9:
 *   - Set it to 0 and continue to propagate the carry.
 * - If all digits were 9:
 *   - Create a new array of size n + 1.
 *   - Set the first element to 1 and leave the rest as 0.
 * - Return the new array.
 *
 * Time Complexity: O(n)
 *   - n = number of digits.
 *
 * Space Complexity: O(1)
 *   - Constant extra space is used.
 *   - Output array creation is not counted as extra space.
 *
 * Important Details / Edge Cases:
 * - Handles numbers with trailing zeros correctly.
 * - Works when the number consists entirely of 9s (e.g., [9,9,9]).
 * - No integer overflow since operations are done on digits.
 */

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
