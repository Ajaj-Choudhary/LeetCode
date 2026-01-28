/*
 * LeetCode 485. Max Consecutive Ones
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given a binary array nums, return the maximum number of consecutive 1s in the array.
 *
 * 🧠 Approach / Algorithm:
 * - Traverse the array once while keeping track of consecutive 1s.
 * - Use two variables:
 *   - currentCount to count the current streak of 1s.
 *   - maxCount to store the maximum streak found so far.
 * - For each element in the array:
 *   - If the element is 1, increment currentCount.
 *   - If the element is 0, reset currentCount to 0.
 *   - Update maxCount with the maximum of maxCount and currentCount.
 * - After completing the traversal, return maxCount.
 *
 * Time Complexity: O(n)
 *   - n = number of elements in the array.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Works correctly when the array contains all 1s or all 0s.
 * - Handles empty or single-element arrays.
 * - No modification of the input array is required.
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                currentCount = 0;
            }
            maxCount = Math.max(maxCount, currentCount);
        }
        return maxCount;
    }
}
