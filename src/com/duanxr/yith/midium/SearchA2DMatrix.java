package com.duanxr.yith.midium;

/**
 * @author 段然 2021/3/29
 */
public class SearchA2DMatrix {

  /**
   * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
   *
   * Integers in each row are sorted from left to right.
   * The first integer of each row is greater than the last integer of the previous row.
   *  
   *
   * Example 1:
   *
   *
   * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
   * Output: true
   * Example 2:
   *
   *
   * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
   * Output: false
   *  
   *
   * Constraints:
   *
   * m == matrix.length
   * n == matrix[i].length
   * 1 <= m, n <= 100
   * -104 <= matrix[i][j], target <= 104
   *
   * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
   *
   * 每行中的整数从左到右按升序排列。
   * 每行的第一个整数大于前一行的最后一个整数。
   *  
   *
   * 示例 1：
   *
   *
   * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
   * 输出：true
   * 示例 2：
   *
   *
   * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
   * 输出：false
   *  
   *
   * 提示：
   *
   * m == matrix.length
   * n == matrix[i].length
   * 1 <= m, n <= 100
   * -104 <= matrix[i][j], target <= 104
   *
   */
  class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
      return find(matrix, target, 0, matrix.length * matrix[0].length - 1);
    }

    private boolean find(int[][] matrix, int target, int l, int r) {
      if (l > r) {
        return false;
      }
      int index = l + ((r - l) / 2);
      int current = matrix[index / matrix[0].length][index % matrix[0].length];
      if (current < target) {
        return find(matrix, target, index + 1, r);
      }
      if (current > target) {
        return find(matrix, target, l, index - 1);
      }
      return true;
    }

  }
}
