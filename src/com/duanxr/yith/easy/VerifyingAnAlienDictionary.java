package com.duanxr.yith.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 段然 2021/3/8
 */
public class VerifyingAnAlienDictionary {

  /**
   * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
   *
   * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
   *
   *  
   *
   * Example 1:
   *
   * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
   * Output: true
   * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
   * Example 2:
   *
   * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
   * Output: false
   * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
   * Example 3:
   *
   * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
   * Output: false
   * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
   *  
   *
   * Constraints:
   *
   * 1 <= words.length <= 100
   * 1 <= words[i].length <= 20
   * order.length == 26
   * All characters in words[i] and order are English lowercase letters.
   *
   * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
   *
   * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
   * 输出：true
   * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
   * 示例 2：
   *
   * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
   * 输出：false
   * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
   * 示例 3：
   *
   * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
   * 输出：false
   * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
   *  
   *
   * 提示：
   *
   * 1 <= words.length <= 100
   * 1 <= words[i].length <= 20
   * order.length == 26
   * 在 words[i] 和 order 中的所有字符都是英文小写字母。
   *
   */
  class Solution {

    public boolean isAlienSorted(String[] words, String order) {
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < order.length(); i++) {
        map.put(order.charAt(i), i);
      }
      for (int i = 0; i < words.length - 1; i++) {
        if (!sorted(words[i], words[i + 1], map)) {
          return false;
        }
      }
      return true;
    }

    private boolean sorted(String word1, String word2, Map<Character, Integer> map) {
      for (int i = 0; i < Math.max(word1.length(), word2.length()); i++) {
        int c1 = i < word1.length() ? map.get(word1.charAt(i)) : -1;
        int c2 = i < word2.length() ? map.get(word2.charAt(i)) : -1;
        if (c1 == c2) {
          continue;
        }
        return c1 <= c2;
      }
      return true;
    }
  }
}
