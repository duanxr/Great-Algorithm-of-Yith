package com.duanxr.yith.easy;

import java.util.Stack;

/**
 * @author 段然 2021/6/30
 */
public class ComplementOfBaseTenInteger {

  /**
   * Every non-negative integer n has a binary representation.  For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.  Note that except for n = 0, there are no leading zeroes in any binary representation.
   *
   * The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.  For example, the complement of "101" in binary is "010" in binary.
   *
   * For a given number n in base-10, return the complement of it's binary representation as a base-10 integer.
   *
   *  
   *
   * Example 1:
   *
   * Input: n = 5
   * Output: 2
   * Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
   * Example 2:
   *
   * Input: n = 7
   * Output: 0
   * Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
   * Example 3:
   *
   * Input: n = 10
   * Output: 5
   * Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
   *  
   *
   * Note:
   *
   * 0 <= n < 109
   * This question is the same as 476: https://leetcode.com/problems/number-complement/
   *
   * 每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。
   *
   * 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
   *
   * 给你一个十进制数 N，请你返回其二进制表示的反码所对应的十进制整数。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：5
   * 输出：2
   * 解释：5 的二进制表示为 "101"，其二进制反码为 "010"，也就是十进制中的 2 。
   * 示例 2：
   *
   * 输入：7
   * 输出：0
   * 解释：7 的二进制表示为 "111"，其二进制反码为 "000"，也就是十进制中的 0 。
   * 示例 3：
   *
   * 输入：10
   * 输出：5
   * 解释：10 的二进制表示为 "1010"，其二进制反码为 "0101"，也就是十进制中的 5 。
   *  
   *
   * 提示：
   *
   * 0 <= N < 10^9
   * 本题与 476：https://leetcode-cn.com/problems/number-complement/ 相同
   *
   */
  class Solution {

    public int bitwiseComplement(int n) {
      if (n == 0) {
        return 1;
      }
      int checkPoint = (Integer.MAX_VALUE >> 1) ^ Integer.MAX_VALUE;
      int mask = Integer.MAX_VALUE;
      int nn = ~n & Integer.MAX_VALUE >> 1;
      for (int i = 0; i <= 32; i++) {
        if ((n << i & checkPoint) == checkPoint) {
          nn = nn & mask;
          break;
        }
        mask = mask >> 1;
      }
      return nn;
    }
  }

  class Solution1 {

    public int bitwiseComplement(int n) {
      if (n == 0) {
        return 1;
      }
      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < 32; i++) {
        stack.push(n & 1);
        n = n >>> 1;
      }
      int nn = 0;
      boolean hasOne = false;
      while (!stack.isEmpty()) {
        nn = nn << 1;
        Integer pop = stack.pop();
        if (pop == 0 && hasOne) {
          nn += 1;
        } else if (pop == 1) {
          hasOne = true;
        }
      }
      return nn;
    }
  }
}
