/*
 * LeetCode 3702. Longest Subsequence With Non-Zero Bitwise XOR
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - You are given an integer array nums.
 * - Return the length of the longest subsequence in nums whose bitwise XOR is non-zero.
 * - If no such subsequence exists, return 0.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 10^5
 * - 0 <= nums[i] <= 10^9
 *
 * Key Observation:
 *
 * - If the XOR of all elements is non-zero, the entire array is the longest valid subsequence.
 * - If the total XOR is zero but at least one element is non-zero, removing one non-zero element gives a valid subsequence of length n - 1. If all elements are zero, no valid subsequence exists.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int longestSubsequence(int[] nums) {
        int total = 0;
        boolean hasNonZero = false;

        for (int x : nums) {
            total ^= x;
            if (x != 0) {
                hasNonZero = true;
            }
        }

        if (total != 0) {
            return nums.length;
        }
        if (hasNonZero) {
            return nums.length - 1;
        }
        return 0;
    }
}