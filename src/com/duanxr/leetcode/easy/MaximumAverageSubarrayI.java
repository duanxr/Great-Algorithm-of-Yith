package com.duanxr.leetcode.easy;

/**
 * @author Duanran 2019/2/15 0015
 */
public class MaximumAverageSubarrayI {

  /**
   * Given an array consisting of n integers, find the contiguous subarray of given length k that
   * has the maximum average value. And you need to output the maximum average value.
   *
   * Example 1:
   *
   * Input: [1,12,-5,-6,50,3], k = 4
   *
   * Output: 12.75
   *
   * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
   *
   * Note:
   *
   * 1 <= k <= n <= 30,000.
   *
   * Elements of the given array will be in the range [-10,000, 10,000].
   *
   * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
   *
   * 示例 1:
   *
   * 输入: [1,12,-5,-6,50,3], k = 4
   *
   * 输出: 12.75
   *
   * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
   *
   *
   * 注意:
   *
   * 1 <= k <= n <= 30,000。
   *
   * 所给数据范围 [-10,000，10,000]。
   */
  class Solution {

    public double findMaxAverage(int[] nums, int k) {
      int max = Integer.MIN_VALUE;
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        if (i < k) {
          sum += nums[i];
        } else {
          sum += nums[i];
          sum -= nums[i - k];
        }
        if (sum > max && i >= k - 1) {
          max = sum;
        }
      }
      return max / (double) k;
    }
  }
}
