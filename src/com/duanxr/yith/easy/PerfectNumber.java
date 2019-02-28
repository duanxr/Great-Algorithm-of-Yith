package com.duanxr.yith.easy;

/**
 * @author Duanran 2019/2/15 0015
 */
public class PerfectNumber {
  /**
   * We define the Perfect Number is a positive integer that is equal to the sum of all its positive
   * divisors except itself.
   *
   * Now, given an integer n, write a function that returns true when it is a perfect number and
   * false when it is not. Example:
   *
   * Input: 28
   *
   * Output: True
   *
   * Explanation: 28 = 1 + 2 + 4 + 7 + 14
   *
   * Note: The input number n will not exceed 100,000,000. (1e8)
   *
   * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
   *
   * 给定一个 正整数 n， 如果他是完美数，返回 True，否则返回 False
   *
   * 示例：
   *
   * 输入: 28
   *
   * 输出: True
   *
   * 解释: 28 = 1 + 2 + 4 + 7 + 14
   *
   * 注意:
   *
   * 输入的数字 n 不会超过 100,000,000. (1e8)
   */
  class Solution {

    public boolean checkPerfectNumber(int num) {
      if (num <= 1) {
        return false;
      }
      int count = 0;
      for (int i = (int) Math.sqrt(num); i > 0; i--) {
        if (num % i == 0) {
          int n = num / i;
          count += i;
          if (i != n && n != num) {
            count += n;
          }
        }
      }
      return count == num;
    }
  }
}
