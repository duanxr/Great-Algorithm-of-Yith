package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class SurfaceAreaOf3DShapes {

  /**
   * You are given an n x n grid where you have placed some 1 x 1 x 1 cubes. Each value v = grid[i][j] represents a tower of v cubes placed on top of cell (i, j).
   *
   * After placing these cubes, you have decided to glue any directly adjacent cubes to each other, forming several irregular 3D shapes.
   *
   * Return the total surface area of the resulting shapes.
   *
   * Note: The bottom face of each shape counts toward its surface area.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: grid = [[2]]
   * Output: 10
   * Example 2:
   *
   *
   * Input: grid = [[1,2],[3,4]]
   * Output: 34
   * Example 3:
   *
   *
   * Input: grid = [[1,0],[0,2]]
   * Output: 16
   * Example 4:
   *
   *
   * Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
   * Output: 32
   * Example 5:
   *
   *
   * Input: grid = [[2,2,2],[2,1,2],[2,2,2]]
   * Output: 46
   *  
   *
   * Constraints:
   *
   * n == grid.length
   * n == grid[i].length
   * 1 <= n <= 50
   * 0 <= grid[i][j] <= 50
   *
   * 给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。
   *
   * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
   *
   * 放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
   *
   * 请你返回最终这些形体的总表面积。
   *
   * 注意：每个形体的底面也需要计入表面积中。
   *
   *  
   *
   * 示例 1：
   *
   *
   * 输入：grid = [[2]]
   * 输出：10
   * 示例 2：
   *
   *
   * 输入：grid = [[1,2],[3,4]]
   * 输出：34
   * 示例 3：
   *
   *
   * 输入：grid = [[1,0],[0,2]]
   * 输出：16
   * 示例 4：
   *
   *
   * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
   * 输出：32
   * 示例 5：
   *
   *
   * 输入：grid = [[2,2,2],[2,1,2],[2,2,2]]
   * 输出：46
   *  
   *
   * 提示：
   *
   * n == grid.length
   * n == grid[i].length
   * 1 <= n <= 50
   * 0 <= grid[i][j] <= 50
   *
   */
  class Solution {

    public int surfaceArea(int[][] grid) {
      int sum = 0;
      if (grid.length == 0) {
        return 0;
      }
      int[] upHigh = new int[grid[0].length];
      for (int i = 0; i < grid.length; i++) {
        int[] row = grid[i];
        int leftHigh = 0;
        for (int j = 0; j < row.length; j++) {
          int h = row[j];
          sum += Math.abs(leftHigh - h);
          sum += Math.abs(upHigh[j] - h);
          upHigh[j] = h;
          leftHigh = h;
          if (h != 0) {
            sum += 2;
          }
          if (i == grid.length - 1) {
            sum += h;
          }
        }
        sum += leftHigh;
      }
      return sum;
    }
  }
}
