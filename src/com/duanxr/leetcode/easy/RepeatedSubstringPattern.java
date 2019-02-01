package com.duanxr.leetcode.easy;

/**
 * @author Duanran 2019/1/28 0028
 */
public class RepeatedSubstringPattern {

  /**
   * Given a non-empty string check if it can be constructed by taking a substring of it and
   * appending multiple copies of the substring together. You may assume the given string consists
   * of lowercase English letters only and its length will not exceed 10000.
   *
   * Example 1:
   *
   * Input: "abab"
   *
   * Output: True
   *
   * Explanation: It's the substring "ab" twice.
   *
   * Example 2:
   *
   * Input: "aba"
   *
   * Output: False
   *
   * Example 3:
   *
   * Input: "abcabcabcabc"
   *
   * Output: True
   *
   * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
   *
   * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
   *
   * 示例 1:
   *
   * 输入: "abab"
   *
   * 输出: True
   *
   * 解释: 可由子字符串 "ab" 重复两次构成。
   *
   * 示例 2:
   *
   * 输入: "aba"
   *
   * 输出: False
   *
   * 示例 3:
   *
   * 输入: "abcabcabcabc"
   *
   * 输出: True
   *
   * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
   */
  class Solution {

    public boolean repeatedSubstringPattern(String s) {
      char[] chars = s.toCharArray();
      char first = chars[0];
      out:
      for (int i = 1; i < (chars.length / 2) + 1; i++) {
        if (chars[i] == first && chars.length % i == 0) {
          for (int j = i; j < chars.length; j++) {
            int k = j % i;
            if (chars[k] != chars[j]) {
              continue out;
            }
          }
          return true;
        }
      }
      return false;
    }
  }
}
