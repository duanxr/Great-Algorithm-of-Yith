package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/5/27
 */
public class CheckIfNumberIsASumOfPowersOfThree {

  /**
   * Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.
   *
   * An integer y is a power of three if there exists an integer x such that y == 3x.
   *
   *  
   *
   * Example 1:
   *
   * Input: n = 12
   * Output: true
   * Explanation: 12 = 31 + 32
   * Example 2:
   *
   * Input: n = 91
   * Output: true
   * Explanation: 91 = 30 + 32 + 34
   * Example 3:
   *
   * Input: n = 21
   * Output: false
   *  
   *
   * Constraints:
   *
   * 1 <= n <= 107
   *
   * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
   *
   * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：n = 12
   * 输出：true
   * 解释：12 = 31 + 32
   * 示例 2：
   *
   * 输入：n = 91
   * 输出：true
   * 解释：91 = 30 + 32 + 34
   * 示例 3：
   *
   * 输入：n = 21
   * 输出：false
   *  
   *
   * 提示：
   *
   * 1 <= n <= 107
   *
   */
  class Solution {

    public boolean checkPowersOfThree(int n) {
      int[] array = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323,
          4782969, 14348907, 43046721, 129140163, 387420489};
      for (int i = array.length - 1; i >= 0; i--) {
        int integer = array[i];
        if (n >= integer) {
          n -= integer;
          if (n == 0) {
            return true;
          }
        }
      }
      return false;
    }
  }


  class Solution1 {

    public boolean checkPowersOfThree(int n) {
      List<Integer> list = new ArrayList<>();
      int m = 1;
      while (m < Integer.MAX_VALUE / 3) {
        list.add(m);
        m *= 3;
      }
      System.out.println(list);
      for (int i = list.size() - 1; i >= 0; i--) {
        Integer integer = list.get(i);
        if (n >= integer) {
          n -= integer;
          if (n == 0) {
            return true;
          }
        }

      }
      return false;
    }
  }
}
