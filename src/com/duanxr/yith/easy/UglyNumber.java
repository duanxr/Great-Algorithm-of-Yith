package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class UglyNumber {

  /**
   * Given an integer n, return true if n is an ugly number.
   *
   * Ugly number is a positive number whose prime factors only include 2, 3, and/or 5.
   *
   *  
   *
   * Example 1:
   *
   * Input: n = 6
   * Output: true
   * Explanation: 6 = 2 × 3
   * Example 2:
   *
   * Input: n = 8
   * Output: true
   * Explanation: 8 = 2 × 2 × 2
   * Example 3:
   *
   * Input: n = 14
   * Output: false
   * Explanation: 14 is not ugly since it includes another prime factor 7.
   * Example 4:
   *
   * Input: n = 1
   * Output: true
   * Explanation: 1 is typically treated as an ugly number.
   *  
   *
   * Constraints:
   *
   * -231 <= n <= 231 - 1
   *
   * 编写一个程序判断给定的数是否为丑数。
   *
   * 丑数就是只包含质因数 2, 3, 5 的正整数。
   *
   * 示例 1:
   *
   * 输入: 6
   * 输出: true
   * 解释: 6 = 2 × 3
   * 示例 2:
   *
   * 输入: 8
   * 输出: true
   * 解释: 8 = 2 × 2 × 2
   * 示例 3:
   *
   * 输入: 14
   * 输出: false
   * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
   * 说明：
   *
   * 1 是丑数。
   * 输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
   *
   */
  class Solution {

    public boolean isUgly(int num) {
      if (num < 1) {
        return false;
      }
      while (true) {
        if (num % 2 == 0) {
          num = num / 2;
        } else if (num % 3 == 0) {
          num = num / 3;
        } else if (num % 5 == 0) {
          num = num / 5;
        } else {
          return num == 1;
        }
      }
    }
  }
}
