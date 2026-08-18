/*
 * LeetCode 3471. Find the Largest Almost Missing Integer
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - You are given an integer array nums and an integer k.
 * - An integer x is almost missing from nums if x appears in exactly one subarray of size k within nums.
 * - Return the largest almost missing integer from nums. If no such integer exists, return -1.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 50
 * - 0 <= nums[i] <= 50
 * - 1 <= k <= nums.length
 *
 * Key Observation:
 *
 * - Count the frequency of each number in the entire array and handle the three cases k == n, k == 1, and 1 < k < n.
 * - When 1 < k < n, only the first and last elements can appear in exactly one subarray of size k, so only those two candidates need to be checked.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        int[] count = new int[51];

        for (int num : nums) {
            count[num]++;
        }

        if (k == n) {
            int ans = -1;

            for (int num : nums) {
                ans = Math.max(ans, num);
            }

            return ans;
        }

        if (k == 1) {
            int ans = -1;

            for (int num : nums) {
                if (count[num] == 1) {
                    ans = Math.max(ans, num);
                }
            }

            return ans;
        }

        int ans = -1;

        if (count[nums[0]] == 1) {
            ans = Math.max(ans, nums[0]);
        }

        if (count[nums[n - 1]] == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}