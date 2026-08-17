/*
 * LeetCode 3512. Minimum Operations to Make Array Sum Divisible by K
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - You are given an integer array nums and an integer k.
 * - In one operation, select an index i and replace nums[i] with nums[i] - 1.
 * - Return the minimum number of operations required to make the sum of the array divisible by k.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 1000
 * - 1 <= nums[i] <= 1000
 * - 1 <= k <= 100
 *
 * Key Observation:
 *
 * - Each operation decreases the total sum by exactly 1.
 * - Therefore, the minimum number of operations required is the remainder of the total sum when divided by k.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        return sum % k;
    }
}