/*
 * LeetCode 304. Range Sum Query 2D - Immutable
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given a 2D matrix, calculate the sum of elements inside a specified rectangle.
 * - Implement the NumMatrix class with a constructor and sumRegion method.
 * - The sumRegion method must work in O(1) time.
 *
 * Constraints:
 *
 * - 1 <= m, n <= 200
 * - -10^4 <= matrix[i][j] <= 10^4
 * - 0 <= row1 <= row2 < m
 * - 0 <= col1 <= col2 < n
 * - At most 10^4 calls will be made to sumRegion.
 *
 * Key Observation:
 *
 * - Build a 2D prefix sum matrix where each cell stores the sum of the rectangle from the origin.
 * - Use inclusion-exclusion to calculate any rectangular region in O(1) time.
 *
 * Time Complexity: O(m * n) for construction, O(1) per sumRegion query
 * Space Complexity: O(m * n)
 */

class NumMatrix {
    int[][] matrixSum;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        matrixSum = new int[rows + 1][cols + 1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixSum[i + 1][j + 1] = matrixSum[i + 1][j] + matrix[i][j];
            }
        }

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                matrixSum[j + 1][i + 1] += matrixSum[j][i + 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrixSum[row2 + 1][col2 + 1]
                - (matrixSum[row1][col2 + 1] + matrixSum[row2 + 1][col1] - matrixSum[row1][col1]);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1, col1, row2, col2);
 */