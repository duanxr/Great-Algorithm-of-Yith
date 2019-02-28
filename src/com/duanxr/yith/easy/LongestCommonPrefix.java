package com.duanxr.yith.easy;

import java.util.Arrays;

/**
 * @author Duanran 2019/2/15 0015
 */
public class LongestCommonPrefix {

  /**
   * Write a function to find the longest common prefix string amongst an array of strings.
   *
   * If there is no common prefix, return an empty string "".
   *
   * Example 1:
   *
   * Input: ["flower","flow","flight"]
   *
   * Output: "fl"
   *
   * Example 2:
   *
   * Input: ["dog","racecar","car"]
   *
   * Output: ""
   *
   * Explanation: There is no common prefix among the input strings.
   *
   * Note:
   *
   * All given inputs are in lowercase letters a-z.
   *
   * 编写一个函数来查找字符串数组中的最长公共前缀。
   *
   * 如果不存在公共前缀，返回空字符串 ""。
   *
   * 示例 1:
   *
   * 输入: ["flower","flow","flight"]
   *
   * 输出: "fl"
   *
   * 示例 2:
   *
   * 输入: ["dog","racecar","car"]
   *
   * 输出: ""
   *
   * 解释: 输入不存在公共前缀。
   *
   * 说明:
   *
   * 所有输入只包含小写字母 a-z 。
   */
  class Solution {

    public String longestCommonPrefix(String[] strs) {
      if (strs == null || strs.length == 0) {
        return "";
      }
      char[] chars = strs[0].toCharArray();
      int length = chars.length;
      for (int i = 1; i < strs.length; i++) {
        char[] strChars = strs[i].toCharArray();
        if (strChars.length < length) {
          length = strs[i].length();
        }
        for (int j = 0; j < length; j++) {
          if (chars[j] != strChars[j]) {
            length = j;
          }
        }
      }
      return String.valueOf(Arrays.copyOf(chars, length));
    }
  }
}
