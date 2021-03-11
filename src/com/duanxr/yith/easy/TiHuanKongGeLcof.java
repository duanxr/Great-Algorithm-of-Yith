package com.duanxr.yith.easy;

import java.util.Arrays;

/**
 * @author 段然 2021/3/11
 */
public class TiHuanKongGeLcof {

  /**
   * English description is not available for the problem.
   *
   * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：s = "We are happy."
   * 输出："We%20are%20happy."
   *  
   *
   * 限制：
   *
   * 0 <= s 的长度 <= 10000
   *
   */
  class Solution {

    public String replaceSpace(String s) {
      StringBuilder sb = new StringBuilder();
      for (char c : s.toCharArray()) {
        sb.append(c == ' ' ? "%20" : c);
      }
      return sb.toString();
    }

    public String replaceSpace1(String s) {
      int spaceNum = 0;
      char[] chars = s.toCharArray();
      for (char c : chars) {
        if (c == ' ') {
          spaceNum++;
        }
      }
      char[] strChars = new char[s.length() + spaceNum * 2];
      int si = 0;
      for (char c : chars) {
        if (c == ' ') {
          strChars[si++] = '%';
          strChars[si++] = '2';
          strChars[si++] = '0';
        } else {
          strChars[si++] = c;
        }
      }
      return new String(strChars);
    }

    public String replaceSpace2(String s) {
      char[] strChars = new char[s.length() * 3];
      int si = 0;
      for (char c : s.toCharArray()) {
        if (c == ' ') {
          strChars[si++] = '%';
          strChars[si++] = '2';
          strChars[si++] = '0';
        } else {
          strChars[si++] = c;
        }
      }
      return new String(strChars,0,si);
    }
  }

}
