package com.duanxr.yith.midium;

/**
 * @author 段然 2021/3/12
 */
public class OneAwayLcci {

  /**
   * There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
   *
   *  
   *
   * Example 1:
   *
   * Input:
   * first = "pale"
   * second = "ple"
   * Output: True
   * Example 2:
   *
   * Input:
   * first = "pales"
   * second = "pal"
   * Output: False
   *
   * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
   *
   *  
   *
   * 示例 1:
   *
   * 输入:
   * first = "pale"
   * second = "ple"
   * 输出: True
   *  
   *
   * 示例 2:
   *
   * 输入:
   * first = "pales"
   * second = "pal"
   * 输出: False
   *
   */
  class Solution {

    public boolean oneEditAway(String first, String second) {
      if (Math.abs(first.length() - second.length()) > 1) {
        return false;
      }
      if (first.length() == 0 || second.length() == 0) {
        return true;
      }
      char[] charsA = first.toCharArray();
      char[] charsB = second.toCharArray();
      int a = 0;
      int b = 0;
      boolean found = false;

      while (a < charsA.length) {
        if (b == charsB.length) {
          return !found;
        }
        char ca = charsA[a];
        char cb = charsB[b];
        if (ca != cb) {
          if (found) {
            return false;
          }
          if (charsA.length > charsB.length) {
            found = true;
            b--;
          } else if (charsA.length < charsB.length) {
            found = true;
            a--;
          } else {
            found = true;
          }
        }
        a++;
        b++;
      }
      return true;
    }
  }
}
