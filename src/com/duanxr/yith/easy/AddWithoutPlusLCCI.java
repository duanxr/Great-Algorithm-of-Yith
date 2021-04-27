package com.duanxr.yith.easy;

/**
 * @author 段然 2021/4/27
 */
public class AddWithoutPlusLCCI {

  /**
   * Write a function that adds two numbers. You should not use + or any arithmetic operators.
   *
   * Example:
   *
   * Input: a = 1, b = 1
   * Output: 2
   *  
   *
   * Note:
   *
   * a and b may be 0 or negative.
   * The result fits in 32-bit integer.
   *
   * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
   *
   * 示例:
   *
   * 输入: a = 1, b = 1
   * 输出: 2
   *  
   *
   * 提示：
   *
   * a, b 均可能是负数或 0
   * 结果不会溢出 32 位整数
   *
   */
  class Solution {

    public int add(int a, int b) {
      int up = a & b;
      int sum = a ^ b;
      return up == 0 ? sum : add(sum, up << 1);
    }
  }
}
