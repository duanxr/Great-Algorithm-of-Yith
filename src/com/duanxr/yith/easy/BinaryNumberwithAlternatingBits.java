package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class BinaryNumberwithAlternatingBits {

  /**
   * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
   *
   *  
   *
   * Example 1:
   *
   * Input: n = 5
   * Output: true
   * Explanation: The binary representation of 5 is: 101
   * Example 2:
   *
   * Input: n = 7
   * Output: false
   * Explanation: The binary representation of 7 is: 111.
   * Example 3:
   *
   * Input: n = 11
   * Output: false
   * Explanation: The binary representation of 11 is: 1011.
   * Example 4:
   *
   * Input: n = 10
   * Output: true
   * Explanation: The binary representation of 10 is: 1010.
   * Example 5:
   *
   * Input: n = 3
   * Output: false
   *  
   *
   * Constraints:
   *
   * 1 <= n <= 231 - 1
   *
   * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：n = 5
   * 输出：true
   * 解释：5 的二进制表示是：101
   * 示例 2：
   *
   * 输入：n = 7
   * 输出：false
   * 解释：7 的二进制表示是：111.
   * 示例 3：
   *
   * 输入：n = 11
   * 输出：false
   * 解释：11 的二进制表示是：1011.
   * 示例 4：
   *
   * 输入：n = 10
   * 输出：true
   * 解释：10 的二进制表示是：1010.
   * 示例 5：
   *
   * 输入：n = 3
   * 输出：false
   *  
   *
   * 提示：
   *
   * 1 <= n <= 231 - 1
   *
   */
  class Solution {
    public boolean hasAlternatingBits(int n) {
      String str  = Integer.toBinaryString(n);
      return  !(str.contains("00") || str.contains("11"));
    }
  }
}
