/*
 * LeetCode 645. Set Mismatch
 * Difficulty: Easy
 *
 * Problem Statement:
 * - You are given an array nums representing numbers from 1 to n.
 * - One number is duplicated, and one number is missing.
 * - Return an array containing the duplicate number and the missing number.
 *
 * 🧠 Approach / Algorithm:
 * - Use a boolean array `seen` of size n to track visited numbers.
 * - Traverse the nums array:
 *   - If a number has already been seen, it is the duplicate.
 *   - Otherwise, mark the number as seen.
 * - After traversal, iterate through the `seen` array:
 *   - The index that remains false represents the missing number.
 * - Return the duplicate and missing numbers.
 *
 * Time Complexity: O(n)
 *   - n = number of elements in the array.
 *
 * Space Complexity: O(n)
 *   - Extra space is used for the boolean array.
 *
 * Important Details / Edge Cases:
 * - Assumes exactly one duplicate and one missing number.
 * - Uses index mapping (num - 1) for correct positioning.
 * - Stops early once the missing number is found.
 */

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = 0;
        int miss = 0;
        boolean[] seen = new boolean[n];

        for (int num : nums) {
            if (seen[num - 1]) {
                dup = num;
            } else {
                seen[num - 1] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                miss = i + 1;
                break;
            }
        }
        return new int[] { dup, miss };
    }
}
