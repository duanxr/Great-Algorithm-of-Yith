package com.duanxr.leetcode.easy;

/**
 * @author Duanran 2019/2/13 0013
 */
public class SquaresOfASortedArray {

  /**
   * Given an array of integers A sorted in non-decreasing order, return an array of the squares of
   * each number, also in sorted non-decreasing order.
   *
   *
   *
   * Example 1:
   *
   * Input: [-4,-1,0,3,10]
   *
   * Output: [0,1,9,16,100]
   *
   * Example 2:
   *
   * Input: [-7,-3,2,3,11]
   *
   * Output: [4,9,9,49,121]
   *
   *
   * Note:
   *
   * 1 <= A.length <= 10000
   *
   * -10000 <= A[i] <= 10000
   *
   * A is sorted in non-decreasing order.
   *
   * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
   *
   *
   *
   * 示例 1：
   *
   * 输入：[-4,-1,0,3,10]
   *
   * 输出：[0,1,9,16,100]
   *
   * 示例 2：
   *
   * 输入：[-7,-3,2,3,11]
   *
   * 输出：[4,9,9,49,121]
   *
   *
   * 提示：
   *
   * 1 <= A.length <= 10000
   *
   * -10000 <= A[i] <= 10000
   *
   * A 已按非递减顺序排序。
   */
  class Solution {

    public int[] sortedSquares(int[] A) {
      int[] result = new int[A.length];
      int left = 0;
      int right = A.length - 1;
      for (int i = right; i >= 0; i--) {
        int l = A[left];
        int r = A[right];
        if (Math.abs(l) > Math.abs(r)) {
          result[i] = l * l;
          left++;
        } else {
          result[i] = r * r;
          right--;
        }
      }
      return result;
    }
  }
}