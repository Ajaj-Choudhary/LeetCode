/*
 * LeetCode 189. Rotate Array
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Given an integer array nums, rotate the array to the right by k steps.
 * - k is non-negative.
 *
 * Approach / Algorithm:
 * - Use the array reversal technique.
 * - First, reduce k using modulo operation: k = k % n.
 * - Reverse the entire array.
 * - Reverse the first k elements.
 * - Reverse the remaining n - k elements.
 * - This achieves the rotation in-place.
 *
 * Time Complexity: O(n)
 *   - Each element is swapped a constant number of times.
 *
 * Space Complexity: O(1)
 *   - Rotation is done in-place without extra memory.
 *
 * Important Details / Edge Cases:
 * - Handles cases where k >= array length using modulo.
 * - Works correctly for negative and positive numbers.
 * - No additional array is used.
 */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

