package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/24
 */
public class ThreeStepsProblemLCCI {

  /**
   * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a method to count how many possible ways the child can run up the stairs. The result may be large, so return it modulo 1000000007.
   *
   * Example1:
   *
   *  Input: n = 3
   *  Output: 4
   * Example2:
   *
   *  Input: n = 5
   *  Output: 13
   * Note:
   *
   * 1 <= n <= 1000000
   *
   * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
   *
   * 示例1:
   *
   *  输入：n = 3
   *  输出：4
   *  说明: 有四种走法
   * 示例2:
   *
   *  输入：n = 5
   *  输出：13
   * 提示:
   *
   * n范围在[1, 1000000]之间
   *
   */
  class Solution {

    public int waysToStep(int n) {
      int[] cache = new int[n];
      return step(n, cache);
    }

    private int step(int n, int[] cache) {
      if (n < 0) {
        return 0;
      }
      if (n <= 1) {
        return 1;
      }
      if (cache[n - 1] != 0) {
        return cache[n - 1];
      }

      int step3 = step(n - 3, cache);
      int step2 = step(n - 2, cache);
      int step1 = step(n - 1, cache);
      int step = step3 + step2;
      step %= 1000000007;
      step += step1;
      step %= 1000000007;
      cache[n - 1] = step;

      return step;
    }
  }
}
