package com.duanxr.yith.easy;

/**
 * @author Duanran 4/21/2020
 */
public class FindNUniqueIntegersSumUpToZero {

  /**
   * Given an integer n, return any array containing n unique integers such that they add up to 0.
   *
   * Example 1:
   *
   * Input: n = 5
   * Output: [-7,-1,1,3,4]
   * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
   * Example 2:
   *
   * Input: n = 3
   * Output: [-1,0,1]
   * Example 3:
   *
   * Input: n = 1
   * Output: [0]
   *  
   * Constraints:
   *
   * 1 <= n <= 1000
   *
   * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
   *
   * 示例 1：
   *
   * 输入：n = 5
   * 输出：[-7,-1,1,3,4]
   * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
   * 示例 2：
   *
   * 输入：n = 3
   * 输出：[-1,0,1]
   * 示例 3：
   *
   * 输入：n = 1
   * 输出：[0]
   *  
   * 提示：
   *
   * 1 <= n <= 1000
   *
   */
  class Solution {

    public int[] sumZero(int n) {
      int[] result = new int[n];
      if (n % 2 == 1) {
        for (int i = 1; i < n; i += 2) {
          result[i] = i;
          result[i + 1] = -i;
        }
      } else {
        for (int i = 0; i < n; i += 2) {
          result[i] = i + 1;
          result[i + 1] = -(i + 1);
        }
      }
      return result;
    }
  }
}
