/*
 * LeetCode 35. Search Insert Position
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given a sorted array of distinct integers and a target value,
 *   return the index if the target is found.
 * - If not found, return the index where it would be inserted
 *   to maintain the sorted order.
 *
 * 🧠 Approach / Algorithm:
 * - Use Binary Search since the array is already sorted.
 * - Initialize two pointers: left (l) and right (r).
 * - While l <= r:
 *   - Compute the middle index.
 *   - If nums[mid] is greater than the target, search the left half.
 *   - If nums[mid] is less than the target, search the right half.
 *   - If nums[mid] equals the target, return mid.
 * - If the loop ends without finding the target,
 *   the left pointer (l) will represent the correct insert position.
 *
 * Time Complexity: O(log n)
 *   - n = number of elements in the array.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Works when the target is smaller than all elements (returns 0).
 * - Works when the target is larger than all elements (returns nums.length).
 * - Assumes all elements in the array are distinct.
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }
}
