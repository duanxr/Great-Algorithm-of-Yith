package com.duanxr.yith.midium;

/**
 * @author 段然 2021/3/18
 */
public class JiQiRenDeYunDongFanWeiLcof {

  /**
   * English description is not available for the problem.
   *
   * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
   *
   *  
   *
   * 示例 1：
   *
   * 输入：m = 2, n = 3, k = 1
   * 输出：3
   * 示例 2：
   *
   * 输入：m = 3, n = 1, k = 0
   * 输出：1
   * 提示：
   *
   * 1 <= n,m <= 100
   * 0 <= k <= 20
   *
   */
  class Solution {

    public int movingCount(int m, int n, int k) {
      byte[][] bit = new byte[m][n];
      return move(0, 0, m, n, k, bit);
    }

    private int move(int x, int y, int m, int n, int k, byte[][] bit) {
      if (x == m || y == n || bit[x][y] == 1) {
        return 0;
      }
      bit[x][y] = 1;
      if (bitSum(x) + bitSum(y) > k) {
        return 0;
      }
      return 1 + move(x + 1, y, m, n, k, bit) + move(x, y + 1, m, n, k, bit);
    }

    private int bitSum(int i) {
      int n = 0;
      while (i != 0) {
        n += i % 10;
        i /= 10;
      }
      return n;
    }
  }
}
