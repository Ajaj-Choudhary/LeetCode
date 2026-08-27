/*
 * LeetCode 3720. Lexicographically Smallest Permutation Greater Than Target
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - You are given two strings s and target, both having length n and consisting of lowercase English letters.
 * - Return the lexicographically smallest permutation of s that is strictly greater than target.
 * - If no permutation of s is lexicographically strictly greater than target, return an empty string.
 *
 * Constraints:
 *
 * - 1 <= s.length == target.length <= 300
 * - s and target consist of only lowercase English letters.
 *
 * Key Observation:
 *
 * - Track the available character frequencies while matching target from left to right and record the latest position where a larger character can replace the target character.
 * - Reconstruct the answer using the matching prefix, the smallest possible larger character at that position, and all remaining characters in sorted order.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] base = new int[26];
        for (char ch : s.toCharArray()) {
            base[ch - 'a']++;
        }

        int[] cnt = base.clone();
        int bestI = -1;
        int i = 0;

        while (i < n) {
            int t = target.charAt(i) - 'a';

            boolean checkBreak = false;
            for (int c = t + 1; c < 26; c++) {
                if (cnt[c] > 0) {
                    checkBreak = true;
                    break;
                }
            }

            if (checkBreak) {
                bestI = i;
            }

            if (cnt[t] > 0) {
                cnt[t]--;
                i++;
            } else {
                break;
            }
        }

        if (bestI == -1) {
            return "";
        }

        int[] cnt2 = base.clone();
        StringBuilder result = new StringBuilder();

        for (int k = 0; k < bestI; k++) {
            int t = target.charAt(k) - 'a';
            cnt2[t]--;
            result.append(target.charAt(k));
        }

        int t = target.charAt(bestI) - 'a';
        for (int c = t + 1; c < 26; c++) {
            if (cnt2[c] > 0) {
                result.append((char) (c + 'a'));
                cnt2[c]--;
                break;
            }
        }

        for (int c = 0; c < 26; c++) {
            while (cnt2[c] > 0) {
                result.append((char) (c + 'a'));
                cnt2[c]--;
            }
        }

        return result.toString();
    }
}