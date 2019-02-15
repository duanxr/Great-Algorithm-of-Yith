package com.duanxr.leetcode.easy;

import java.util.Arrays;

/**
 * @author Duanran 2019/2/15 0015
 */
public class LongestCommonPrefix {

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
