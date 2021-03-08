package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class Base7 {

  /**
   * Given an integer, return its base 7 string representation.
   *
   * Example 1:
   * Input: 100
   * Output: "202"
   * Example 2:
   * Input: -7
   * Output: "-10"
   * Note: The input will be in range of [-1e7, 1e7].
   *
   * 给定一个整数，将其转化为7进制，并以字符串形式输出。
   *
   * 示例 1:
   *
   * 输入: 100
   * 输出: "202"
   * 示例 2:
   *
   * 输入: -7
   * 输出: "-10"
   * 注意: 输入范围是 [-1e7, 1e7] 。
   *
   */
  class Solution {

    public String convertToBase7(int num) {
      StringBuilder sb = new StringBuilder();
      boolean f = num < 0;
      num = Math.abs(num);
      do {
        sb.append(num % 7);
        num = num / 7;
      } while (num > 0);
      if (f) {
        sb.append('-');
      }
      return sb.reverse().toString();
    }
  }
}
