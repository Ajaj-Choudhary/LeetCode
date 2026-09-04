/*
 * LeetCode 3903. Smallest Stable Index I
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - Given an integer array nums and an integer k.
 * - For each index i, calculate the instability score as
 *   max(nums[0..i]) - min(nums[i..n - 1]).
 * - Return the smallest index whose instability score is less than
 *   or equal to k. If none exists, return -1.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 100
 * - 0 <= nums[i] <= 10^9
 * - 0 <= k <= 10^9
 *
 * Key Observation:
 *
 * - Precompute the minimum value from each index to the end using suffixMin.
 * - While traversing from left to right, maintain the maximum value seen so far.
 * - The first index where prefixMax - suffixMin[i] <= k is the answer.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        int prefixMax = nums[0];

        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);

            if (prefixMax - suffixMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}