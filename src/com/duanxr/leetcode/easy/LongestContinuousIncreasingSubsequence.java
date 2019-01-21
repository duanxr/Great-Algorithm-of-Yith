package com.duanxr.leetcode.easy;

/**
 * @author Duanran 2019/1/21 0021
 */
public class LongestContinuousIncreasingSubsequence {

  /**
   * Given an unsorted array of integers, find the length of longest continuous increasing
   * subsequence (subarray).
   *
   * Example 1:
   *
   * Input: [1,3,5,4,7]
   *
   * Output: 3
   *
   * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
   *
   * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and
   * 7 are separated by 4.
   *
   * Example 2:
   *
   * Input: [2,2,2,2,2]
   *
   * Output: 1
   *
   * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
   *
   * Note: Length of the array will not exceed 10,000.
   *
   * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
   *
   * 示例 1:
   *
   * 输入: [1,3,5,4,7]
   *
   * 输出: 3
   *
   * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
   *
   * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
   *
   * 示例 2:
   *
   * 输入: [2,2,2,2,2]
   *
   * 输出: 1
   *
   * 解释: 最长连续递增序列是 [2], 长度为1。
   *
   * 注意：数组长度不会超过10000。
   */
  class Solution {

    public int findLengthOfLCIS(int[] nums) {
      int max = 0;
      int now = 0;
      int last = Integer.MIN_VALUE;
      for (int n : nums) {
        if (n > last) {
          now++;
          if (now > max) {
            max = now;
          }
        } else {
          now = 0;
        }
        last = n;
      }
      return max;
    }

  }
}
