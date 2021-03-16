package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 段然 2021/3/8
 */
public class PowerfulIntegers {

  /**
   * Given three integers x, y, and bound, return a list of all the powerful integers that have a value less than or equal to bound.
   *
   * An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.
   *
   * You may return the answer in any order. In your answer, each value should occur at most once.
   *
   *  
   *
   * Example 1:
   *
   * Input: x = 2, y = 3, bound = 10
   * Output: [2,3,4,5,7,9,10]
   * Explanation:
   * 2 = 20 + 30
   * 3 = 21 + 30
   * 4 = 20 + 31
   * 5 = 21 + 31
   * 7 = 22 + 31
   * 9 = 23 + 30
   * 10 = 20 + 32
   * Example 2:
   *
   * Input: x = 3, y = 5, bound = 15
   * Output: [2,4,6,8,10,14]
   *  
   *
   * Constraints:
   *
   * 1 <= x, y <= 100
   * 0 <= bound <= 106
   *
   * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
   *
   * 返回值小于或等于 bound 的所有强整数组成的列表。
   *
   * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：x = 2, y = 3, bound = 10
   * 输出：[2,3,4,5,7,9,10]
   * 解释：
   * 2 = 2^0 + 3^0
   * 3 = 2^1 + 3^0
   * 4 = 2^0 + 3^1
   * 5 = 2^1 + 3^1
   * 7 = 2^2 + 3^1
   * 9 = 2^3 + 3^0
   * 10 = 2^0 + 3^2
   * 示例 2：
   *
   * 输入：x = 3, y = 5, bound = 15
   * 输出：[2,4,6,8,10,14]
   *  
   *
   * 提示：
   *
   * 1 <= x <= 100
   * 1 <= y <= 100
   * 0 <= bound <= 10^6
   *
   */
  class Solution {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {

      Set<Integer> set = new HashSet<>();

      List<Integer> xl = new ArrayList<>();

      xl.add(1);

      int xx = 1;
      int yy = 1;

      if (x == 0) {
        xl.add(1);
        xl.add(0);
      } else if (x == 1) {
        xl.add(1);
      } else {
        while (xx < bound) {
          xl.add(xx);
          xx *= x;
        }
      }
      if (y == 0) {
        for (int i = 0; i < 2; i++) {
          for (Integer integer : xl) {
            int s = integer + i;
            if (s > bound) {
              break;
            }
            set.add(s);
          }
        }
      } else if (y == 1) {
        for (Integer integer : xl) {
          int s = integer + 1;
          if (s > bound) {
            break;
          }
          set.add(s);
        }
      } else {

        while (yy < bound) {
          for (Integer integer : xl) {
            int s = integer + yy;
            if (s > bound) {
              break;
            }
            set.add(s);
          }
          yy *= y;
        }
      }
      List<Integer> list = new ArrayList<>(set);
      return list;
    }
  }
}
