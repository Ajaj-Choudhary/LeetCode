/*
 * LeetCode 438. Find All Anagrams in a String
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given two strings s and p, find all start indices of p's anagrams in s.
 * - An anagram contains the same characters with the same frequencies.
 * - Return the indices in any order.
 *
 * Constraints:
 *
 * - 1 <= s.length, p.length <= 3 * 10^4
 * - s and p consist of lowercase English letters.
 *
 * Key Observation:
 *
 * - Maintain character frequencies for p and the current window of size p.length().
 * - Compare the two frequency arrays to determine whether the current window is an anagram.
 * - Slide the window by removing the outgoing character and adding the incoming character.
 *
 * Time Complexity: O(26 * n) = O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int n = s.length();
        int k = p.length();

        if (k > n) {
            return result;
        }

        int[] sFreq = new int[26];
        int[] pFreq = new int[26];

        for (char ch : p.toCharArray()) {
            pFreq[ch - 'a']++;
        }

        for (int i = 0; i < p.length(); i++) {
            sFreq[s.charAt(i) - 'a']++;
        }

        if (checkAnagram(sFreq, pFreq)) {
            result.add(0);
        }

        for (int i = k; i < n; i++) {
            sFreq[s.charAt(i - k) - 'a']--;
            sFreq[s.charAt(i) - 'a']++;

            if (checkAnagram(sFreq, pFreq)) {
                result.add(i - k + 1);
            }
        }

        return result;
    }

    private boolean checkAnagram(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}