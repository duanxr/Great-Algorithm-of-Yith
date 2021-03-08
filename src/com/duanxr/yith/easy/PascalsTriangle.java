package com.duanxr.yith.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/3/8
 */
public class PascalsTriangle {

  /**
   * Given an integer numRows, return the first numRows of Pascal's triangle.
   *
   * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
   *
   *
   *  
   *
   * Example 1:
   *
   * Input: numRows = 5
   * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
   * Example 2:
   *
   * Input: numRows = 1
   * Output: [[1]]
   *  
   *
   * Constraints:
   *
   * 1 <= numRows <= 30
   *
   * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
   *
   *
   *
   * 在杨辉三角中，每个数是它左上方和右上方的数的和。
   *
   * 示例:
   *
   * 输入: 5
   * 输出:
   * [
   *      [1],
   *     [1,1],
   *    [1,2,1],
   *   [1,3,3,1],
   *  [1,4,6,4,1]
   * ]
   *
   */
  class Solution {

    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> result = new ArrayList<>(numRows);
      List<Integer> lastRow = null;
      for (int i = 0; i < numRows; i++) {
        List<Integer> row = new ArrayList<>(i + 1);
        for (int j = 0; j < i + 1; j++) {
          if (j == 0 || j == i) {
            row.add(1);
          } else {
            row.add(lastRow.get(j) + lastRow.get(j - 1));
          }
        }
        lastRow = row;
        result.add(row);
      }
      return result;
    }
  }
}
