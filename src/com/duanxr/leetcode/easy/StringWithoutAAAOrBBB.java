package com.duanxr.leetcode.easy;

/**
 * @author Duanran 2019/2/25 0025
 */
public class StringWithoutAAAOrBBB {

  /**
   * Given two integers A and B, return any string S such that:
   *
   * S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
   *
   * The substring 'aaa' does not occur in S;
   *
   * The substring 'bbb' does not occur in S.
   *
   *
   * Example 1:
   *
   * Input: A = 1, B = 2
   *
   * Output: "abb"
   *
   * Explanation: "abb", "bab" and "bba" are all correct answers.
   *
   * Example 2:
   *
   * Input: A = 4, B = 1
   *
   * Output: "aabaa"
   *
   *
   * Note:
   *
   * 0 <= A <= 100
   *
   * 0 <= B <= 100
   *
   * It is guaranteed such an S exists for the given A and B.
   *
   * 给定两个整数 A 和 B，返回任意字符串 S，要求满足：
   *
   * S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
   *
   * 子串 'aaa' 没有出现在 S 中；
   *
   * 子串 'bbb' 没有出现在 S 中。
   *
   *
   * 示例 1：
   *
   * 输入：A = 1, B = 2
   *
   * 输出："abb"
   *
   * 解释："abb", "bab" 和 "bba" 都是正确答案。
   *
   * 示例 2：
   *
   * 输入：A = 4, B = 1
   *
   * 输出："aabaa"
   *
   *
   * 提示：
   *
   * 0 <= A <= 100
   *
   * 0 <= B <= 100
   *
   * 对于给定的 A 和 B，保证存在满足要求的 S。
   */
  class Solution {

    public String strWithout3a3b(int A, int B) {
      StringBuilder sb = new StringBuilder();
      int countA = 0;
      int countB = 0;
      while (A > 0 || B > 0) {
        if (countA == 2) {
          sb.append('b');
          countB++;
          countA = 0;
          B--;
        } else if (countB == 2) {
          sb.append('a');
          countA++;
          countB = 0;
          A--;
        } else if (A > B) {
          sb.append('a');
          countA++;
          countB = 0;
          A--;
        } else {
          sb.append('b');
          countB++;
          countA = 0;
          B--;
        }
      }
      return sb.toString();
    }
  }
}
