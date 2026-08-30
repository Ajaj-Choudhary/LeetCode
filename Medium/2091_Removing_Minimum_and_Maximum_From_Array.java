/*
 * LeetCode 2091. Removing Minimum and Maximum From Array
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - You are given a 0-indexed array of distinct integers nums.
 * - Remove both the minimum and maximum elements from the array.
 * - A deletion removes an element from either the front or the back of the array.
 * - Return the minimum number of deletions required to remove both the minimum and maximum elements.
 *
 * Constraints:
 *
 * - 2 <= nums.length <= 10^5
 * - -10^5 <= nums[i] <= 10^5
 * - The integers in nums are distinct.
 *
 * Key Observation:
 *
 * - Find the indices of the minimum and maximum elements, then consider the three possible ways to remove both.
 * - Compare removing both from the front, both from the back, and splitting the deletions between the front and back.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIndex])
                minIndex = i;
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }

        int low = Math.min(minIndex, maxIndex);
        int high = Math.max(minIndex, maxIndex);

        int both_from_front = high + 1;
        int both_from_back = n - low;
        int split = (low + 1) + (n - high);

        return Math.min(both_from_front, Math.min(both_from_back, split));
    }
}