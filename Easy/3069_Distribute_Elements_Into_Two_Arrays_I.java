/*
 * LeetCode 3069. Distribute Elements Into Two Arrays I
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - You are given a 1-indexed array of distinct integers nums.
 * - Distribute all elements of nums between two arrays arr1 and arr2 according to the given operation rules.
 * - Return the array result formed by concatenating arr1 and arr2.
 *
 * Constraints:
 *
 * - 3 <= nums.length <= 50
 * - 1 <= nums[i] <= 100
 * - All elements in nums are distinct.
 *
 * Key Observation:
 *
 * - Keep track of the last element of arr1 and arr2 and append the current element to the array whose last element is greater.
 * - Store both arrays separately and concatenate them after all elements have been distributed.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int left = 1;
        int right = 1;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        arr1[0] = nums[0];
        arr2[0] = nums[1];

        for (int i = 2; i < n; i++) {
            if (arr1[left - 1] > arr2[right - 1]) {
                arr1[left++] = nums[i];
            } else {
                arr2[right++] = nums[i];
            }
        }

        System.arraycopy(arr1, 0, res, 0, left);
        System.arraycopy(arr2, 0, res, left, right);

        return res;
    }
}