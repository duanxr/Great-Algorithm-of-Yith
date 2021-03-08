package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class RotateString {

  /**
   * We are given two strings, A and B.
   *
   * A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
   *
   * Example 1:
   * Input: A = 'abcde', B = 'cdeab'
   * Output: true
   *
   * Example 2:
   * Input: A = 'abcde', B = 'abced'
   * Output: false
   * Note:
   *
   * A and B will have length at most 100.
   *
   * 给定两个字符串, A 和 B。
   *
   * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
   *
   * 示例 1:
   * 输入: A = 'abcde', B = 'cdeab'
   * 输出: true
   *
   * 示例 2:
   * 输入: A = 'abcde', B = 'abced'
   * 输出: false
   * 注意：
   *
   * A 和 B 长度不超过 100。
   *
   */
  class Solution {

    public boolean rotateString(String A, String B) {
      if ("".equals(A) && "".equals(B)) {
        return true;
      }
      if (A.length() != B.length()) {
        return false;
      }

      char s = A.charAt(0);
      fora:
      for (int i = 0; i < B.length(); i++) {
        if (B.charAt(i) == s) {
          int ai = 0;
          int bi = i;
          while (true) {
            if (A.charAt(ai) == B.charAt(bi)) {
              ai++;
              if (ai == A.length()) {
                return true;
              }
              bi++;
              if (bi == B.length()) {
                bi = 0;
              }
            } else {
              continue fora;
            }
          }
        }
      }
      return false;
    }
  }
}
