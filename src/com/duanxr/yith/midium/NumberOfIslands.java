package com.duanxr.yith.midium;

/**
 * @author 段然 2021/5/21
 */
public class NumberOfIslands {

  /**
   * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
   *
   * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
   *
   *  
   *
   * Example 1:
   *
   * Input: grid = [
   *   ["1","1","1","1","0"],
   *   ["1","1","0","1","0"],
   *   ["1","1","0","0","0"],
   *   ["0","0","0","0","0"]
   * ]
   * Output: 1
   * Example 2:
   *
   * Input: grid = [
   *   ["1","1","0","0","0"],
   *   ["1","1","0","0","0"],
   *   ["0","0","1","0","0"],
   *   ["0","0","0","1","1"]
   * ]
   * Output: 3
   *  
   *
   * Constraints:
   *
   * m == grid.length
   * n == grid[i].length
   * 1 <= m, n <= 300
   * grid[i][j] is '0' or '1'.
   *
   * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
   *
   * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
   *
   * 此外，你可以假设该网格的四条边均被水包围。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：grid = [
   *   ["1","1","1","1","0"],
   *   ["1","1","0","1","0"],
   *   ["1","1","0","0","0"],
   *   ["0","0","0","0","0"]
   * ]
   * 输出：1
   * 示例 2：
   *
   * 输入：grid = [
   *   ["1","1","0","0","0"],
   *   ["1","1","0","0","0"],
   *   ["0","0","1","0","0"],
   *   ["0","0","0","1","1"]
   * ]
   * 输出：3
   *  
   *
   * 提示：
   *
   * m == grid.length
   * n == grid[i].length
   * 1 <= m, n <= 300
   * grid[i][j] 的值为 '0' 或 '1'
   *
   */
  class Solution {

    public int numIslands(char[][] grid) {
      int islands = 0;
      int gridLength = grid.length;
      int rowsLength = grid[0].length;
      for (int j = 0; j < gridLength; j++) {
        for (int i = 0; i < rowsLength; i++) {
          if (isIsland(grid, j, i)) {
            islands++;
          }
        }
      }
      return islands;
    }

    private boolean isIsland(char[][] grid, int i, int j) {
      if (grid[i][j] != '1') {
        return false;
      }
      grid[i][j] = '1';
      if (i < grid.length - 1) {
        isIsland(grid, i + 1, j);
      }
      if (i > 0) {
        isIsland(grid, i - 1, j);
      }
      if (j < grid[0].length - 1) {
        isIsland(grid, i, j + 1);
      }
      if (j > 0) {
        isIsland(grid, i, j - 1);
      }
      return true;
    }
  }


  class Solution2 {

    public int numIslands(char[][] grid) {
      int islands = 0;
      int gridLength = grid.length;
      int rowsLength = grid[0].length;
      byte[][] visited = new byte[grid.length][grid[0].length];
      for (int j = 0; j < gridLength; j++) {
        for (int i = 0; i < rowsLength; i++) {
          if (isIsland(grid, visited, j, i)) {
            islands++;
          }
        }
      }
      return islands;
    }

    private boolean isIsland(char[][] grid, byte[][] visited, int i, int j) {
      if (grid[i][j] == '0' || visited[i][j] != 0) {
        return false;
      }
      visited[i][j] = 1;
      if (i < grid.length - 1) {
        isIsland(grid, visited, i + 1, j);
      }
      if (i > 0) {
        isIsland(grid, visited, i - 1, j);
      }
      if (j < grid[0].length - 1) {
        isIsland(grid, visited, i, j + 1);
      }
      if (j > 0) {
        isIsland(grid, visited, i, j - 1);
      }
      return true;
    }
  }


  class Solution1 {

    public int numIslands(char[][] grid) {
      int islands = 0;
      int[][] visited = new int[grid.length][grid[0].length];
      for (int j = 0, gridLength = grid.length; j < gridLength; j++) {
        char[] rows = grid[j];
        for (int i = 0, rowsLength = rows.length; i < rowsLength; i++) {
          if (isIsland(grid, visited, j, i)) {
            islands++;
          }
        }
      }
      return islands;
    }

    private boolean isIsland(char[][] grid, int[][] visited, int i, int j) {
      int gridLength = grid.length;
      int rowsLength = grid[0].length;
      if (i < 0 || j < 0 || i >= gridLength || j >= rowsLength || grid[i][j] == '0'
          || visited[i][j] != 0) {
        return false;
      }
      visited[i][j] = 1;
      isIsland(grid, visited, i + 1, j);
      isIsland(grid, visited, i - 1, j);
      isIsland(grid, visited, i, j + 1);
      isIsland(grid, visited, i, j - 1);
      return true;
    }
  }


  class Solution1x {

    public int numIslands(char[][] grid) {
      int islands = 0;
      int[][] visited = new int[grid.length][grid[0].length];
      for (int j = 0, gridLength = grid.length; j < gridLength; j++) {
        char[] rows = grid[j];
        for (int i = 0, rowsLength = rows.length; i < rowsLength; i++) {
          if (isIsland(grid, visited, j, i)) {
            islands++;
          }
        }
      }
      return islands;
    }

    private boolean isIsland(char[][] grid, int[][] visited, int i, int j) {
      int gridLength = grid.length;
      int rowsLength = grid[0].length;
      if (i < 0 || j < 0 || i >= gridLength || j >= rowsLength || grid[i][j] == 0) {
        return true; //深海
      }
      if (visited[i][j] != 0) {
        return visited[i][j] == 1;
      }
      if (i == 0 || j == 0 || i == gridLength - 1 || j == rowsLength - 1) {
        visited[i][j] = 2;//陆地.
        return false;
      }
      visited[i][j] = 1;
      boolean isIsland =
          isIsland(grid, visited, i + 1, j) && isIsland(grid, visited, i - 1, j) && isIsland(grid,
              visited, i, j + 1) && isIsland(grid, visited, i, j - 1);
      if (!isIsland) {
        visited[i][j] = 2;
      }
      return isIsland;
    }
  }
}
