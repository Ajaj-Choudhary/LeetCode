/*
 * LeetCode 88. Merge Sorted Array
 * Difficulty: Easy
 *
 * Problem Statement:
 * - You are given two integer arrays nums1 and nums2, sorted in non-decreasing order.
 * - Integers m and n represent the number of valid elements in nums1 and nums2 respectively.
 * - Merge nums2 into nums1 as one sorted array.
 * - The final sorted array should be stored inside nums1.
 *
 * Approach / Algorithm:
 * - Use three pointers starting from the end:
 *   - i points to the last valid element in nums1 (m - 1).
 *   - j points to the last element in nums2 (n - 1).
 *   - k points to the last position in nums1 (m + n - 1).
 * - Compare elements from nums1 and nums2 from the back and place the larger one at index k.
 * - Decrement the corresponding pointers.
 * - After one array is exhausted, copy remaining elements of nums2 (if any) into nums1.
 *
 * Time Complexity: O(m + n)
 *   - Each element is visited once.
 *
 * Space Complexity: O(1)
 *   - Merging is done in-place without extra space.
 *
 * Important Details / Edge Cases:
 * - nums1 has enough space to hold all elements.
 * - If nums2 is empty, nums1 remains unchanged.
 * - If nums1 has no initial elements, nums2 is copied entirely.
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}

