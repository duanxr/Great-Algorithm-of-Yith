package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/11
 */
public class ZuoXuanZhuanZiFuChuanLcof {

  /**
   * English description is not available for the problem.
   *
   * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
   *
   *  
   *
   * 示例 1：
   *
   * 输入: s = "abcdefg", k = 2
   * 输出: "cdefgab"
   * 示例 2：
   *
   * 输入: s = "lrloseumgh", k = 6
   * 输出: "umghlrlose"
   *  
   *
   * 限制：
   *
   * 1 <= k < s.length <= 10000
   *
   */
  class Solution {

    public String reverseLeftWords(String s, int n) {
      char[] newChars = new char[s.length()];
      char[] chars = s.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        newChars[i < n ? newChars.length - n + i : i - n] = chars[i];
      }
      return new String(newChars);
    }

  }
}
