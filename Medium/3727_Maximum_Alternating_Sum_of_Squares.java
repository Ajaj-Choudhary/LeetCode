/*
 * LeetCode 3727. Maximum Alternating Sum of Squares
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given an integer array nums, rearrange its elements in any order.
 * - The alternating score is the sum of squares at even indices minus the sum of squares at odd indices.
 * - Return the maximum possible alternating score.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 *
 * Key Observation:
 *
 * - Square every element and sort the squared values in ascending order.
 * - Subtract the smallest n / 2 squared values and add the remaining values to maximize the score.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];

        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        int subtractCount = n / 2;
        long score = 0;

        for (int i = 0; i < n; i++) {
            if (i < subtractCount) {
                score -= squares[i];
            } else {
                score += squares[i];
            }
        }

        return score;
    }
}