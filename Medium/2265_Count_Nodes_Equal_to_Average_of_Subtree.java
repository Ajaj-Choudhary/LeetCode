/*
 * LeetCode 2265. Count Nodes Equal to Average of Subtree
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given the root of a binary tree, return the number of nodes where the
 *   node's value is equal to the average of the values in its subtree.
 * - The average is the sum of all node values in the subtree divided by
 *   the number of nodes, rounded down to the nearest integer.
 * - A subtree consists of a node and all of its descendants.
 *
 * Constraints:
 *
 * - The number of nodes in the tree is in the range [1, 1000].
 * - 0 <= Node.val <= 1000
 *
 * Key Observation:
 *
 * - Use DFS to calculate the sum and count of nodes in each subtree.
 * - For every node, compare sum / count with the node's value.
 * - Return the subtree's sum and count to its parent so the calculation
 *   can be performed in a bottom-up manner.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {
    private int result = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;

        if (sum / count == node.val) {
            result++;
        }

        return new int[] { sum, count };
    }
}