/*
 * LeetCode 290. Word Pattern
 * Difficulty: Easy
 *
 * Problem Statement:
 * - Given a pattern string and a string s, determine if s follows the same pattern.
 * - Each character in pattern should map to exactly one word in s, and vice versa.
 * - No two characters may map to the same word, and no two words may map to the same character.
 *
 * 🧠 Approach / Algorithm:
 * - Split the input string s into an array of words.
 * - If the number of words does not match the length of the pattern, return false.
 * - Use two HashMaps to maintain a bijection:
 *   - One map from pattern character to word.
 *   - Another map from word to pattern character.
 * - Iterate through the pattern and words simultaneously:
 *   - If the character already has a mapped word, check for consistency.
 *   - If the character is not mapped, ensure the word is not already mapped
 *     to another character.
 *   - Store the new mappings in both maps.
 * - If all mappings are consistent, return true.
 *
 * Time Complexity: O(n)
 *   - n = number of characters in the pattern.
 *
 * Space Complexity: O(n)
 *   - Extra space is used for the two HashMaps.
 *
 * Important Details / Edge Cases:
 * - Ensures a one-to-one (bijective) mapping between characters and words.
 * - Returns false when pattern length and word count do not match.
 * - Handles repeated characters and repeated words correctly.
 */

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length)
            return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }
            } else {
                if (wordToChar.containsKey(word)) {
                    return false;
                }
                charToWord.put(ch, word);
                wordToChar.put(word, ch);
            }
        }
        return true;
    }
}
