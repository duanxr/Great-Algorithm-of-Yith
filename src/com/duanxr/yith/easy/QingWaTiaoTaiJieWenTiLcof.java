package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/16
 */
public class QingWaTiaoTaiJieWenTiLcof {

  /**
   * English description is not available for the problem.
   *
   * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
   *
   * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
   *
   * 示例 1：
   *
   * 输入：n = 2
   * 输出：2
   * 示例 2：
   *
   * 输入：n = 7
   * 输出：21
   * 示例 3：
   *
   * 输入：n = 0
   * 输出：1
   * 提示：
   *
   * 0 <= n <= 100
   * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
   *
   */
  class Solution {

    int[] cache = new int[100];

    public int numWays(int n) {
      if (n <= 1) {
        return 1;
      }
      if (cache[n - 1] == 0) {
        int num = numWays(n - 2) + numWays(n - 1);
        cache[n - 1] = num % 1000000007;
      }
      return cache[n - 1];
    }
  }
}
