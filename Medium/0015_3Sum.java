/*
 * LeetCode 15. 3Sum
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given an integer array nums, return all triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, j != k, and nums[i] + nums[j] + nums[k] == 0.
 * - The solution set must not contain duplicate triplets.
 *
 * Constraints:
 *
 * - 3 <= nums.length <= 3000
 * - -10^5 <= nums[i] <= 10^5
 *
 * Key Observation:
 *
 * - Sort the array and fix one element while using two pointers to find the remaining two elements whose sum completes the triplet.
 * - Skip duplicate values for the fixed element and both pointers to ensure that the result contains no duplicate triplets.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(log n) to O(n) depending on the sorting implementation
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}