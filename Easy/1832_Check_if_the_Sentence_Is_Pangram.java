/*
 * LeetCode 1832. Check if the Sentence Is Pangram
 * Difficulty: Easy
 *
 * Problem Statement:
 *
 * - A pangram is a sentence where every letter of the English alphabet
 *   appears at least once.
 * - Given a string sentence containing only lowercase English letters,
 *   return true if sentence is a pangram, otherwise return false.
 *
 * Constraints:
 *
 * - 1 <= sentence.length <= 1000
 * - sentence consists of lowercase English letters.
 *
 * Key Observation:
 *
 * - Use a frequency array of size 26 to track which letters appear.
 * - Count each distinct letter only once.
 * - The sentence is a pangram if all 26 letters are present.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] hash = new int[26];
        int count = 0;

        for (char ch : sentence.toCharArray()) {
            int index = ch - 'a';

            if (hash[index] == 0) {
                hash[index]++;
                count++;
            }
        }

        return count == 26;
    }
}