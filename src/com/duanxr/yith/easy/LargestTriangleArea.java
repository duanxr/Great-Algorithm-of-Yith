package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class LargestTriangleArea {

  /**
   * You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.
   *
   * Example:
   * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
   * Output: 2
   * Explanation:
   * The five points are show in the figure below. The red triangle is the largest.
   *
   *
   * Notes:
   *
   * 3 <= points.length <= 50.
   * No points will be duplicated.
   *  -50 <= points[i][j] <= 50.
   * Answers within 10^-6 of the true value will be accepted as correct.
   *
   * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
   *
   * 示例:
   * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
   * 输出: 2
   * 解释:
   * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
   *
   *
   * 注意:
   *
   * 3 <= points.length <= 50.
   * 不存在重复的点。
   *  -50 <= points[i][j] <= 50.
   * 结果误差值在 10^-6 以内都认为是正确答案。
   *
   */
  class Solution {

    public double largestTriangleArea(int[][] points) {
      double maxZ = Double.MIN_VALUE;
      for (int i = 0; i < points.length; i++) {
        for (int j = i + 1; j < points.length; j++) {
          for (int k = j + 1; k < points.length; k++) {
            int[] p1 = points[i];
            int[] p2 = points[j];
            int[] p3 = points[k];
            maxZ = Math.max(getM(p1, p2, p3), maxZ);
          }
        }
      }
      return maxZ;
    }

    public double getM(int[] p1, int[] p2, int[] p3) {
      double x1 = p1[0];
      double y1 = p1[1];
      double x2 = p2[0];
      double y2 = p2[1];
      double x3 = p3[0];
      double y3 = p3[1];
      return Math.abs((((x2 - x1) * (y3 - y1)) - ((x3 - x1) * (y2 - y1))) / 2);
    }
  }
}
