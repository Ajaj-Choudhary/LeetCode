/*
 * LeetCode 33. Search in Rotated Sorted Array
 * Difficulty: Medium
 *
 * Problem Statement:
 * - An integer array nums is sorted in ascending order and then rotated.
 * - All values are distinct.
 * - Return the index of target if present, otherwise return -1.
 * - Must run in O(log n) time.
 *
 * Approach:
 * - Use modified binary search.
 * - At every step, one half of the array is always sorted.
 * - Determine which half is sorted and check if the target lies in that half.
 * - Narrow the search space accordingly.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}

