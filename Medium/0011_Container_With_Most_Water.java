/*
 * LeetCode 11. Container With Most Water
 * Difficulty: Medium
 *
 * Problem Statement:
 * - You are given an integer array height of length n.
 * - There are n vertical lines drawn such that the two endpoints of the i-th line
 *   are (i, 0) and (i, height[i]).
 * - Find two lines that together with the x-axis form a container
 *   such that the container contains the most water.
 * - Return the maximum amount of water a container can store.
 *
 * Approach / Algorithm:
 * - Use the two-pointer technique.
 * - Initialize one pointer at the beginning (left) and one at the end (right).
 * - The width of the container is (right - left).
 * - The height of the container is the minimum of height[left] and height[right].
 * - Calculate the current area and update the maximum area.
 * - Move the pointer pointing to the smaller height inward to try
 *   and find a better container.
 * - Continue until the two pointers meet.
 *
 * Time Complexity: O(n)
 *   - n = number of elements in the array.
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - The container cannot be slanted.
 * - Works efficiently for large input sizes.
 * - Always ensures left < right during processing.
 */

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currArea = Math.min(height[left], height[right]) * width;
            maxArea = Math.max(maxArea, currArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

