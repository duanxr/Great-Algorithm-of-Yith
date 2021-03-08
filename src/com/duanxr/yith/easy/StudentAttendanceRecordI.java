package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class StudentAttendanceRecordI {

  /**
   * You are given a string s representing an attendance record for a student. The record only contains the following three characters:
   * 'A': Absent.
   * 'L': Late.
   * 'P': Present.
   * A student could be rewarded if his attendance record does not contain more than one 'A' (absent) or more than two consecutive 'L' (late).
   *
   * Return true if the student could be rewarded according to his attendance record, and false otherwise.
   *
   *  
   *
   * Example 1:
   *
   * Input: s = "PPALLP"
   * Output: true
   * Example 2:
   *
   * Input: s = "PPALLL"
   * Output: false
   *  
   *
   * Constraints:
   *
   * 1 <= s.length <= 1000
   * s[i] is either 'A', 'L', or 'P'.
   *
   * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
   *
   * 'A' : Absent，缺勤
   * 'L' : Late，迟到
   * 'P' : Present，到场
   * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
   *
   * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
   *
   * 示例 1:
   *
   * 输入: "PPALLP"
   * 输出: True
   * 示例 2:
   *
   * 输入: "PPALLL"
   * 输出: False
   *
   */
  class Solution {

    public boolean checkRecord(String s) {
      int L = 0;
      boolean A = false;
      for (char c : s.toCharArray()) {
        if (c == 'A') {
          if (A) {
            return false;
          }
          A = true;
        }
        if (c == 'L') {
          L++;
          if (L > 2) {
            return false;
          }
        } else {
          L = 0;
        }
      }
      return true;
    }
  }
}
