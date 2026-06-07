package Assignment.Day7;
/*
290. Word Pattern
Easy
Topics
premium lock icon
Companies
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.
 

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"

Output: true

Explanation:

The bijection can be established as:

'a' maps to "dog".
'b' maps to "cat".
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"

Output: false

Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"

Output: false
*/
import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if (pattern.length() != words.length)
            return false;

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word))
                    return false;
            } else {
                charToWord.put(ch, word);
            }

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != ch)
                    return false;
            } else {
                wordToChar.put(word, ch);
            }
        }

        return true;
    }
}
