package com.duanxr.yith.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 段然 2021/3/8
 */
public class IsomorphicStrings {

  /**
   * Given two strings s and t, determine if they are isomorphic.
   *
   * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
   *
   * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
   *
   *  
   *
   * Example 1:
   *
   * Input: s = "egg", t = "add"
   * Output: true
   * Example 2:
   *
   * Input: s = "foo", t = "bar"
   * Output: false
   * Example 3:
   *
   * Input: s = "paper", t = "title"
   * Output: true
   *  
   *
   * Constraints:
   *
   * 1 <= s.length <= 5 * 104
   * t.length == s.length
   * s and t consist of any valid ascii character.
   *
   * 给定两个字符串 s 和 t，判断它们是否是同构的。
   *
   * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
   *
   * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
   *
   *  
   *
   * 示例 1:
   *
   * 输入：s = "egg", t = "add"
   * 输出：true
   * 示例 2：
   *
   * 输入：s = "foo", t = "bar"
   * 输出：false
   * 示例 3：
   *
   * 输入：s = "paper", t = "title"
   * 输出：true
   *  
   *
   * 提示：
   *
   * 可以假设 s 和 t 长度相同。
   *
   */
  class Solution {

    public boolean isIsomorphic(String s, String t) {
      Helper helper = new Helper();
      for (int i = 0; i < s.length(); i++) {
        char cs = s.charAt(i);
        char ct = t.charAt(i);
        if (!helper.add(cs, ct)) {
          return false;
        }
      }
      return true;
    }

    private class Helper {

      private Map<Character, Character> map = new HashMap<>();

      public boolean add(char s, char t) {
        if (map.containsKey(s)) {
          return map.get(s) == t;
        } else {
          if (map.containsValue(t)) {
            return false;
          }
          map.put(s, t);
        }
        return true;
      }
    }
  }
}
