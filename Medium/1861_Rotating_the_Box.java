/*
 * LeetCode 1861. Rotating the Box
 * Difficulty: Medium
 *
 * Problem Statement:
 * - You are given an m x n matrix boxGrid representing a side-view of a box.
 * - Each cell can be:
 *     '#' : a stone
 *     '*' : a stationary obstacle
 *     '.' : empty space
 * - The box is rotated 90 degrees clockwise.
 * - After rotation, stones fall down due to gravity until blocked by:
 *     - an obstacle
 *     - another stone
 *     - the bottom of the box
 * - Obstacles do not move.
 *
 * Approach / Algorithm:
 * 1. First simulate gravity on each row:
 *    - Traverse from right to left.
 *    - Use a write pointer to place stones as far right as possible.
 *    - Reset the write pointer whenever an obstacle is found.
 *
 * 2. After gravity simulation:
 *    - Rotate the matrix 90° clockwise.
 *    - Map boxGrid[row][col] → result[col][m - 1 - row].
 *
 * Time Complexity: O(m * n)
 *   - Each cell is processed a constant number of times.
 *
 * Space Complexity: O(m * n)
 *   - A new matrix is created for the rotated result.
 *
 * Important Details / Edge Cases:
 * - Gravity is applied before rotation.
 * - Obstacles remain fixed during gravity simulation.
 * - Guaranteed constraints ensure stones always land safely.
 */

class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        for (int row = 0; row < m; row++) {
            int write = n - 1;

            for (int col = n - 1; col >= 0; col--) {
                char ch = boxGrid[row][col];
                if (ch == '*') {
                    write = col - 1;
                } else if (ch == '#') {
                    boxGrid[row][col] = '.';
                    boxGrid[row][write] = '#';
                    write--;
                }
            }
        }

        char[][] result = new char[n][m];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                result[col][m - 1 - row] = boxGrid[row][col];
            }
        }

        return result;
    }
}

