/*
 * LeetCode 162. Find Peak Element
 * Difficulty: Medium
 *
 * Problem Statement:
 * - A peak element is an element that is strictly greater than its neighbors.
 * - Given a 0-indexed integer array nums, find a peak element and return its index.
 * - If the array contains multiple peaks, return the index to any of the peaks.
 * - You may imagine that nums[-1] = nums[n] = -∞.
 * - The solution must run in O(log n) time.
 *
 * Approach / Algorithm:
 * - Use Binary Search to find the peak element.
 * - Initialize two pointers: left and right.
 * - Find mid and compare nums[mid] with nums[mid + 1]:
 *   - If nums[mid] < nums[mid + 1], the peak lies on the right side.
 *   - Otherwise, the peak lies on the left side or at mid.
 * - Continue reducing the search space until left equals right.
 * - Return left as the peak index.
 *
 * Time Complexity: O(log n)
 *   - Binary search reduces the search space each iteration.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - The array may contain multiple peaks.
 * - nums[mid + 1] is safe because left < right ensures mid < right.
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}

