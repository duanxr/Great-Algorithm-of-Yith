package com.duanxr.yith.easy;

/**
 * @author Duanran 2019/1/28 0028
 */
public class FlippingAnImage {

  /**
   * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the
   * resulting image.
   *
   * To flip an image horizontally means that each row of the image is reversed.  For example,
   * flipping [1, 1, 0] horizontally results in [0, 1, 1].
   *
   * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For
   * example, inverting [0, 1, 1] results in [1, 0, 0].
   *
   * Example 1:
   *
   * Input: [[1,1,0],[1,0,1],[0,0,0]]
   *
   * Output: [[1,0,0],[0,1,0],[1,1,1]]
   *
   * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
   *
   * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
   *
   * Example 2:
   *
   * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
   *
   * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
   *
   * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
   *
   * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
   *
   * Notes:
   *
   * 1 <= A.length = A[0].length <= 20
   *
   * 0 <= A[i][j] <= 1
   *
   * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
   *
   * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
   *
   * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
   *
   * 示例 1:
   *
   * 输入: [[1,1,0],[1,0,1],[0,0,0]]
   *
   * 输出: [[1,0,0],[0,1,0],[1,1,1]]
   *
   * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
   *
   * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
   *
   * 示例 2:
   *
   * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
   *
   * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
   *
   * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
   *
   * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
   *
   * 说明:
   *
   * 1 <= A.length = A[0].length <= 20
   *
   * 0 <= A[i][j] <= 1
   */
  class Solution {

    public int[][] flipAndInvertImage(int[][] A) {
      int[][] result = new int[A.length][A[0].length];
      for (int i = 0; i < A.length; i++) {
        int[] row = A[i];
        for (int j = 0; j < row.length; j++) {
          int nowInt = row[j];
          if (nowInt == 0) {
            result[i][row.length - j - 1] = 1;
          } else {
            result[i][row.length - j - 1] = 0;
          }
        }
      }
      return result;
    }
  }
}
