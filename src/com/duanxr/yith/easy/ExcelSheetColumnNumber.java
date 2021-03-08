package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class ExcelSheetColumnNumber {

  /**
   * Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.
   *
   * For example:
   *
   * A -> 1
   * B -> 2
   * C -> 3
   * ...
   * Z -> 26
   * AA -> 27
   * AB -> 28
   * ...
   *  
   *
   * Example 1:
   *
   * Input: columnTitle = "A"
   * Output: 1
   * Example 2:
   *
   * Input: columnTitle = "AB"
   * Output: 28
   * Example 3:
   *
   * Input: columnTitle = "ZY"
   * Output: 701
   * Example 4:
   *
   * Input: columnTitle = "FXSHRXW"
   * Output: 2147483647
   *  
   *
   * Constraints:
   *
   * 1 <= columnTitle.length <= 7
   * columnTitle consists only of uppercase English letters.
   * columnTitle is in the range ["A", "FXSHRXW"].
   *
   * 给定一个Excel表格中的列名称，返回其相应的列序号。
   *
   * 例如，
   *
   *     A -> 1
   *     B -> 2
   *     C -> 3
   *     ...
   *     Z -> 26
   *     AA -> 27
   *     AB -> 28
   *     ...
   * 示例 1:
   *
   * 输入: "A"
   * 输出: 1
   * 示例 2:
   *
   * 输入: "AB"
   * 输出: 28
   * 示例 3:
   *
   * 输入: "ZY"
   * 输出: 701
   *
   */
  class Solution {

    public int titleToNumber(String s) {
      int sum = 0;
      for (int i = s.length() - 1; i >= 0; i--) {
        char c = s.charAt(i);
        int now = c - 'A';
        now++;
        sum += now * Math.pow(26, s.length() - 1 - i);
      }
      return sum;
    }
  }
}
