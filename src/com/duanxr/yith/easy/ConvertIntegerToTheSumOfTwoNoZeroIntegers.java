package com.duanxr.yith.easy;

/**
 * @author 段然 2021/7/30
 */
public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

  /**
   * Given an integer n. No-Zero integer is a positive integer which doesn't contain any 0 in its decimal representation.
   *
   * Return a list of two integers [A, B] where:
   *
   * A and B are No-Zero integers.
   * A + B = n
   * It's guarateed that there is at least one valid solution. If there are many valid solutions you can return any of them.
   *
   *  
   *
   * Example 1:
   *
   * Input: n = 2
   * Output: [1,1]
   * Explanation: A = 1, B = 1. A + B = n and both A and B don't contain any 0 in their decimal representation.
   * Example 2:
   *
   * Input: n = 11
   * Output: [2,9]
   * Example 3:
   *
   * Input: n = 10000
   * Output: [1,9999]
   * Example 4:
   *
   * Input: n = 69
   * Output: [1,68]
   * Example 5:
   *
   * Input: n = 1010
   * Output: [11,999]
   *  
   *
   * Constraints:
   *
   * 2 <= n <= 10^4
   *
   * 「无零整数」是十进制表示中 不含任何 0 的正整数。
   *
   * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
   *
   * A 和 B 都是无零整数
   * A + B = n
   * 题目数据保证至少有一个有效的解决方案。
   *
   * 如果存在多个有效解决方案，你可以返回其中任意一个。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：n = 2
   * 输出：[1,1]
   * 解释：A = 1, B = 1. A + B = n 并且 A 和 B 的十进制表示形式都不包含任何 0 。
   * 示例 2：
   *
   * 输入：n = 11
   * 输出：[2,9]
   * 示例 3：
   *
   * 输入：n = 10000
   * 输出：[1,9999]
   * 示例 4：
   *
   * 输入：n = 69
   * 输出：[1,68]
   * 示例 5：
   *
   * 输入：n = 1010
   * 输出：[11,999]
   *  
   *
   * 提示：
   *
   * 2 <= n <= 10^4
   *
   */
  class Solution {

    public int[] getNoZeroIntegers(int num) {
      int[] result = new int[2];
      for (int i = 1; i < num; i++) {
        int n2 = num - i;
        if (isNotContainZero(i) && isNotContainZero(n2)) {
          result[0] = i;
          result[1] = n2;
          break;
        }
      }
      return result;
    }

    private boolean isNotContainZero(int num) {
      while (num != 0) {
        int n = num % 10;
        num /= 10;
        if (n == 0) {
          return false;
        }
      }
      return true;
    }

  }
}
