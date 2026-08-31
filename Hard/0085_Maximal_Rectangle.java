/*
 * LeetCode 85. Maximal Rectangle
 * Difficulty: Hard
 *
 * Problem Statement:
 *
 * - Given a rows x cols binary matrix filled with 0's and 1's.
 * - Find the largest rectangle containing only 1's.
 * - Return its area.
 *
 * Constraints:
 *
 * - 1 <= rows, cols <= 200
 * - matrix[i][j] is '0' or '1'.
 *
 * Key Observation:
 *
 * - Treat each row as the base of a histogram by maintaining the consecutive height of 1's in each column.
 * - For every row, find the largest rectangle in the resulting histogram using a monotonic stack.
 *
 * Time Complexity: O(rows * cols)
 * Space Complexity: O(cols)
 */

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (char[] row : matrix) {
            for (int j = 0; j < cols; j++) {
                heights[j] = (row[j] == '1') ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
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