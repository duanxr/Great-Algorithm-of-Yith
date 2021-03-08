package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class AddStrings {

  /**
   * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
   *
   * Note:
   *
   * The length of both num1 and num2 is < 5100.
   * Both num1 and num2 contains only digits 0-9.
   * Both num1 and num2 does not contain any leading zero.
   * You must not use any built-in BigInteger library or convert the inputs to integer directly.
   *
   * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
   *
   *  
   *
   * 提示：
   *
   * num1 和num2 的长度都小于 5100
   * num1 和num2 都只包含数字 0-9
   * num1 和num2 都不包含任何前导零
   * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
   *
   */
  class Solution {

    public String addStrings(String num1, String num2) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
        if (sb.length() == i + 1) {
          int sum = getInt(num1, i) + getInt(num2, i) + (sb.charAt(sb.length() - 1) - '0');
          sb.setLength(sb.length() - 1);
          append(sb, sum);
        } else {
          int sum = getInt(num1, i) + getInt(num2, i);
          append(sb, sum);
        }
      }
      return sb.reverse().toString();
    }

    private void append(StringBuilder sb, int sum) {
      do {
        sb.append(sum % 10);
        sum /= 10;
      } while (sum != 0);
    }

    private int getInt(String str, int i) {
      if (i < str.length()) {
        return str.charAt((str.length() - 1) - i) - '0';
      }
      return 0;
    }
  }
}
