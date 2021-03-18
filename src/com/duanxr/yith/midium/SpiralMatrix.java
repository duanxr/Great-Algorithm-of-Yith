package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/3/18
 */
public class SpiralMatrix {

  /**
   * Given an m x n matrix, return all elements of the matrix in spiral order.
   *
   * Example 1:
   *
   *
   * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
   * Output: [1,2,3,6,9,8,7,4,5]
   * Example 2:
   *
   *
   * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
   * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
   *  
   *
   * Constraints:
   *
   * m == matrix.length
   * n == matrix[i].length
   * 1 <= m, n <= 10
   * -100 <= matrix[i][j] <= 100
   *
   *
   * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
   *
   * 示例 1：
   *
   *
   * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
   * 输出：[1,2,3,6,9,8,7,4,5]
   * 示例 2：
   *
   *
   * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
   * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
   *  
   *
   * 提示：
   *
   * m == matrix.length
   * n == matrix[i].length
   * 1 <= m, n <= 10
   * -100 <= matrix[i][j] <= 100
   *
   */
  static class Solution {

    enum Direction {
      RIGHT,
      DOWN,
      LEFT,
      UP;

      public Direction turnRight() {
        switch (this) {
          case RIGHT:
            return DOWN;
          case DOWN:
            return LEFT;
          case LEFT:
            return UP;
          case UP:
          default:
            return RIGHT;
        }
      }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
      return spiralOrder(matrix, new ArrayList<>(), Direction.RIGHT, 0, 0, 0, 0);
    }

    private List<Integer> spiralOrder(int[][] matrix, ArrayList<Integer> list, Direction direction,
        int l, int r, int u, int d) {
      if (matrix.length * matrix[0].length == list.size()) {
        return list;
      }
      int x = 0;
      int y = 0;
      switch (direction) {
        case RIGHT:
          x = l;
          y = u;
          while (x < matrix[0].length - r) {
            list.add(matrix[y][x++]);
          }
          u++;
          break;
        case DOWN:
          y = u;
          x = matrix[0].length - r - 1;
          while (y < matrix.length - d) {
            list.add(matrix[y++][x]);
          }
          r++;
          break;
        case LEFT:
          x = matrix[0].length - r - 1;
          y = matrix.length - d - 1;
          while (x >= l) {
            list.add(matrix[y][x--]);
          }
          d++;
          break;
        case UP:
        default:
          y = matrix.length - d - 1;
          x = l;
          while (y >= u) {
            list.add(matrix[y--][x]);
          }
          l++;
      }
      return spiralOrder(matrix, list, direction.turnRight(), l, r, u, d);
    }
  }

}
