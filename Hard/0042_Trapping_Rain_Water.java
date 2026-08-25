/*
 * LeetCode 42. Trapping Rain Water
 * Difficulty: Hard
 *
 * Problem Statement:
 *
 * - Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Constraints:
 *
 * - n == height.length
 * - 1 <= n <= 2 * 10^4
 * - 0 <= height[i] <= 10^5
 *
 * Key Observation:
 *
 * - Use two pointers from both ends while maintaining the maximum height seen from the left and right.
 * - Process the side with the smaller maximum boundary because that side determines the amount of water that can be trapped.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int total = 0;

        while (left <= right) {
            if (leftMax <= rightMax) {
                if (leftMax > height[left]) {
                    total += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }

                left++;
            } else {
                if (rightMax > height[right]) {
                    total += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }

                right--;
            }
        }

        return total;
    }
}