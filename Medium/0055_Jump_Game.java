/*
 * LeetCode 55. Jump Game
 * Difficulty: Medium
 *
 * Problem Statement:
 * - You are given an integer array nums.
 * - You start at the first index, and each element represents the maximum jump
 *   length from that position.
 * - Return true if you can reach the last index, otherwise return false.
 *
 * Approach / Algorithm:
 * - Use a greedy approach.
 * - Maintain a variable maxReach that represents the farthest index
 *   that can be reached so far.
 * - Traverse the array:
 *   - If the current index is greater than maxReach, it means this index
 *     is unreachable, so return false.
 *   - Update maxReach as the maximum of its current value and i + nums[i].
 *   - If maxReach reaches or exceeds the last index, return true early.
 * - If the loop completes, return true.
 *
 * Time Complexity: O(n)
 *   - n = length of the array.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Handles arrays of length 1 correctly.
 * - Early exit improves performance when the end is reachable.
 * - Greedy strategy ensures optimal decisions at each step.
 */

class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            if(maxReach >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}

