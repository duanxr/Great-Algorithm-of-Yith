package com.duanxr.yith.midium;

/**
 * @author 段然 2021/3/22
 */
public class ShuZhiDeZhengShuCiFangLcof {

  /**
   * English description is not available for the problem.
   *
   * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：x = 2.00000, n = 10
   * 输出：1024.00000
   * 示例 2：
   *
   * 输入：x = 2.10000, n = 3
   * 输出：9.26100
   * 示例 3：
   *
   * 输入：x = 2.00000, n = -2
   * 输出：0.25000
   * 解释：2-2 = 1/22 = 1/4 = 0.25
   *  
   *
   * 提示：
   *
   * -100.0 < x < 100.0
   * -231 <= n <= 231-1
   * -104 <= xn <= 104
   *  
   *
   * 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
   *
   */
  class Solution {

    public double myPow(double x, int n) {
      //不能用Math.abs, 因为-2147483648
      if (n <= 1 && n >= -1) {
        return n == 0 ? 1 : n > 0 ? x : 1 / x;
      }
      boolean negative = n < 0;
      int nextN = Math.abs(n / 2);
      //不能用n%2==1,因为负数
      double val = myPow(x * x, nextN) * ((n & 1) == 1 ? x : 1);
      return negative ? 1 / val : val;
    }

  }

  class Solution2 {

    public double myPow(double x, int n) {
      double pow = 1;
      if (n > 0) {
        for (int i = 0; i < n; i++) {
          pow *= x;
        }
      } else if (n < 0) {
        for (int i = 0; i > n; i--) {
          pow *= (1 / x);
        }
      }
      return pow;
    }
  }

  class Solution1 {

    public double myPow(double x, int n) {
      if (n == 0) {
        return 1;
      }
      return n > 0 ? x * myPow(x, n - 1) : (1 / x) * myPow(x, n + 1);
    }
  }
}
