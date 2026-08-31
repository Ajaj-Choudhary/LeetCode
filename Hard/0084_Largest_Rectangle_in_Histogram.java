/*
 * LeetCode 84. Largest Rectangle in Histogram
 * Difficulty: Hard
 *
 * Problem Statement:
 *
 * - Given an array of integers heights representing the histogram's bar heights.
 * - The width of each bar is 1.
 * - Return the area of the largest rectangle in the histogram.
 *
 * Constraints:
 *
 * - 1 <= heights.length <= 10^5
 * - 0 <= heights[i] <= 10^4
 *
 * Key Observation:
 *
 * - Use a monotonic stack to find the first smaller bar on the right for each bar.
 * - When a smaller bar is encountered, calculate the maximum rectangle using the popped bar as the height and the current stack boundary to determine its width.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }

        return maxArea;
    }
}