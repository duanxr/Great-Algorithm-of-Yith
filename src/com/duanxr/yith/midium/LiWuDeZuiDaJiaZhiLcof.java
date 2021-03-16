package com.duanxr.yith.midium;

/**
 * @author 段然 2021/3/12
 */
public class LiWuDeZuiDaJiaZhiLcof {

  /**
   * English description is not available for the problem.
   *
   * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
   *
   *  
   *
   * 示例 1:
   *
   * 输入:
   * [
   *   [1,3,1],
   *   [1,5,1],
   *   [4,2,1]
   * ]
   * 输出: 12
   * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
   *  
   *
   * 提示：
   *
   * 0 < grid.length <= 200
   * 0 < grid[0].length <= 200
   *
   */
  class Solution {

    public int maxValue(int[][] grid) {
      for (int i = grid.length - 1; i >= 0; i--) {
        int array[] = grid[i];
        for (int j = array.length - 1; j >= 0; j--) {
          int rightMax = j == array.length - 1 ? 0 : grid[i][j + 1];
          int downMax = i == grid.length - 1 ? 0 : grid[i + 1][j];
          grid[i][j] += Math.max(rightMax, downMax);
        }
      }
      return grid[0][0];
    }
  }
}
