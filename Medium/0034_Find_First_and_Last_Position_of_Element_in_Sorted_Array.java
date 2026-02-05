/*
 * LeetCode 34. Find First and Last Position of Element in Sorted Array
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Given an array of integers nums sorted in non-decreasing order,
 *   find the starting and ending position of a given target value.
 * - If target is not found in the array, return [-1, -1].
 *
 * Approach / Algorithm:
 * - Use Binary Search twice:
 *   - First to find the starting index of the target.
 *   - Second to find the ending index of the target.
 * - Create a helper method binarySearch:
 *   - If findStart is true, search toward the left side to locate
 *     the first occurrence.
 *   - Otherwise, search toward the right side to locate the last occurrence.
 * - Return both indices as an array.
 *
 * Time Complexity: O(log n)
 *   - Binary search is performed twice.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Works when target appears multiple times.
 * - Returns [-1, -1] if target is not present.
 * - Handles empty input array correctly.
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {
                binarySearch(nums, target, true),
                binarySearch(nums, target, false)
        };
    }

    public int binarySearch(int[] nums, int target, boolean findStart) {
        int left = 0, right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                index = mid;
                if (findStart) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        
        return index;
    }
}

