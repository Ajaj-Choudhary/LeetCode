/*
 * LeetCode 81. Search in Rotated Sorted Array II
 * Difficulty: Medium
 *
 * Problem Statement:
 * - There is an integer array nums sorted in non-decreasing order
 *   (not necessarily with distinct values).
 * - nums is rotated at an unknown pivot index.
 * - Given nums and an integer target, return true if target is in nums,
 *   otherwise return false.
 *
 * Approach / Algorithm:
 * - Use modified Binary Search.
 * - If middle element equals target, return true.
 * - If left, mid, and right elements are equal, shrink the search space.
 * - Determine which half is sorted and adjust search boundaries accordingly.
 *
 * Time Complexity:
 * - Average: O(log n)
 * - Worst case (duplicates): O(n)
 *
 * Space Complexity: O(1)
 *
 * Important Details / Edge Cases:
 * - Handles duplicate values which can break normal binary search logic.
 * - Shrinks bounds when nums[left] == nums[mid] == nums[right].
 */

class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}

