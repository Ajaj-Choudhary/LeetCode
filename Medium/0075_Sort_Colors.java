/*
 * LeetCode 75. Sort Colors
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Given an array nums with n objects colored red, white, or blue,
 *   sort them in-place so that objects of the same color are adjacent.
 * - The colors are represented as:
 *      0 -> Red
 *      1 -> White
 *      2 -> Blue
 * - You must not use the built-in sort function.
 *
 * Approach / Algorithm:
 * - Use the Dutch National Flag Algorithm.
 * - Maintain three pointers:
 *      low  -> boundary for 0s
 *      mid  -> current element
 *      high -> boundary for 2s
 * - Traverse the array once:
 *      If nums[mid] == 0:
 *          swap(nums[low], nums[mid]), low++, mid++
 *      If nums[mid] == 1:
 *          mid++
 *      If nums[mid] == 2:
 *          swap(nums[mid], nums[high]), high--
 *
 * Time Complexity: O(n)
 * - Single pass through the array.
 *
 * Space Complexity: O(1)
 * - In-place sorting.
 */

class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, low, mid);
                low++;
                mid++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

