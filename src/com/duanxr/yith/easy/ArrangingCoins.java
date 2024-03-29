package com.duanxr.yith.easy;

import java.util.Arrays;

/**
 * @author Duanran 2019/1/30 0030
 */
public class ArrangingCoins {

  /**
   * You have a total of n coins that you want to form in a staircase shape, where every k-th row
   * must have exactly k coins.
   *
   * Given n, find the total number of full staircase rows that can be formed.
   *
   * n is a non-negative integer and fits within the range of a 32-bit signed integer.
   *
   * Example 1:
   *
   * n = 5
   *
   * The coins can form the following rows:
   *
   * ¤
   * ¤ ¤
   * ¤ ¤
   *
   * Because the 3rd row is incomplete, we return 2.
   *
   * Example 2:
   *
   * n = 8
   *
   * The coins can form the following rows:
   *
   * ¤
   * ¤ ¤
   * ¤ ¤ ¤
   * ¤ ¤
   *
   * Because the 4th row is incomplete, we return 3.
   *
   * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
   *
   * 给定一个数字 n，找出可形成完整阶梯行的总行数。
   *
   * n 是一个非负整数，并且在32位有符号整型的范围内。
   *
   * 示例 1:
   *
   * n = 5
   *
   * 硬币可排列成以下几行:
   *
   * ¤
   * ¤ ¤
   * ¤ ¤
   *
   * 因为第三行不完整，所以返回2.
   *
   * 示例 2:
   *
   * n = 8
   *
   * 硬币可排列成以下几行:
   *
   * ¤
   * ¤ ¤
   * ¤ ¤ ¤
   * ¤ ¤
   *
   * 因为第四行不完整，所以返回3.
   */
  class Solution {
    public int arrangeCoins(int n) {
      int low = 0;
      int high = 65535;
      while (low <= high) {
        int mid = (low + high) >>> 1;
        int midVal = (mid*(mid+1))>>>1;
        if (midVal < n)
          low = mid + 1;
        else if (midVal > n)
          high = mid - 1;
        else
          return mid;
      }
      return high;
    }
  }

  class Solution1 {
    public int arrangeCoins(int n) {
      int c = 0;
      int i = 1;
      while (n >= i) {
        n -= i++;
        c++;
      }
      return c;
    }
  }

  class Solution2 {

    public int arrangeCoins(int n) {
      return (int) ((-1 + Math.sqrt(8 * (long) n + 1)) / 2);
    }
  }
}
