/*
 * LeetCode 3550. Smallest Index With Digit Sum Equal to Index
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - Given an integer array nums, return the smallest index i such that the
 *   sum of the digits of nums[i] is equal to i.
 * - Return -1 if no such index exists.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 100
 * - 0 <= nums[i] <= 1000
 *
 * Key Observation:
 *
 * - Check each index from left to right and calculate the digit sum of nums[i].
 * - The first index where the digit sum equals the index is the answer.
 *
 * Time Complexity: O(n * d)
 * Space Complexity: O(1)
 */

class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (digitSum(nums[i]) == i) {
                return i;
            }
        }

        return -1;
    }

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}