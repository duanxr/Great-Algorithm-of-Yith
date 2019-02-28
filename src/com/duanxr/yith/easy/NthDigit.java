package com.duanxr.yith.easy;

/**
 * @author Duanran 2019/2/20 0020
 */
public class NthDigit {

  /**
   * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
   *
   * Note:
   *
   * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
   *
   * Example 1:
   *
   * Input:
   *
   * 3
   *
   * Output:
   *
   * 3
   *
   * Example 2:
   *
   * Input:
   *
   * 11
   *
   * Output:
   *
   * 0
   *
   * Explanation:
   *
   * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of
   * the number 10.
   *
   * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
   *
   * 注意:
   *
   * n 是正数且在32为整形范围内 ( n < 231)。
   *
   * 示例 1:
   *
   * 输入:
   *
   * 3
   *
   * 输出:
   *
   * 3
   *
   * 示例 2:
   *
   * 输入:
   *
   * 11
   *
   * 输出:
   *
   * 0
   *
   * 说明:
   *
   * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
   */
  class Solution {

    public int findNthDigit(int n) {
      if (n < 10) {
        return n;
      }
      long maxBit = 9;
      int bit = 1;
      while (n > bit * maxBit) {
        n -= maxBit * bit;
        bit++;
        maxBit *= 10;
      }
      long num = (int) Math.pow(10, bit - 1);
      num += n / bit;
      n %= bit;
      if (n == 0) {
        return (int) ((num - 1) % 10);
      }
      for (int i = 0; i < bit - n; i++) {
        num /= 10;
      }
      return (int) (num % 10);
    }
  }
}
