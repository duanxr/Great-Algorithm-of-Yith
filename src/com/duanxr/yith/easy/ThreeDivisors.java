package com.duanxr.yith.easy;

import java.util.Arrays;

/**
 * @author 段然 2021/10/14
 */
public class ThreeDivisors {

  /**
   * Given an integer n, return true if n has exactly three positive divisors. Otherwise, return false.
   *
   * An integer m is a divisor of n if there exists an integer k such that n = k * m.
   *
   *  
   *
   * Example 1:
   *
   * Input: n = 2
   * Output: false
   * Explantion: 2 has only two divisors: 1 and 2.
   * Example 2:
   *
   * Input: n = 4
   * Output: true
   * Explantion: 4 has three divisors: 1, 2, and 4.
   *  
   *
   * Constraints:
   *
   * 1 <= n <= 104
   *
   * 给你一个整数 n 。如果 n 恰好有三个正除数 ，返回 true ；否则，返回 false 。
   *
   * 如果存在整数 k ，满足 n = k * m ，那么整数 m 就是 n 的一个 除数 。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：n = 2
   * 输出：false
   * 解释：2 只有两个除数：1 和 2 。
   * 示例 2：
   *
   * 输入：n = 4
   * 输出：true
   * 解释：4 有三个除数：1、2 和 4 。
   *  
   *
   * 提示：
   *
   * 1 <= n <= 104
   *
   */
  class Solution {

    private final int[] vals = new int[]{4, 9, 25, 49, 121, 169, 289, 361, 529, 841, 961, 1369,
        1681, 1849, 2209, 2809, 3481, 3721, 4489, 5041, 5329, 6241, 6889, 7921, 9409};

    public boolean isThree(int n) {
      return Arrays.binarySearch(vals, n) >= 0;
    }
  }


}
