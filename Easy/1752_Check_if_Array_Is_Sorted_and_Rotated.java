/*
 * LeetCode 1752. Check if Array Is Sorted and Rotated
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - Given an array nums, return true if the array was originally sorted in
 *   non-decreasing order and then rotated some number of positions.
 * - Otherwise, return false.
 * - The original sorted array may contain duplicate values.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 100
 * - 1 <= nums[i] <= 100
 *
 * Key Observation:
 *
 * - In a sorted and rotated array, there can be at most one position where
 *   nums[i] > nums[(i + 1) % n].
 * - If there is more than one such position, the array cannot be sorted and
 *   rotated.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}