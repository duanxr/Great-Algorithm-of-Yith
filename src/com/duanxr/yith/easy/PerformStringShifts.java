package com.duanxr.yith.easy;

/**
 * @author 段然 2021/5/13
 */
public class PerformStringShifts {

  /**
   * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [directioni, amounti]:
   *
   * directioni can be 0 (for left shift) or 1 (for right shift).
   * amounti is the amount by which string s is to be shifted.
   * A left shift by 1 means remove the first character of s and append it to the end.
   * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
   * Return the final string after all operations.
   *
   *  
   *
   * Example 1:
   *
   * Input: s = "abc", shift = [[0,1],[1,2]]
   * Output: "cab"
   * Explanation: 
   * [0,1] means shift to left by 1. "abc" -> "bca"
   * [1,2] means shift to right by 2. "bca" -> "cab"
   * Example 2:
   *
   * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
   * Output: "efgabcd"
   * Explanation: 
   * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
   * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
   * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
   * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
   *  
   *
   * Constraints:
   *
   * 1 <= s.length <= 100
   * s only contains lower case English letters.
   * 1 <= shift.length <= 100
   * shift[i].length == 2
   * directioni is either 0 or 1.
   * 0 <= amounti <= 100
   *
   * 给定一个包含小写英文字母的字符串 s 以及一个矩阵 shift，其中 shift[i] = [direction, amount]：
   *
   * direction 可以为 0 （表示左移）或 1 （表示右移）。
   * amount 表示 s 左右移的位数。
   * 左移 1 位表示移除 s 的第一个字符，并将该字符插入到 s 的结尾。
   * 类似地，右移 1 位表示移除 s 的最后一个字符，并将该字符插入到 s 的开头。
   * 对这个字符串进行所有操作后，返回最终结果。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：s = "abc", shift = [[0,1],[1,2]]
   * 输出："cab"
   * 解释：
   * [0,1] 表示左移 1 位。 "abc" -> "bca"
   * [1,2] 表示右移 2 位。 "bca" -> "cab"
   * 示例 2：
   *
   * 输入：s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
   * 输出："efgabcd"
   * 解释：
   * [1,1] 表示右移 1 位。 "abcdefg" -> "gabcdef"
   * [1,1] 表示右移 1 位。 "gabcdef" -> "fgabcde"
   * [0,2] 表示左移 2 位。 "fgabcde" -> "abcdefg"
   * [1,3] 表示右移 3 位。 "abcdefg" -> "efgabcd"
   *  
   *
   * 提示：
   *
   * 1 <= s.length <= 100
   * s 只包含小写英文字母
   * 1 <= shift.length <= 100
   * shift[i].length == 2
   * 0 <= shift[i][0] <= 1
   * 0 <= shift[i][1] <= 100
   *
   */
  class Solution {

    public String stringShift(String s, int[][] shift) {
      int mov = 0;
      for (int[] ints : shift) {
        mov += ints[0] == 1 ? -ints[1] : ints[1];
      }
      mov %= s.length();
      if (mov == 0) {
        return s;
      }
      mov += s.length();
      mov %= s.length();
      return s.substring(mov) + s.substring(0, mov);
    }
  }
}
