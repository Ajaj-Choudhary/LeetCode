/*
 * LeetCode 1314. Matrix Block Sum
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given an m x n matrix mat and an integer k, calculate the block sum for every cell.
 * - For each cell (i, j), sum all elements within k distance in both row and column directions.
 * - Only valid matrix positions are included in the sum.
 *
 * Constraints:
 *
 * - m == mat.length
 * - n == mat[i].length
 * - 1 <= m, n, k <= 100
 * - 1 <= mat[i][j] <= 100
 *
 * Key Observation:
 *
 * - Build a 2D prefix sum matrix to calculate any rectangular region in O(1).
 * - For each cell, clamp the block boundaries to the matrix and use inclusion-exclusion.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i + 1][j + 1] = mat[i][j]
                        + prefix[i][j + 1]
                        + prefix[i + 1][j]
                        - prefix[i][j];
            }
        }

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k);
                int r2 = Math.min(i + k, m - 1);
                int c1 = Math.max(0, j - k);
                int c2 = Math.min(j + k, n - 1);

                answer[i][j] = prefix[r2 + 1][c2 + 1] - (prefix[r1][c2 + 1] + prefix[r2 + 1][c1] - prefix[r1][c1]);
            }
        }

        return answer;
    }
}