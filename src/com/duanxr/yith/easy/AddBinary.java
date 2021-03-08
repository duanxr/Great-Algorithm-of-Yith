package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class AddBinary {

  /**
   * Given two binary strings a and b, return their sum as a binary string.
   *
   *  
   *
   * Example 1:
   *
   * Input: a = "11", b = "1"
   * Output: "100"
   * Example 2:
   *
   * Input: a = "1010", b = "1011"
   * Output: "10101"
   *  
   *
   * Constraints:
   *
   * 1 <= a.length, b.length <= 104
   * a and b consist only of '0' or '1' characters.
   * Each string does not contain leading zeros except for the zero itself.
   *
   * 给你两个二进制字符串，返回它们的和（用二进制表示）。
   *
   * 输入为 非空 字符串且只包含数字 1 和 0。
   *
   *  
   *
   * 示例 1:
   *
   * 输入: a = "11", b = "1"
   * 输出: "100"
   * 示例 2:
   *
   * 输入: a = "1010", b = "1011"
   * 输出: "10101"
   *  
   *
   * 提示：
   *
   * 每个字符串仅由字符 '0' 或 '1' 组成。
   * 1 <= a.length, b.length <= 10^4
   * 字符串如果不是 "0" ，就都不含前导零。
   *
   */
  class Solution {

    public String addBinary(String a, String b) {
      StringBuilder sb = new StringBuilder();
      int add = 0;
      int i = 0;
      while (i < a.length() || i < b.length() || add != 0) {
        int ca = getChar(a, i);
        int cb = getChar(b, i);
        int count = add + ca + cb;
        if (count <= 0) {
          sb.append(count);
        } else {
          add = count / 2;
          sb.append(count % 2);
        }
        i++;
      }
      return sb.reverse().toString();
    }

    private int getChar(String s, int i) {
      i = s.length() - i - 1;
      return i >= 0 && s.charAt(i) == '1' ? 1 : 0;
    }
  }
}
