package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class TransposeMatrix {

  /**
   * Given a 2D integer array matrix, return the transpose of matrix.
   *
   * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
   *
   *
   *
   *  
   *
   * Example 1:
   *
   * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
   * Output: [[1,4,7],[2,5,8],[3,6,9]]
   * Example 2:
   *
   * Input: matrix = [[1,2,3],[4,5,6]]
   * Output: [[1,4],[2,5],[3,6]]
   *  
   *
   * Constraints:
   *
   * m == matrix.length
   * n == matrix[i].length
   * 1 <= m, n <= 1000
   * 1 <= m * n <= 105
   * -109 <= matrix[i][j] <= 109
   *
   * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
   *
   * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
   *
   *
   *
   *  
   *
   * 示例 1：
   *
   * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
   * 输出：[[1,4,7],[2,5,8],[3,6,9]]
   * 示例 2：
   *
   * 输入：matrix = [[1,2,3],[4,5,6]]
   * 输出：[[1,4],[2,5],[3,6]]
   *  
   *
   * 提示：
   *
   * m == matrix.length
   * n == matrix[i].length
   * 1 <= m, n <= 1000
   * 1 <= m * n <= 105
   * -109 <= matrix[i][j] <= 109
   *
   */
  class Solution {

    public int[][] transpose(int[][] A) {
      int[][] result = new int[A[0].length][A.length];
      for (int i = 0; i < A.length; i++) {
        for (int j = 0; j < A[i].length; j++) {
          result[j][i] = A[i][j];
        }
      }
      return result;
    }
  }
}
