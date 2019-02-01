package com.duanxr.leetcode.easy;

/**
 * @author Duanran 2019/1/30 0030
 */
public class FirstUniqueCharacterInAString {

  /**
   * Given a string, find the first non-repeating character in it and return it's index. If it
   * doesn't exist, return -1.
   *
   * Examples:
   *
   * s = "leetcode"
   *
   * return 0.
   *
   * s = "loveleetcode",
   *
   * return 2.
   *
   * Note: You may assume the string contain only lowercase letters.
   *
   * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
   *
   * 案例:
   *
   * s = "leetcode"
   *
   * 返回 0.
   *
   * s = "loveleetcode",
   *
   * 返回 2.
   */
  class Solution {

    public int firstUniqChar(String s) {
      byte[] bytes = new byte[128];
      char[] chars = s.toCharArray();
      for (char c : chars) {
        if (bytes[(int) c] < 2) {
          bytes[(int) c]++;
        }
      }
      for (int i = 0; i < chars.length; i++) {
        if (bytes[(int) chars[i]] == 1) {
          return i;
        }
      }
      return -1;
    }
  }
}
