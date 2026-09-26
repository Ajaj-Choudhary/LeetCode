/*
 * LeetCode 1807. Evaluate the Bracket Pairs of a String
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 * - Given a string s containing bracket pairs with non-empty keys.
 * - Replace each known key with its corresponding value.
 * - Replace unknown keys with "?" and return the resulting string.
 *
 * Constraints:
 *
 * - 1 <= s.length <= 10^5
 * - 0 <= knowledge.length <= 10^5
 * - knowledge[i].length == 2
 * - 1 <= key_i.length, value_i.length <= 10
 * - s consists of lowercase English letters and round brackets.
 * - Every open bracket has a corresponding close bracket.
 * - There are no nested bracket pairs.
 * - key_i and value_i consist of lowercase English letters.
 *
 * Key Observation:
 *
 * - Store all key-value pairs in a HashMap for O(1) average lookup.
 * - Traverse s and use the next ')' to extract each bracketed key.
 * - Replace the key with its mapped value or "?" if it is unknown.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(m)
 */

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        int i = 0, n = s.length();

        while (i < n) {
            if (s.charAt(i) == '(') {
                int j = s.indexOf(')', i);
                String key = s.substring(i + 1, j);
                result.append(map.getOrDefault(key, "?"));
                i = j + 1;
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }

        return result.toString();
    }
}