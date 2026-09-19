/*
 * LeetCode 1423. Maximum Points You Can Obtain from Cards
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given an integer array cardPoints where cardPoints[i] represents the
 *   points of the ith card.
 * - You can take exactly k cards from either the beginning or the end
 *   of the array.
 * - Return the maximum score you can obtain.
 *
 * Constraints:
 *
 * - 1 <= cardPoints.length <= 10^5
 * - 1 <= cardPoints[i] <= 10^4
 * - 1 <= k <= cardPoints.length
 *
 * Key Observation:
 *
 * - Initially take all k cards from the left side.
 * - Gradually replace cards taken from the left with cards from the right.
 * - For every possible split of the k cards between the left and right,
 *   calculate the resulting score and keep the maximum.
 *
 * Time Complexity: O(k)
 * Space Complexity: O(1)
 */

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int points = 0;

        for (int i = 0; i < k; i++) {
            points += cardPoints[i];
        }

        int maxPoints = points;

        for (int i = 0; i < k; i++) {
            points -= cardPoints[k - i - 1];
            points += cardPoints[cardPoints.length - i - 1];

            maxPoints = Math.max(maxPoints, points);
        }

        return maxPoints;
    }
}