/*
 * LeetCode 26. Remove Duplicates from Sorted Array
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given a sorted array nums, remove the duplicates in-place
 *   such that each unique element appears only once.
 * - The relative order of the elements should be kept the same.
 * - Return the number of unique elements.
 *
 * 🧠 Approach / Algorithm:
 * - Use the two-pointer technique.
 * - One pointer (k) keeps track of the index of the last unique element.
 * - Start iterating from the second element of the array.
 * - For each element:
 *   - If it is different from the previous element,
 *     increment k and place the current element at nums[k].
 * - After the loop, the first (k + 1) elements of the array
 *   will contain the unique values in sorted order.
 * - Return k + 1 as the count of unique elements.
 *
 * Time Complexity: O(n)
 *   - n = number of elements in the array.
 *
 * Space Complexity: O(1)
 *   - No extra space is used; modification is done in-place.
 *
 * Important Details / Edge Cases:
 * - Handles empty arrays by returning 0.
 * - Works because the input array is already sorted.
 * - Only the first (k + 1) elements are guaranteed to be valid.
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                k++;
                nums[k] = nums[i];
            }
        }
        return k + 1;
    }
}
