package com.duanxr.leetcode.easy;

/**
 * @author Duanran 2019/1/22 0022
 */
public class ValidPalindrome {

  /**
   * Given a string, determine if it is a palindrome, considering only alphanumeric characters and
   * ignoring cases.
   *
   * Note: For the purpose of this problem, we define empty string as valid palindrome.
   *
   * Example 1:
   *
   * Input: "A man, a plan, a canal: Panama"
   *
   * Output: true
   *
   * Example 2:
   *
   * Input: "race a car"
   *
   * Output: false
   *
   * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
   *
   * 说明：本题中，我们将空字符串定义为有效的回文串。
   *
   * 示例 1:
   *
   * 输入: "A man, a plan, a canal: Panama"
   *
   * 输出: true
   *
   * 示例 2:
   *
   * 输入: "race a car"
   *
   * 输出: false
   */
  class Solution {

    public boolean isPalindrome(String s) {
      int l = 0;
      int r = s.length() - 1;
      while (l < r) {
        if (!Character.isLetter(s.charAt(l)) && !Character.isDigit(s.charAt(l))) {
          l++;
          continue;
        }
        if (!Character.isLetter(s.charAt(r)) && !Character.isDigit(s.charAt(r))) {
          r--;
          continue;
        }
        if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {

          return false;
        }
        l++;
        r--;
      }
      return true;
    }
  }
}
