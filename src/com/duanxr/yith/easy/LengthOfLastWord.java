package com.duanxr.yith.easy;

/**
 * @author Duanran 2019/2/27 0027
 */
public class LengthOfLastWord {

  /**
   * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return
   * the length of last word in the string.
   *
   * If the last word does not exist, return 0.
   *
   * Note: A word is defined as a character sequence consists of non-space characters only.
   *
   * Example:
   *
   * Input: "Hello World"
   *
   * Output: 5
   *
   * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
   *
   * 如果不存在最后一个单词，请返回 0 。
   *
   * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
   *
   * 示例:
   *
   * 输入: "Hello World"
   *
   * 输出: 5
   */
  class Solution {

    public int lengthOfLastWord(String s) {
      char[] chars = s.toCharArray();
      int count = 0;
      for (int i = chars.length - 1; i >= 0; i--) {
        if (chars[i] == ' ') {
          if (count != 0) {
            return count;
          }
        } else {
          count++;
        }
      }
      return count;
    }
  }
}
