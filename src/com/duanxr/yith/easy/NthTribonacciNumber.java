package com.duanxr.yith.easy;

/**
 * @author 段然 2021/8/9
 */
public class NthTribonacciNumber {

  /**
   * The Tribonacci sequence Tn is defined as follows: 
   *
   * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
   *
   * Given n, return the value of Tn.
   *
   *  
   *
   * Example 1:
   *
   * Input: n = 4
   * Output: 4
   * Explanation:
   * T_3 = 0 + 1 + 1 = 2
   * T_4 = 1 + 1 + 2 = 4
   * Example 2:
   *
   * Input: n = 25
   * Output: 1389537
   *  
   *
   * Constraints:
   *
   * 0 <= n <= 37
   * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
   *
   * 泰波那契序列 Tn 定义如下： 
   *
   * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
   *
   * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：n = 4
   * 输出：4
   * 解释：
   * T_3 = 0 + 1 + 1 = 2
   * T_4 = 1 + 1 + 2 = 4
   * 示例 2：
   *
   * 输入：n = 25
   * 输出：1389537
   *  
   *
   * 提示：
   *
   * 0 <= n <= 37
   * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
   *
   */
  class Solution {

    public int tribonacci(int n) {
      return tribonacci(n, new int[n + 1]);
    }

    private int tribonacci(int n, int[] cache) {
      return cache[n] != 0 ? cache[n] : n <= 2 ? (n + 1) / 2 : (cache[n] = tribonacci(n - 1, cache) + tribonacci(n - 2, cache) + tribonacci(n - 3, cache));
    }
  }
}
