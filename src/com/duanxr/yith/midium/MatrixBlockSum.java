package com.duanxr.yith.midium;

/**
 * @author 段然 2021/5/17
 */
public class MatrixBlockSum {

  /**
   * Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:
   *
   * i - k <= r <= i + k,
   * j - k <= c <= j + k, and
   * (r, c) is a valid position in the matrix.
   *  
   *
   * Example 1:
   *
   * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
   * Output: [[12,21,16],[27,45,33],[24,39,28]]
   * Example 2:
   *
   * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
   * Output: [[45,45,45],[45,45,45],[45,45,45]]
   *  
   *
   * Constraints:
   *
   * m == mat.length
   * n == mat[i].length
   * 1 <= m, n, k <= 100
   * 1 <= mat[i][j] <= 100
   *
   * 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 
   *
   * i - K <= r <= i + K, j - K <= c <= j + K 
   * (r, c) 在矩阵内。
   *  
   *
   * 示例 1：
   *
   * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
   * 输出：[[12,21,16],[27,45,33],[24,39,28]]
   * 示例 2：
   *
   * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
   * 输出：[[45,45,45],[45,45,45],[45,45,45]]
   *  
   *
   * 提示：
   *
   * m == mat.length
   * n == mat[i].length
   * 1 <= m, n, K <= 100
   * 1 <= mat[i][j] <= 100
   *
   */
  class Solution {

    public int[][] matrixBlockSum(int[][] mat, int k) {
      int[][] sum = new int[mat.length][mat[0].length];
      for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat[0].length; j++) {
          if (j == 0) {
            if (i == 0) {
              for (int r = Math.max(i - k, 0); r <= Math.min(i + k, mat.length - 1); r++) {
                for (int c = Math.max(j - k, 0); c <= Math.min(j + k, mat[0].length - 1); c++) {
                  sum[i][j] += mat[r][c];
                }
              }
            } else {
              sum[i][j] = sum[i - 1][j];
              for (int c = Math.max(j - k, 0); c <= Math.min(j + k, mat[0].length - 1); c++) {
                if (i + k < mat.length) {
                  sum[i][j] += mat[i + k][c];
                }
                if (i - k - 1 >= 0) {
                  sum[i][j] -= mat[i - k - 1][c];
                }
              }
            }
          } else {
            sum[i][j] = sum[i][j - 1];
            for (int r = Math.max(i - k, 0); r <= Math.min(i + k, mat.length - 1); r++) {
              if (j + k < mat[0].length) {
                sum[i][j] += mat[r][j + k];
              }
              if (j - k - 1 >= 0) {
                sum[i][j] -= mat[r][j - k - 1];
              }
            }
          }
        }
      }
      return sum;
    }
  }
}
