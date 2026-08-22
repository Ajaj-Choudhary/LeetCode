/*
 * LeetCode 3622. Check Divisibility by Digit Sum and Product
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - You are given a positive integer n.
 * - Determine whether n is divisible by the sum of its digit sum and digit product.
 * - Return true if n is divisible by this sum; otherwise, return false.
 *
 * Constraints:
 *
 * - 1 <= n <= 10^6
 *
 * Key Observation:
 *
 * - Extract each digit of n and calculate its digit sum and digit product.
 * - Check whether n is divisible by the sum of these two values.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int sum = 0;
        int mul = 1;

        while (num > 0) {
            int digit = num % 10;

            sum += digit;
            mul *= digit;

            num /= 10;
        }

        return n % (sum + mul) == 0;
    }
}