package com.duanxr.leetcode.easy;

/**
 * @author Duanran 2019/2/25 0025
 */
public class SumOfSquareNumbers {

  /**
   * Given a non-negative integer c, your task is to decide whether there're two integers a and b
   * such that a2 + b2 = c.
   *
   * Example 1:
   *
   * Input: 5
   *
   * Output: True
   *
   * Explanation: 1 * 1 + 2 * 2 = 5
   *
   *
   * Example 2:
   *
   * Input: 3
   *
   * Output: False
   *
   * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
   *
   * 示例1:
   *
   * 输入: 5
   *
   * 输出: True
   *
   * 解释: 1 * 1 + 2 * 2 = 5
   *
   *
   * 示例2:
   *
   * 输入: 3
   *
   * 输出: False
   */
  class Solution {

    public boolean judgeSquareSum(int c) {
      for (int i = 0; i <= Math.floor(Math.sqrt(c)); i++) {
        int n = c - (i * i);
        double square = Math.sqrt(n);
        if (Math.floor(square) == square) {
          return true;
        }
      }
      return false;
    }
  }
}
