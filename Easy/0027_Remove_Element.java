/*
 * LeetCode 27. Remove Element
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given an array nums and an integer val,
 *   remove all occurrences of val in-place.
 * - The relative order of the elements may be changed.
 * - Return the number of elements not equal to val.
 *
 * 🧠 Approach / Algorithm:
 * - Use a two-pointer approach.
 * - One pointer (k) tracks the position to place the next valid element.
 * - Traverse the array using index i:
 *   - If nums[i] is not equal to val,
 *     assign nums[k] = nums[i] and increment k.
 * - After traversal, the first k elements of the array
 *   will contain the elements not equal to val.
 * - Return k as the count of remaining elements.
 *
 * Time Complexity: O(n)
 *   - n = number of elements in the array.
 *
 * Space Complexity: O(1)
 *   - In-place modification with constant extra space.
 *
 * Important Details / Edge Cases:
 * - Works when val does not exist in the array.
 * - Handles cases where all elements are equal to val.
 * - Order of remaining elements is not guaranteed to be preserved.
 */

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
