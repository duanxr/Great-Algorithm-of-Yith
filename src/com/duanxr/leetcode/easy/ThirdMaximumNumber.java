package com.duanxr.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Duanran 2019/2/15 0015
 */
public class ThirdMaximumNumber {

  /**
   * Given a non-empty array of integers, return the third maximum number in this array. If it does
   * not exist, return the maximum number. The time complexity must be in O(n).
   *
   * Example 1:
   *
   * Input: [3, 2, 1]
   *
   * Output: 1
   *
   * Explanation: The third maximum is 1.
   *
   * Example 2:
   *
   * Input: [1, 2]
   *
   * Output: 2
   *
   * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
   *
   * Example 3:
   *
   * Input: [2, 2, 3, 1]
   *
   * Output: 1
   *
   * Explanation: Note that the third maximum here means the third maximum distinct number.
   *
   * Both numbers with value 2 are both considered as second maximum.
   *
   * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
   *
   * 示例 1:
   *
   * 输入: [3, 2, 1]
   *
   * 输出: 1
   *
   * 解释: 第三大的数是 1.
   *
   * 示例 2:
   *
   * 输入: [1, 2]
   *
   * 输出: 2
   *
   * 解释: 第三大的数不存在, 所以返回最大的数 2 .
   *
   * 示例 3:
   *
   * 输入: [2, 2, 3, 1]
   *
   * 输出: 1
   *
   * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
   *
   * 存在两个值为2的数，它们都排第二。
   */
  class Solution {

    public int thirdMax(int[] nums) {
      int[] ints = new int[3];
      Set<Integer> integers = new HashSet<>(3);
      Arrays.fill(ints, Integer.MIN_VALUE);
      out:
      for (int n : nums) {
        if (integers.size() < ints.length) {
          integers.add(n);
        }
        if (n > ints[ints.length - 1]) {
          for (int i = 0; i < ints.length; i++) {
            if (ints[i] == n) {
              continue out;
            }
            if (ints[i] < n) {
              System.arraycopy(ints, i, ints, i + 1, ints.length - 1 - i);
              ints[i] = n;
              continue out;
            }
          }
        }
      }
      return integers.size() == ints.length ? ints[ints.length - 1] : ints[0];
    }
  }

}
