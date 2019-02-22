package com.duanxr.leetcode.easy;

/**
 * @author Duanran 2019/2/22 0022
 */
public class ExcelSheetColumnTitle {

  /**
   * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
   *
   * For example:
   *
   * 1 -> A
   *
   * 2 -> B
   *
   * 3 -> C
   *
   * ...
   *
   * 26 -> Z
   *
   * 27 -> AA
   *
   * 28 -> AB
   *
   * ...
   *
   * Example 1:
   *
   * Input: 1
   *
   * Output: "A"
   *
   * Example 2:
   *
   * Input: 28
   *
   * Output: "AB"
   *
   * Example 3:
   *
   * Input: 701
   *
   * Output: "ZY"
   *
   * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
   *
   * 例如，
   *
   * 1 -> A
   *
   * 2 -> B
   *
   * 3 -> C
   *
   * ...
   *
   * 26 -> Z
   *
   * 27 -> AA
   *
   * 28 -> AB
   *
   * ...
   *
   * 示例 1:
   *
   * 输入: 1
   *
   * 输出: "A"
   *
   * 示例 2:
   *
   * 输入: 28
   *
   * 输出: "AB"
   *
   * 示例 3:
   *
   * 输入: 701
   *
   * 输出: "ZY"
   */
  class Solution {

    public String convertToTitle(int n) {
      StringBuilder sb = new StringBuilder();
      while (n != 0) {
        int bit = n % 26;
        n /= 26;
        char c = getChar(bit);
        if (bit == 0) {
          c = 'Z';
          n--;
        }
        sb.append(c);

      }
      return sb.reverse().toString();
    }

    private char getChar(int n) {
      return (char) ('A' + (n) - 1);
    }
  }
}
