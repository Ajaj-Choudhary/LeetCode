/*
 * LeetCode 268. Missing Number
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given an array nums containing n distinct numbers in the range [0, n],
 *   return the only number in the range that is missing from the array.
 *
 * Approach / Algorithm:
 * - Use XOR (^) property:
 *   - a ^ a = 0
 *   - a ^ 0 = a
 * - XOR all indices and array values together.
 * - Initialize result with nums.length to include the last number (n).
 * - The final XOR result gives the missing number.
 *
 * Time Complexity: O(n)
 *   - Single pass through the array.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Works for all valid permutations of numbers in range [0, n].
 * - Avoids integer overflow unlike sum-based approach.
 */

class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }

        return res;
    }
}

