/*
 * LeetCode 3634. Minimum Removals to Balance Array
 * Difficulty: Medium
 *
 * Problem Statement:
 * - You are given an integer array nums and an integer k.
 * - An array is considered balanced if the value of its maximum element
 *   is at most k times the minimum element.
 * - You may remove any number of elements from nums without making it empty.
 * - Return the minimum number of elements to remove so that the remaining
 *   array is balanced.
 *
 * Approach / Algorithm:
 * - Sort the array to make it easier to compare minimum and maximum values.
 * - Use a sliding window technique with two pointers:
 *   - The left pointer represents the minimum element of the window.
 *   - The right pointer represents the maximum element of the window.
 * - Expand the window by moving the right pointer.
 * - While the balance condition is violated
 *     (nums[right] > nums[left] * k),
 *   move the left pointer to shrink the window.
 * - Track the maximum size of a valid (balanced) window.
 * - The minimum removals required equals:
 *     total elements - maximum valid window size.
 *
 * Time Complexity: O(n log n)
 *   - Sorting takes O(n log n), sliding window takes O(n).
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space apart from sorting.
 *
 * Important Details / Edge Cases:
 * - Casting to long prevents integer overflow during multiplication.
 * - An array of size 1 is always balanced.
 * - The array is guaranteed to remain non-empty after removals.
 */

class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int left = 0;
        int maxKeep = 1;

        for (int right = 0; right < n; right++) {
            while ((long) nums[right] > (long) nums[left] * k) {
                left++;
            }
            maxKeep = Math.max(maxKeep, right - left + 1);
        }

        return n - maxKeep;
    }
}

