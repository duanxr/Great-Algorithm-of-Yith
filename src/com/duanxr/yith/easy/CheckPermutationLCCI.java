package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/16
 */
public class CheckPermutationLCCI {

  /**
   * Given two strings,write a method to decide if one is a permutation of the other.
   *
   * Example 1:
   *
   * Input: s1 = "abc", s2 = "bca"
   * Output: true
   * Example 2:
   *
   * Input: s1 = "abc", s2 = "bad"
   * Output: false
   * Note:
   *
   * 0 <= len(s1) <= 100
   * 0 <= len(s2) <= 100
   *
   * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
   *
   * 示例 1：
   *
   * 输入: s1 = "abc", s2 = "bca"
   * 输出: true
   * 示例 2：
   *
   * 输入: s1 = "abc", s2 = "bad"
   * 输出: false
   * 说明：
   *
   * 0 <= len(s1) <= 100
   * 0 <= len(s2) <= 100
   *
   */
  class Solution {

    public boolean CheckPermutation(String s1, String s2) {
      if (s1.length() != s2.length()) {
        return false;
      }
      int[] bit = new int[26];
      for (int i = 0; i < s1.length(); i++) {
        bit[s1.charAt(i) - 'a']++;
      }
      for (int i = 0; i < s2.length(); i++) {
        bit[s2.charAt(i) - 'a']--;
      }
      for (int b : bit) {
        if (b != 0) {
          return false;
        }
      }
      return true;
    }
  }
}
