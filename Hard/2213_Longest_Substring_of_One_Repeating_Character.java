/*
 * LeetCode 2213. Longest Substring of One Repeating Character
 * Difficulty: Hard
 *
 * Problem Statement:
 *
 * - You are given a 0-indexed string s, a string queryCharacters, and an array queryIndices.
 * - Each query updates the character in s at the specified index.
 * - Return the length of the longest substring consisting of only one repeating character after each query.
 *
 * Constraints:
 *
 * - 1 <= s.length <= 10^5
 * - s consists of lowercase English letters.
 * - 1 <= queryCharacters.length <= 10^5
 * - queryCharacters consists of lowercase English letters.
 * - queryCharacters.length == queryIndices.length
 * - 0 <= queryIndices[i] < s.length
 *
 * Key Observation:
 *
 * - Use a segment tree to maintain the longest repeating-character substring for each segment.
 * - Each node stores its prefix, suffix, longest repeating length, segment length, and boundary characters so segments can be merged after an update.
 *
 * Time Complexity: O((n + q) log n)
 * Space Complexity: O(n)
 */

class Solution {
    private int[] prefix;
    private int[] suffix;
    private int[] longest;
    private int[] length;
    private char[] leftChar;
    private char[] rightChar;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {
        int n = s.length();

        prefix = new int[4 * n];
        suffix = new int[4 * n];
        longest = new int[4 * n];
        length = new int[4 * n];
        leftChar = new char[4 * n];
        rightChar = new char[4 * n];

        char[] chars = s.toCharArray();

        build(1, 0, n - 1, chars);

        int[] answer = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            update(1, 0, n - 1, index, ch);

            answer[i] = longest[1];
        }

        return answer;
    }

    private void build(int node, int left, int right, char[] chars) {
        if (left == right) {
            length[node] = 1;
            prefix[node] = 1;
            suffix[node] = 1;
            longest[node] = 1;
            leftChar[node] = chars[left];
            rightChar[node] = chars[left];
            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid, chars);
        build(node * 2 + 1, mid + 1, right, chars);

        merge(node);
    }

    private void update(int node, int left, int right, int index, char ch) {
        if (left == right) {
            leftChar[node] = ch;
            rightChar[node] = ch;
            prefix[node] = 1;
            suffix[node] = 1;
            longest[node] = 1;
            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, right, index, ch);
        }

        merge(node);
    }

    private void merge(int node) {
        int leftNode = node * 2;
        int rightNode = node * 2 + 1;

        length[node] = length[leftNode] + length[rightNode];

        leftChar[node] = leftChar[leftNode];
        rightChar[node] = rightChar[rightNode];

        prefix[node] = prefix[leftNode];
        suffix[node] = suffix[rightNode];

        longest[node] = Math.max(longest[leftNode], longest[rightNode]);

        if (rightChar[leftNode] == leftChar[rightNode]) {
            longest[node] = Math.max(
                    longest[node],
                    suffix[leftNode] + prefix[rightNode]);

            if (prefix[leftNode] == length[leftNode]) {
                prefix[node] += prefix[rightNode];
            }

            if (suffix[rightNode] == length[rightNode]) {
                suffix[node] += suffix[leftNode];
            }
        }
    }
}