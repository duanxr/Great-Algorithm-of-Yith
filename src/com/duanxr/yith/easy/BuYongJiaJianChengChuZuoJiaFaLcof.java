package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/17
 */
public class BuYongJiaJianChengChuZuoJiaFaLcof {

  /**
   * English description is not available for the problem.
   *
   * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
   *
   *  
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

    int neg = 1 << 31;

    public int add(int a, int b) {
      //a = y2b(a);
      //b = y2b(b);
      int sum = unsignedAdd(a, b);
      return sum;//y2b(sum);
    }

    //用不到, java中数字是以补码的形式存储的
    private int y2b(int a) {
      if ((a & neg) == neg) {
        a = ~a;
        a = a | neg;
        a = unsignedAdd(a, 1);
      }
      return a;
    }

    public int unsignedAdd(int a, int b) {
      int up = a & b;
      //一定要先判断后左移,避免up溢出导致的计算出错.
      return up == 0 ? a | b : unsignedAdd(a ^ b, up << 1);
    }
  }

}
