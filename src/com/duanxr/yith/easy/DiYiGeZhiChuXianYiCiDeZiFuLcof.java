package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/11
 */
public class DiYiGeZhiChuXianYiCiDeZiFuLcof {

  /**
   * English description is not available for the problem.
   *
   * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
   *
   * 示例:
   *
   * s = "abaccdeff"
   * 返回 "b"
   *
   * s = ""
   * 返回 " "
   *  
   *
   * 限制：
   *
   * 0 <= s 的长度 <= 50000
   *
   */
  class Solution {

    public char firstUniqChar(String s) {
      int[] charIndex = new int[26];
      byte[] charNum = new byte[26];
      char[] chars = s.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        char c = chars[i];
        int ci = c - 'a';
        if (charNum[ci] == 0) {
          charIndex[ci] = i;
        }
        charNum[ci]++;
      }
      int targetIndex = -1;
      for (int i = 0; i < charNum.length; i++) {
        if (charNum[i] == 1) {
          targetIndex = targetIndex == -1 ? charIndex[i] : Math.min(charIndex[i], targetIndex);
        }
      }
      return targetIndex == -1 ? ' ' : chars[targetIndex];
    }
  }
}
