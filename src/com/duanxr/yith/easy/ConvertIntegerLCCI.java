package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/23
 */
public class ConvertIntegerLCCI {

  /**
   * Write a function to determine the number of bits you would need to flip to convert integer A to integer B.
   *
   * Example1:
   *
   *  Input: A = 29 (0b11101), B = 15 (0b01111)
   *  Output: 2
   * Example2:
   *
   *  Input: A = 1，B = 2
   *  Output: 2
   * Note:
   *
   * -2147483648 <= A, B <= 2147483647
   *
   * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
   *
   * 示例1:
   *
   *  输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
   *  输出：2
   * 示例2:
   *
   *  输入：A = 1，B = 2
   *  输出：2
   * 提示:
   *
   * A，B范围在[-2147483648, 2147483647]之间
   *
   */
  class Solution {

    public int convertInteger(int A, int B) {
      int n = 0;
      for (int i = 0; i < 32; i++) {
        n += (A & 1) == (B & 1) ? 0 : 1;
        A=A>>>1;
        B=B>>>1;
      }
      return n;
    }
  }
}
