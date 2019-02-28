package com.duanxr.yith.easy;

import java.util.Arrays;

/**
 * @author Duanran 2019/2/19 0019
 */
public class MagicSquaresInGrid {

  /**
   * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each
   * row, column, and both diagonals all have the same sum.
   *
   * Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is
   * contiguous).
   *
   * Example 1:
   *
   * Input:
   *
   * [[4,3,8,4],
   * [9,5,1,9],
   * [2,7,6,2]]
   *
   * Output: 1
   *
   * Explanation:
   *
   * The following subgrid is a 3 x 3 magic square:
   *
   * 438
   * 951
   * 276
   *
   * while this one is not:
   *
   * 384
   * 519
   * 762
   *
   * In total, there is only one magic square inside the given grid.
   *
   * Note:
   *
   * 1 <= grid.length <= 10
   *
   * 1 <= grid[0].length <= 10
   *
   * 0 <= grid[i][j] <= 15
   *
   * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
   *
   * 给定一个由整数组成的 N × N 矩阵，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
   *
   *
   *
   * 示例 1:
   *
   * 输入:
   *
   * [[4,3,8,4],
   * [9,5,1,9],
   * [2,7,6,2]]
   *
   * 输出: 1
   *
   * 解释:
   *
   * 下面的子矩阵是一个 3 x 3 的幻方：
   *
   * 438
   * 951
   * 276
   *
   * 而这一个不是：
   *
   * 384
   * 519
   * 762
   *
   * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
   *
   * 提示:
   *
   * 1 <= grid.length = grid[0].length <= 10
   *
   * 0 <= grid[i][j] <= 15
   */
  class Solution {

    public int numMagicSquaresInside(int[][] grid) {
      if (grid.length < 3 || grid[0].length < 3) {
        return 0;
      }
      int sum = 0;
      int[] bit = new int[16];
      for (int i = 1; i <= 9; i++) {
        bit[i] = 1;
      }
      int[] window = new int[16];
      for (int x = 0; x < grid.length - 2; x++) {
        if (x % 2 == 0) {
          for (int y = 0; y < grid[0].length - 2; y++) {
            if (y == 0) {
              if (x == 0) {
                for (int i = 0; i < 3; i++) {
                  for (int j = 0; j < 3; j++) {
                    window[grid[x + i][y + j]]++;
                  }
                }
              } else {
                for (int i = 0; i < 3; i++) {
                  window[grid[x - 1][y + i]]--;
                  window[grid[x + 2][y + i]]++;
                }
              }
            } else {
              for (int i = 0; i < 3; i++) {
                window[grid[x + i][y - 1]]--;
                window[grid[x + i][y + 2]]++;
              }
            }
            if (Arrays.equals(window, bit) && valid(grid, x, y)) {
              sum++;
            }
          }
        } else {
          for (int y = grid[0].length - 3; y >= 0; y--) {
            if (y == grid[0].length - 3) {
              for (int i = 0; i < 3; i++) {
                window[grid[x - 1][y + i]]--;
                window[grid[x + 2][y + i]]++;
              }
            } else {
              for (int i = 0; i < 3; i++) {
                window[grid[x + i][y + 3]]--;
                window[grid[x + i][y]]++;
              }
            }
            if (Arrays.equals(window, bit) && valid(grid, x, y)) {
              sum++;
            }
          }
        }


      }
      return sum;
    }

    private boolean valid(int[][] grid, int x, int y) {
      int[] r = new int[3];
      int[] c = new int[3];
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          r[i] += grid[x + i][y + j];
          c[j] += grid[x + i][y + j];
        }
      }
      for (int i = 1; i < r.length; i++) {
        if (r[0] != r[i]) {
          return false;
        }
      }
      return Arrays.equals(r, c) && diagonals(grid, x, y, r[0]);
    }

    private boolean diagonals(int[][] grid, int x, int y, int target) {
      int diagonals0 = grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2];
      int diagonals1 = grid[x + 2][y] + grid[x + 1][y + 1] + grid[x][y + 2];
      return diagonals0 == diagonals1 && diagonals0 == target;
    }
  }
}
