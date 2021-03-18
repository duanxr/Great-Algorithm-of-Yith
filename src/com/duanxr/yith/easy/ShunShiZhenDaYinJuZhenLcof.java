package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/18
 */
public class ShunShiZhenDaYinJuZhenLcof {

  /**
   * English description is not available for the problem.
   *
   * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
   * 输出：[1,2,3,6,9,8,7,4,5]
   * 示例 2：
   *
   * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
   * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
   *  
   *
   * 限制：
   *
   * 0 <= matrix.length <= 100
   * 0 <= matrix[i].length <= 100
   * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
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

    public int[] spiralOrder(int[][] matrix) {
      if (matrix.length == 0) {
        return new int[0];
      }
      int length = matrix.length * matrix[0].length;
      int[] result = new int[length];
      return spiralOrder(matrix, result, Direction.RIGHT, 0, 0, 0, 0, length);
    }

    private int[] spiralOrder(int[][] matrix, int[] result, Direction direction, int l, int r,
        int u, int d, int length) {
      if (length == 0) {
        return result;
      }
      int x = 0;
      int y = 0;
      switch (direction) {
        case RIGHT:
          x = l;
          y = u;
          while (x < matrix[0].length - r) {
            result[result.length - (length--)] = matrix[y][x++];
          }
          u++;
          break;
        case DOWN:
          y = u;
          x = matrix[0].length - r - 1;
          while (y < matrix.length - d) {
            result[result.length - (length--)] = matrix[y++][x];
          }
          r++;
          break;
        case LEFT:
          x = matrix[0].length - r - 1;
          y = matrix.length - d - 1;
          while (x >= l) {
            result[result.length - (length--)] = matrix[y][x--];
          }
          d++;
          break;
        case UP:
        default:
          y = matrix.length - d - 1;
          x = l;
          while (y >= u) {
            result[result.length - (length--)] = matrix[y--][x];
          }
          l++;
      }
      return spiralOrder(matrix, result, direction.turnRight(), l, r, u, d, length);

    }

  }

}
