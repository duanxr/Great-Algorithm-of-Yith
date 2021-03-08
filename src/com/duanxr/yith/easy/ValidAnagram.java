package com.duanxr.yith.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 段然 2021/3/8
 */
public class ValidAnagram {

  /**
   * Given two strings s and t , write a function to determine if t is an anagram of s.
   *
   * Example 1:
   *
   * Input: s = "anagram", t = "nagaram"
   * Output: true
   * Example 2:
   *
   * Input: s = "rat", t = "car"
   * Output: false
   * Note:
   * You may assume the string contains only lowercase alphabets.
   *
   * Follow up:
   * What if the inputs contain unicode characters? How would you adapt your solution to such case?
   *
   * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
   *
   * 示例 1:
   *
   * 输入: s = "anagram", t = "nagaram"
   * 输出: true
   * 示例 2:
   *
   * 输入: s = "rat", t = "car"
   * 输出: false
   * 说明:
   * 你可以假设字符串只包含小写字母。
   *
   * 进阶:
   * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
   *
   */
  class Solution {

    public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }
      Map<Character, Integer> maps = new HashMap<>();
      Map<Character, Integer> mapt = new HashMap<>();
      for (char c : s.toCharArray()) {
        if (maps.containsKey(c)) {
          maps.put(c, maps.get(c) + 1);
        } else {
          maps.put(c, 1);
        }
      }
      for (char c : t.toCharArray()) {
        if (mapt.containsKey(c)) {
          mapt.put(c, mapt.get(c) + 1);
        } else {
          mapt.put(c, 1);
        }
      }
      return maps.equals(mapt);
    }
  }
}
