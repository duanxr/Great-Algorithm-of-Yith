package com.duanxr.yith.easy;

/**
 * @author 段然 2021/4/30
 */
public class ContiguousSequenceLCCI {

  /**
   * You are given an array of integers (both positive and negative). Find the contiguous sequence with the largest sum. Return the sum.
   *
   * Example:
   *
   * Input:  [-2,1,-3,4,-1,2,1,-5,4]
   * Output:  6
   * Explanation:  [4,-1,2,1] has the largest sum 6.
   * Follow Up:
   *
   * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
   *
   * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
   *
   * 示例：
   *
   * 输入： [-2,1,-3,4,-1,2,1,-5,4]
   * 输出： 6
   * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
   * 进阶：
   *
   * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
   *
   */
  class Solution {

      public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
          return 0;
        }
        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int num : nums) {
          currentSum += num;
          max = Math.max(max, currentSum);
          if (currentSum < 0) {
            currentSum = 0;
          }
        }
        return max;
      }
  }
}
