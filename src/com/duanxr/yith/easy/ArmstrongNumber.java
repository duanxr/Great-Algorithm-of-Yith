package com.duanxr.yith.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/5/11
 */
public class ArmstrongNumber {

  /**
   * Given an integer n, return true if and only if it is an Armstrong number.
   *
   * The k-digit number n is an Armstrong number if and only if the kth power of each digit sums to n.
   *
   *  
   *
   * Example 1:
   *
   * Input: n = 153
   * Output: true
   * Explanation: 153 is a 3-digit number, and 153 = 13 + 53 + 33.
   * Example 2:
   *
   * Input: n = 123
   * Output: false
   * Explanation: 123 is a 3-digit number, and 123 != 13 + 23 + 33 = 36.
   *  
   *
   * Constraints:
   *
   * 1 <= n <= 108
   *
   * 假设存在一个 k 位数 N，其每一位上的数字的 k 次幂的总和也是 N，那么这个数是阿姆斯特朗数。
   *
   * 给你一个正整数 N，让你来判定他是否是阿姆斯特朗数，是则返回 true，不是则返回 false。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：153
   * 输出：true
   * 示例：
   * 153 是一个 3 位数，且 153 = 1^3 + 5^3 + 3^3。
   * 示例 2：
   *
   * 输入：123
   * 输出：false
   * 解释：
   * 123 是一个 3 位数，且 123 != 1^3 + 2^3 + 3^3 = 36。
   *  
   *
   * 提示：
   *
   * 1 <= N <= 10^8
   *
   */
  class Solution {

    public boolean isArmstrong(int n) {
      List<Integer> list = new ArrayList<>();
      int tn = n;
      while (tn != 0) {
        list.add(tn % 10);
        tn /= 10;
      }
      int s = 0;
      for (Integer integer : list) {
        s += Math.pow(integer, list.size());
      }
      return n == s;
    }
  }
}
