package com.duanxr.yith.midium;

/**
 * @author 段然 2021/3/25
 */
public class RecursiveMulitplyLCCI {

  /**
   * Write a recursive function to multiply two positive integers without using the * operator. You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
   *
   * Example 1:
   *
   *  Input: A = 1, B = 10
   *  Output: 10
   * Example 2:
   *
   *  Input: A = 3, B = 4
   *  Output: 12
   * Note:
   *
   * The result will not overflow.
   *
   * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
   *
   * 示例1:
   *
   *  输入：A = 1, B = 10
   *  输出：10
   * 示例2:
   *
   *  输入：A = 3, B = 4
   *  输出：12
   * 提示:
   *
   * 保证乘法范围不会溢出
   *
   */
  class Solution {

    public int multiply(int A, int B) {
      int r = 0;
      int p = 1<<31;
      for (int i = 0; i < 32; i++) {
        r = r << 1;
        B = B << 1;
        if ((B & p) == p) {
          r = add(r, A);
        }
      }
      return r;
    }

    public int add(int A, int B) {
      if (B == 0) {
        return A;
      }
      return add(A ^ B, (A & B) << 1);
    }
  }

}
