/*
 * LeetCode 799. Champagne Tower
 * Difficulty: Medium
 *
 * Problem Statement:
 * - Glasses are stacked in a pyramid.
 * - Each glass holds at most 1 cup of champagne.
 * - Any overflow from a glass spills equally into the two glasses below it.
 * - Given poured cups of champagne, determine how full a specific glass is.
 *
 * Input:
 * - poured: total cups of champagne poured at the top
 * - query_row: row index (0-based)
 * - query_glass: glass index in that row (0-based)
 *
 * Output:
 * - Return the amount of champagne in the specified glass (max 1.0).
 *
 * Approach / Algorithm (Dynamic Programming):
 * - Use a 2D DP array where dp[r][c] represents champagne in glass (r, c).
 * - Start by pouring all champagne into dp[0][0].
 * - For each glass:
 *     - If dp[r][c] > 1, calculate overflow.
 *     - Cap dp[r][c] to 1.
 *     - Distribute overflow equally to the two glasses below.
 * - Continue row by row until the query row is processed.
 *
 * Time Complexity:
 * - O(query_row × query_glass)
 *
 * Space Complexity:
 * - O(query_row × query_glass)
 *
 * Important Details / Edge Cases:
 * - Glass can never exceed 1 cup.
 * - Extra champagne at the bottom row is ignored.
 * - Uses double precision to maintain accuracy.
 */

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {

        double[][] dp = new double[query_row + 2][query_glass + 2];

        // Pour all champagne into the top glass
        dp[0][0] = poured;

        for (int r = 0; r <= query_row; r++) {
            for (int c = 0; c <= query_glass; c++) {

                if (dp[r][c] > 1.0) {
                    double overflow = dp[r][c] - 1.0;
                    dp[r][c] = 1.0;

                    dp[r + 1][c] += overflow / 2.0;
                    dp[r + 1][c + 1] += overflow / 2.0;
                }
            }
        }

        return dp[query_row][query_glass];
    }
}

