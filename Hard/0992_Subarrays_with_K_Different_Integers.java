/*
 * LeetCode 992. Subarrays with K Different Integers
 * Difficulty: Hard
 *
 * Problem Statement:
 *
 * - Given an integer array nums and an integer k, return the number of
 *   good subarrays.
 * - A good array contains exactly k different integers.
 * - A subarray is a contiguous part of an array.
 *
 * Constraints:
 *
 * - 1 <= nums.length <= 2 * 10^4
 * - 1 <= nums[i], k <= nums.length
 *
 * Key Observation:
 *
 * - Count subarrays with exactly k distinct integers using:
 *   atMostKDistinct(k) - atMostKDistinct(k - 1).
 * - atMostKDistinct(k) counts all subarrays containing at most k distinct
 *   integers using a sliding window and frequency map.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }

    private int atMostKDistinct(int[] nums, int k) {
        if (k < 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            map.merge(nums[right], 1, Integer::sum);

            while (map.size() > k) {
                int newCount = map.merge(nums[left], -1, Integer::sum);
                if (newCount == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}