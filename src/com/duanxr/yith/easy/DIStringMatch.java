package com.duanxr.yith.easy;

/**
 * @author Duanran 2019/1/28 0028
 */
public class DIStringMatch {

  /**
   * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
   *
   * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
   *
   * If S[i] == "I", then A[i] < A[i+1]
   *
   * If S[i] == "D", then A[i] > A[i+1]
   *
   *
   * Example 1:
   *
   * Input: "IDID"
   *
   * Output: [0,4,1,3,2]
   *
   * Example 2:
   *
   * Input: "III"
   *
   * Output: [0,1,2,3]
   *
   * Example 3:
   *
   * Input: "DDI"
   *
   * Output: [3,2,0,1]
   *
   * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
   *
   * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
   *
   * 如果 S[i] == "I"，那么 A[i] < A[i+1]
   *
   * 如果 S[i] == "D"，那么 A[i] > A[i+1]
   *
   *
   * 示例 1：
   *
   * 输出："IDID"
   *
   * 输出：[0,4,1,3,2]
   *
   * 示例 2：
   *
   * 输出："III"
   *
   * 输出：[0,1,2,3]
   *
   * 示例 3：
   *
   * 输出："DDI"
   *
   * 输出：[3,2,0,1]
   */
  class Solution {

    public int[] diStringMatch(String S) {
      int[] result = new int[S.length() + 1];
      int s = 0;
      int b = S.length();
      for (int i = 0; i < result.length; i++) {
        if (i == S.length()) {
          result[i] = s;
        } else {
          if (S.charAt(i) == 'I') {
            result[i] = s;
            s++;
          } else {
            result[i] = b;
            b--;
          }
        }
      }
      return result;
    }
  }
}
