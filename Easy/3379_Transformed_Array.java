/*
 * LeetCode 3379. Transformed Array
 * Difficulty: Easy
 *
 * Problem Statement:
 * - You are given an integer array nums that represents a circular array.
 * - Create a new array result of the same size following these rules:
 *   - If nums[i] > 0, move nums[i] steps to the right from index i.
 *   - If nums[i] < 0, move abs(nums[i]) steps to the left from index i.
 *   - If nums[i] == 0, set result[i] = nums[i].
 * - Since the array is circular, movement wraps around both ends.
 * - Set result[i] to the value of the index where you land.
 *
 * Approach / Algorithm:
 * - Traverse each index i of the array.
 * - Compute the new index using circular movement:
 *     index = (i + nums[i] % n + n) % n
 * - Assign result[i] = nums[index].
 * - Return the result array.
 *
 * Time Complexity: O(n)
 *   - Each element is processed once.
 *
 * Space Complexity: O(n)
 *   - Uses a new result array.
 *
 * Important Details / Edge Cases:
 * - Handles negative movements using modulo arithmetic.
 * - Extra +n ensures index remains non-negative.
 * - Circular wrapping is handled using modulo.
 */

class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            int index = (i + nums[i] % n + n) % n;
            result[i] = nums[index];
        }

        return result;
    }
}

