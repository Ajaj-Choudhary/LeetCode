/*
 * LeetCode 136. Single Number
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given a non-empty array of integers nums,
 *   every element appears twice except for one.
 * - Find and return the single element that appears only once.
 *
 * 🧠 Approach / Algorithm:
 * - Use the XOR (^) bitwise operator.
 * - XOR properties used:
 *   - a ^ a = 0
 *   - a ^ 0 = a
 *   - XOR is commutative and associative.
 * - Traverse the array and XOR all elements.
 * - All duplicate numbers cancel out, leaving the unique number.
 *
 * Time Complexity: O(n)
 *   - n = number of elements in the array.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Works correctly with negative numbers.
 * - Assumes exactly one number appears once and all others appear twice.
 * - No additional data structures are required.
 */

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
