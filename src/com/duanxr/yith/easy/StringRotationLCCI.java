package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/16
 */
public class StringRotationLCCI {

  /**
   * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 (e.g.,"waterbottle" is a rotation of"erbottlewat"). Can you use only one call to the method that checks if one word is a substring of another?
   *
   * Example 1:
   *
   * Input: s1 = "waterbottle", s2 = "erbottlewat"
   * Output: True
   * Example 2:
   *
   * Input: s1 = "aa", s2 = "aba"
   * Output: False
   *  
   *
   * Note:
   *
   * 0 <= s1.length, s2.length <= 100000
   *
   * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
   *
   * 示例1:
   *
   *  输入：s1 = "waterbottle", s2 = "erbottlewat"
   *  输出：True
   * 示例2:
   *
   *  输入：s1 = "aa", s2 = "aba"
   *  输出：False
   * 提示：
   *
   * 字符串长度在[0, 100000]范围内。
   * 说明:
   *
   * 你能只调用一次检查子串的方法吗？
   *
   */
  class Solution {

    public boolean isFlipedString(String s1, String s2) {
      if (s1.length() != s2.length()) {
        return false;
      }
      if (s1.length() == 0) {
        return true;
      }
      char[] chars1 = s1.toCharArray();
      char[] chars2 = s2.toCharArray();
      OUT:
      for (int i = 0; i < chars1.length; i++) {
        if (chars1[i] == chars2[0]) {
          for (int j = 0; j < chars2.length; j++) {
            if (chars2[j] != chars1[(i + j) % chars1.length]) {
              continue OUT;
            }
          }
          return true;
        }
      }
      return false;
    }
  }

  class Solution1 {

    public boolean isFlipedString(String s1, String s2) {
      if (s1.length() != s2.length()) {
        return false;
      }
      if (s1.length() == 0) {
        return true;
      }
      int[] bit = new int[256];
      char[] chars1 = s1.toCharArray();
      char[] chars2 = s2.toCharArray();
      for (char c : chars1) {
        bit[c]++;
      }
      for (char c : chars2) {
        bit[c]--;
      }
      for (int i : bit) {
        if (i != 0) {
          return false;
        }
      }
      OUT:
      for (int i = 0; i < chars1.length; i++) {
        if (chars1[i] == chars2[0]) {
          for (int j = 0; j < chars2.length; j++) {
            if (chars2[j] != chars1[(i + j) % chars1.length]) {
              continue OUT;
            }
          }
          return true;
        }
      }
      return false;
    }
  }
}
