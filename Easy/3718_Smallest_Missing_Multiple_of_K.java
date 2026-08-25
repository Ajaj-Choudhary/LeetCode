/*
 * LeetCode 3718. Smallest Missing Multiple of K
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - Given an integer array nums and an integer k, return the smallest positive multiple of k that is missing from nums.
 * - A multiple of k is any positive integer divisible by k.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 100
 * - 1 <= nums[i] <= 100
 * - 1 <= k <= 100
 *
 * Key Observation:
 *
 * - Store all elements of nums in a boolean array for constant-time lookup.
 * - Check positive multiples of k in increasing order and return the first multiple that is missing.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] seen = new boolean[101];

        for (int num : nums) {
            seen[num] = true;
        }

        for (int multiple = k; ; multiple += k) {
            if (multiple > 100 || !seen[multiple]) {
                return multiple;
            }
        }
    }
}