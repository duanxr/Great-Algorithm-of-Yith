package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/15
 */
public class DaYinCong1DaoZuiDaDeNWeiShuLcof {

  /**
   * English description is not available for the problem.
   *
   * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
   *
   * 示例 1:
   *
   * 输入: n = 1
   * 输出: [1,2,3,4,5,6,7,8,9]
   *  
   *
   * 说明：
   *
   * 用返回一个整数列表来代替打印
   * n 为正整数
   *
   */
  class Solution {

    public int[] printNumbers(int n) {
      int size = (int) (Math.pow(10, n) - 1);
      int[] result = new int[size];
      for (int i = 0; i < size; i++) {
        result[i] = i + 1;
      }
      return result;
    }
  }
}
