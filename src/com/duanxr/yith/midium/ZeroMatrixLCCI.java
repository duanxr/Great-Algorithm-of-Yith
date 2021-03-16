package com.duanxr.yith.midium;

/**
 * @author 段然 2021/3/16
 */
public class ZeroMatrixLCCI {

  /**
   * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
   *
   *  
   *
   * Example 1:
   *
   * Input:
   * [
   *   [1,1,1],
   *   [1,0,1],
   *   [1,1,1]
   * ]
   * Output:
   * [
   *   [1,0,1],
   *   [0,0,0],
   *   [1,0,1]
   * ]
   * Example 2:
   *
   * Input:
   * [
   *   [0,1,2,0],
   *   [3,4,5,2],
   *   [1,3,1,5]
   * ]
   * Output:
   * [
   *   [0,0,0,0],
   *   [0,4,5,0],
   *   [0,3,1,0]
   * ]
   *
   * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：
   * [
   *   [1,1,1],
   *   [1,0,1],
   *   [1,1,1]
   * ]
   * 输出：
   * [
   *   [1,0,1],
   *   [0,0,0],
   *   [1,0,1]
   * ]
   * 示例 2：
   *
   * 输入：
   * [
   *   [0,1,2,0],
   *   [3,4,5,2],
   *   [1,3,1,5]
   * ]
   * 输出：
   * [
   *   [0,0,0,0],
   *   [0,4,5,0],
   *   [0,3,1,0]
   * ]
   *
   */
  class Solution {

    public void setZeroes(int[][] matrix) {
      if (matrix.length == 0 || matrix[0].length == 0) {
        return;
      }
      byte[] bitX = new byte[matrix[0].length];
      byte[] bitY = new byte[matrix.length];
      for (int y = 0; y < matrix.length; y++) {
        int[] ints = matrix[y];
        for (int x = 0; x < ints.length; x++) {
          if (matrix[y][x] == 0) {
            bitX[x] = 1;
            bitY[y] = 1;
          }
        }
      }
      for (int y = 0; y < matrix.length; y++) {
        int[] ints = matrix[y];
        for (int x = 0; x < ints.length; x++) {
          if (bitX[x] == 1 || bitY[y] == 1) {
            matrix[y][x] = 0;
          }
        }
      }
    }
  }
}
