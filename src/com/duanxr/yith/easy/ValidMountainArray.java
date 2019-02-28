package com.duanxr.yith.easy;

/**
 * @author Duanran 2019/2/14 0014
 */
public class ValidMountainArray {

  /**
   * Given an array A of integers, return true if and only if it is a valid mountain array.
   *
   * Recall that A is a mountain array if and only if:
   *
   * A.length >= 3
   *
   * There exists some i with 0 < i < A.length - 1 such that:
   *
   * A[0] < A[1] < ... A[i-1] < A[i]
   *
   * A[i] > A[i+1] > ... > A[B.length - 1]
   *
   *
   * Example 1:
   *
   * Input: [2,1]
   *
   * Output: false
   *
   * Example 2:
   *
   * Input: [3,5,5]
   *
   * Output: false
   *
   * Example 3:
   *
   * Input: [0,3,2,1]
   *
   * Output: true
   *
   *
   * Note:
   *
   * 0 <= A.length <= 10000
   *
   * 0 <= A[i] <= 10000
   *
   * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
   *
   * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
   *
   * A.length >= 3
   *
   * 在 0 < i < A.length - 1 条件下，存在 i 使得：
   *
   * A[0] < A[1] < ... A[i-1] < A[i]
   *
   * A[i] > A[i+1] > ... > A[B.length - 1]
   *
   *
   * 示例 1：
   *
   * 输入：[2,1]
   *
   * 输出：false
   *
   * 示例 2：
   *
   * 输入：[3,5,5]
   *
   * 输出：false
   *
   * 示例 3：
   *
   * 输入：[0,3,2,1]
   *
   * 输出：true
   *
   *
   * 提示：
   *
   * 0 <= A.length <= 10000
   *
   * 0 <= A[i] <= 10000
   */
  class Solution {

    public boolean validMountainArray(int[] A) {
      if (A == null || A.length < 3) {
        return false;
      }
      int current = Integer.MIN_VALUE;
      int leftIndex = -1;
      int rightIndex = -2;
      for (int i = 0; i < A.length; i++) {
        if (A[i] < current) {
          leftIndex = i - 1;
          break;
        } else if (A[i] == current) {
          return false;
        }
        current = A[i];
      }
      current = Integer.MIN_VALUE;
      for (int i = A.length - 1; i >= 0; i--) {
        if (A[i] < current) {
          rightIndex = i + 1;
          break;
        } else if (A[i] == current) {
          return false;
        }
        current = A[i];
      }
      return leftIndex == rightIndex && leftIndex > 0 && rightIndex < A.length - 1;
    }
  }
}
