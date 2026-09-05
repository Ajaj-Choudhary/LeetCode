/*
 * LeetCode 3898. Find the Degree of Each Vertex
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - Given an n x n adjacency matrix representing an undirected graph.
 * - matrix[i][j] = 1 indicates an edge between vertices i and j, while
 *   matrix[i][j] = 0 indicates no edge.
 * - Return an array where ans[i] represents the degree of vertex i.
 *
 * Constraints:
 *
 * - 1 <= n == matrix.length == matrix[i].length <= 100
 * - matrix[i][i] == 0
 * - matrix[i][j] is either 0 or 1
 * - matrix[i][j] == matrix[j][i]
 *
 * Key Observation:
 *
 * - The degree of a vertex is the number of edges connected to it.
 * - Since each row represents the connections of one vertex, summing the
 *   values in each row gives its degree.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class Solution {
    public int[] findDegrees(int[][] matrix) {
        int[] result = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int num : matrix[i]) {
                result[i] += num;
            }
        }

        return result;
    }
}