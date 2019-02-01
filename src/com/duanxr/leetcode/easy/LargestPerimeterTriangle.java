package com.duanxr.leetcode.easy;

import java.util.Arrays;

/**
 * @author Duanran 2019/1/19 0019
 */
public class LargestPerimeterTriangle {

  /**
   * Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero
   * area, formed from 3 of these lengths.
   *
   * If it is impossible to form any triangle of non-zero area, return 0.
   *
   *
   *
   * Example 1:
   *
   * Input: [2,1,2]
   *
   * Output: 5
   *
   * Example 2:
   *
   * Input: [1,2,1]
   *
   * Output: 0
   *
   * Example 3:
   *
   * Input: [3,2,3,4]
   *
   * Output: 10
   *
   * Example 4:
   *
   * Input: [3,6,2,3]
   *
   * Output: 8
   *
   *
   * Note:
   *
   * 3 <= A.length <= 10000
   *
   * 1 <= A[i] <= 10^6
   *
   *
   * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
   *
   * 如果不能形成任何面积不为零的三角形，返回 0。
   *
   *
   *
   * 示例 1：
   *
   * 输入：[2,1,2]
   *
   * 输出：5
   *
   * 示例 2：
   *
   * 输入：[1,2,1]
   *
   * 输出：0
   *
   * 示例 3：
   *
   * 输入：[3,2,3,4]
   *
   * 输出：10
   *
   * 示例 4：
   *
   * 输入：[3,6,2,3]
   *
   * 输出：8
   *
   *
   * 提示：
   *
   * 3 <= A.length <= 10000
   *
   * 1 <= A[i] <= 10^6
   */
  class Solution {

    public int largestPerimeter(int[] A) {
      Arrays.sort(A);
      for (int i = A.length - 1; i >= 2; i--) {
        if (!isZero(A[i], A[i - 1], A[i - 2])) {
          return A[i] + A[i - 1] + A[i - 2];
        }
      }
      return 0;
    }

    private boolean isZero(int a, int b, int c) {
      return (b + c - a) <= 0;
    }
  }
}
