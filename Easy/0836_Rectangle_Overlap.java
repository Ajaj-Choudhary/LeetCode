/*
 * LeetCode 836. Rectangle Overlap
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - Given two axis-aligned rectangles represented by [x1, y1, x2, y2].
 * - Return true if the rectangles have a positive-area intersection.
 * - Rectangles that only touch at an edge or corner do not overlap.
 *
 * Constraints:
 *
 * - rec1.length == 4
 * - rec2.length == 4
 * - -10^9 <= rec1[i], rec2[i] <= 10^9
 * - rec1 and rec2 represent valid rectangles with non-zero area.
 *
 * Key Observation:
 *
 * - The rectangles must overlap in both the x-axis and y-axis.
 * - Check whether their horizontal ranges and vertical ranges intersect
 *   with positive length.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean xOverlap = rec1[0] < rec2[2] && rec2[0] < rec1[2];
        boolean yOverlap = rec1[1] < rec2[3] && rec2[1] < rec1[3];

        return xOverlap && yOverlap;
    }
}