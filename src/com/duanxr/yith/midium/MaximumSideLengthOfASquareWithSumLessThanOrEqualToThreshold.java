package com.duanxr.yith.midium;

/**
 * @author 段然 2021/5/28
 */
public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {

  /**
   * Given a m x n matrix mat and an integer threshold. Return the maximum side-length of a square with a sum less than or equal to threshold or return 0 if there is no such square.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
   * Output: 2
   * Explanation: The maximum side length of square with sum less than 4 is 2 as shown.
   * Example 2:
   *
   * Input: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
   * Output: 0
   * Example 3:
   *
   * Input: mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
   * Output: 3
   * Example 4:
   *
   * Input: mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]], threshold = 40184
   * Output: 2
   *  
   *
   * Constraints:
   *
   * 1 <= m, n <= 300
   * m == mat.length
   * n == mat[i].length
   * 0 <= mat[i][j] <= 10000
   * 0 <= threshold <= 10^5
   *
   * 给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
   *
   * 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
   *  
   *
   * 示例 1：
   *
   *
   *
   * 输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
   * 输出：2
   * 解释：总和小于或等于 4 的正方形的最大边长为 2，如图所示。
   * 示例 2：
   *
   * 输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
   * 输出：0
   * 示例 3：
   *
   * 输入：mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
   * 输出：3
   * 示例 4：
   *
   * 输入：mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]], threshold = 40184
   * 输出：2
   *  
   *
   * 提示：
   *
   * 1 <= m, n <= 300
   * m == mat.length
   * n == mat[i].length
   * 0 <= mat[i][j] <= 10000
   * 0 <= threshold <= 10^5
   *
   */
  class Solution {

    public int maxSideLength(int[][] mat, int threshold) {

      int maxSize = 0;
      for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat[i].length; j++) {
          int current = mat[i][j];
          if (i != 0) {
            mat[i][j] += mat[i - 1][j];
          }
          if (j != 0) {
            mat[i][j] += mat[i][j - 1];
          }
          if (i != 0 && j != 0) {
            mat[i][j] -= mat[i - 1][j - 1];
          }
          if (current < threshold) {
            if (maxSize == 0) {
              maxSize = 1;
            }
            int k = maxSize;//优化2
            while (i - k >= -1 && j - k >= -1) {
              int sum = mat[i][j];
              if (i - k >= 0) {
                sum -= mat[i - k][j];
              }
              if (j - k >= 0) {
                sum -= mat[i][j - k];
              }
              if (i - k >= 0 && j - k >= 0) {
                sum += mat[i - k][j - k];
              }
              if (sum <= threshold) {
                maxSize = Math.max(maxSize, k);
              } else {
                //优化1
                break;
              }
              k++;
            }
          }
        }
      }
      return maxSize;
    }
  }


  class Solution1 {

    public int maxSideLength(int[][] mat, int threshold) {
      int maxSize = 0;
      for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat[i].length; j++) {
           /* if (mat[i][j] <= threshold) {
              maxSize = Math.max(maxSize, 1);
            }*/
          if (i != 0) {
            mat[i][j] += mat[i - 1][j];
          }
          if (j != 0) {
            mat[i][j] += mat[i][j - 1];
          }
          if (i != 0 && j != 0) {
            mat[i][j] -= mat[i - 1][j - 1];
          }
          int k = 1;
          while (i - k >= -1 && j - k >= -1) {
            int sum = mat[i][j];
            if (i - k >= 0) {
              sum -= mat[i - k][j];
            }
            if (j - k >= 0) {
              sum -= mat[i][j - k];
            }
            if (i - k >= 0 && j - k >= 0) {
              sum += mat[i - k][j - k];
            }
            if (sum <= threshold) {
              maxSize = Math.max(maxSize, k);
            }
            //System.out.println("i:"+i+" - j:"+j +" - k:"+k+" - sum:"+sum );
            k++;
          }
        }
      }
      //System.out.println(Arrays.deepToString(mat));
      return maxSize;
    }
  }
}
