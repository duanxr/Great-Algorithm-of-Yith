package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/16
 */
public class IsUniqueLCCI {

  /**
   * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
   *
   * Example 1:
   *
   * Input: s = "leetcode"
   * Output: false
   * Example 2:
   *
   * Input: s = "abc"
   * Output: true
   *  
   *
   * Note:
   *
   * 0 <= len(s) <= 100
   *
   * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
   *
   * 示例 1：
   *
   * 输入: s = "leetcode"
   * 输出: false
   * 示例 2：
   *
   * 输入: s = "abc"
   * 输出: true
   * 限制：
   *
   * 0 <= len(s) <= 100
   * 如果你不使用额外的数据结构，会很加分。
   *
   */
  class Solution {

    public boolean isUnique(String astr) {
      int bit = 0;
      for (char c : astr.toCharArray()) {
        if (isBitExits(c, bit)) {
          return false;
        }
        bit = addBit(c, bit);
      }
      return true;
    }

    private boolean isBitExits(char c, int bit) {
      int i = c - 'a';
      int n = 1 << i;
      return n == (bit & n);
    }

    private int addBit(char c, int bit) {
      int i = c - 'a';
      bit = bit | (1 << i);
      return bit;
    }
  }
}
