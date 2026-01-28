/*
 * LeetCode 28. Find the Index of the First Occurrence in a String
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given two strings haystack and needle,
 *   return the index of the first occurrence of needle in haystack.
 * - If needle is not part of haystack, return -1.
 *
 * 🧠 Approach / Algorithm:
 * - Use a brute-force sliding window approach.
 * - Let n be the length of haystack and m be the length of needle.
 * - Iterate over haystack from index 0 to (n - m):
 *   - For each starting index, compare characters of haystack
 *     with needle one by one.
 *   - Continue comparison while characters match.
 *   - If all m characters match, return the current index.
 * - If no match is found after full traversal, return -1.
 *
 * Time Complexity: O(n × m)
 *   - n = length of haystack
 *   - m = length of needle
 *
 * Space Complexity: O(1)
 *   - Uses constant extra space.
 *
 * Important Details / Edge Cases:
 * - Handles cases where needle is longer than haystack.
 * - Works correctly when needle is an empty string.
 * - Returns the first occurrence only.
 */

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        int l = 0;
        while (l < n - m + 1) {
            int check = 0;
            while (check < m && haystack.charAt(l + check) == needle.charAt(check)) {
                check++;
            }
            if (check == m) {
                return l;
            }
            l++;
        }
        return -1;
    }
}
