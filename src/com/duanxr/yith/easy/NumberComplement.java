package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class NumberComplement {

  /**
   * Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.
   *
   *  
   *
   * Example 1:
   *
   * Input: num = 5
   * Output: 2
   * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
   * Example 2:
   *
   * Input: num = 1
   * Output: 0
   * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
   *  
   *
   * Constraints:
   *
   * The given integer num is guaranteed to fit within the range of a 32-bit signed integer.
   * num >= 1
   * You could assume no leading zero bit in the integer’s binary representation.
   * This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
   *
   * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：num = 5
   * 输出：2
   * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
   * 示例 2：
   *
   * 输入：num = 1
   * 输出：0
   * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
   *  
   *
   * 提示：
   *
   * 给定的整数 num 保证在 32 位带符号整数的范围内。
   * num >= 1
   * 你可以假定二进制数不包含前导零位。
   * 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
   *
   */
  class Solution {
    public int findComplement(int num) {
      int mask = ~0;
      int tn = num;
      while (tn!=0)
      {
        tn=tn>>>1;
        mask = mask<<1;
      }
      return ~(num|mask);
    }
  }
  class Solution1 {

    public int findComplement(int num) {
      char[] c = Integer.toBinaryString(num).toCharArray();
      StringBuilder stringBuilder = new StringBuilder();
      for (char nowC : c) {
        if (nowC == '0') {
          stringBuilder.append('1');
        } else {
          stringBuilder.append('0');
        }

      }
      return Integer.valueOf(stringBuilder.toString(), 2);
    }
  }
}
