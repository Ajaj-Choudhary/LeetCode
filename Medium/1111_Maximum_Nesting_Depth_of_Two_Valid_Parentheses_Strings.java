/*
 * LeetCode 1111. Maximum Nesting Depth of Two Valid Parentheses Strings
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given a valid parentheses string seq, split it into two disjoint subsequences A and B.
 * - Both A and B must be valid parentheses strings.
 * - Return an array where answer[i] indicates whether seq[i] belongs to A or B.
 *
 * Constraints:
 *
 * - 1 <= seq.length <= 10^4
 * - seq consists only of '(' and ')'.
 * - seq is a valid parentheses string.
 *
 * Key Observation:
 *
 * - Track the current nesting depth using open.
 * - Assign each parenthesis to one of the two groups based on the parity of the current depth.
 * - This distributes nested parentheses between the two subsequences.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int open = 0;

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                open++;
                answer[i] = open % 2;
            } else {
                answer[i] = open % 2;
                open--;
            }
        }

        return answer;
    }
}