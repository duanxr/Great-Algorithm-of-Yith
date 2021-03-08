package com.duanxr.yith.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 段然 2021/3/8
 */
public class PascalsTriangleII {

  /**
   * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
   *
   * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
   *
   *
   *  
   *
   * Example 1:
   *
   * Input: rowIndex = 3
   * Output: [1,3,3,1]
   * Example 2:
   *
   * Input: rowIndex = 0
   * Output: [1]
   * Example 3:
   *
   * Input: rowIndex = 1
   * Output: [1,1]
   *  
   *
   * Constraints:
   *
   * 0 <= rowIndex <= 33
   *  
   *
   * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
   *
   *
   * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
   *
   *
   *
   * 在杨辉三角中，每个数是它左上方和右上方的数的和。
   *
   * 示例:
   *
   * 输入: 3
   * 输出: [1,3,3,1]
   * 进阶：
   *
   * 你可以优化你的算法到 O(k) 空间复杂度吗？
   *
   */
  class Solution {

    public List<Integer> getRow(int rowIndex) {
      int[] lastrow;
      int[] row = new int[rowIndex + 1];
      row[0] = 1;
      for (int i = 1; i <= rowIndex; i++) {
        lastrow = Arrays.copyOf(row, i + 1);
        for (int j = 1; j <= i; j++) {
          int left = lastrow[j - 1];
          int right = lastrow[j];
          row[j] = left + right;
        }
      }
      List<Integer> result = new ArrayList<>(rowIndex);
      for (int i = 0; i < row.length; i++) {
        result.add(row[i]);
      }
      return result;
    }
  }
}
