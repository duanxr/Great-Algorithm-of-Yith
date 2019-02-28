package com.duanxr.yith.easy;

/**
 * @author Duanran 2019/2/26 0026
 */
public class ValidPalindromeII {

  /**
   * Given a non-empty string s, you may delete at most one character. Judge whether you can make it
   * a palindrome.
   *
   * Example 1:
   *
   * Input: "aba"
   *
   * Output: True
   *
   * Example 2:
   *
   * Input: "abca"
   *
   * Output: True
   *
   * Explanation: You could delete the character 'c'.
   *
   * Note:
   *
   * The string will only contain lowercase characters a-z. The maximum length of the string is
   * 50000.
   *
   * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
   *
   * 示例 1:
   *
   * 输入: "aba"
   *
   * 输出: True
   *
   * 示例 2:
   *
   * 输入: "abca"
   *
   * 输出: True
   *
   * 解释: 你可以删除c字符。
   *
   * 注意:
   *
   * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
   */
  class Solution {

    public boolean validPalindrome(String s) {
      char[] chars = s.toCharArray();
      int left = 0;
      int right = chars.length - 1;
      boolean fix = false;
      while (left < right) {
        if (chars[left] != chars[right]) {
          if (fix) {
            return false;
          }
          fix = true;
          if (chars[left + 1] == chars[right] && (((left + 2) > right) || (chars[left + 2] == chars[
              right - 1]))) {
            left++;
            continue;
          } else if (chars[left] == chars[right - 1] && (((right - 2) < left) || (chars[left + 1]
              == chars[right - 2]))) {
            right--;
            continue;
          }
          return false;
        } else {
          left++;
          right--;
        }
      }
      return true;
    }
  }
}
