package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/24
 */
public class ExchangeLCCI {

  /**
   * Write a program to swap odd and even bits in an integer with as few instructions as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
   *
   * Example1:
   *
   *  Input: num = 2（0b10）
   *  Output 1 (0b01)
   * Example2:
   *
   *  Input: num = 3
   *  Output: 3
   * Note:
   *
   * 0 <= num <= 2^30 - 1
   * The result integer fits into 32-bit integer.
   *
   * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
   *
   * 示例1:
   *
   *  输入：num = 2（或者0b10）
   *  输出 1 (或者 0b01)
   * 示例2:
   *
   *  输入：num = 3
   *  输出：3
   * 提示:
   *
   * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
   *
   */
  class Solution {

    public int exchangeBits(int num) {
      int filter = 0;
      for (int i = 0; i < 32; i++) {
        if (i % 2 == 1) {
          filter |= 1;
        }
        filter = filter << 1;
      }
      int n0 = num & ~filter;
      int n1 = num & filter;

      return (n0<<1) | (n1>>>1);
    }
  }
}
