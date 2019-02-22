package com.duanxr.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Duanran 2019/2/22 0022
 */
public class XOfAKindInADeckOfCards {

  /**
   * In a deck of cards, each card has an integer written on it.
   *
   * Return true if and only if you can choose X >= 2 such that it is possible to split the entire
   * deck into 1 or more groups of cards, where:
   *
   * Each group has exactly X cards.
   *
   * All the cards in each group have the same integer.
   *
   * Example 1:
   *
   * Input: [1,2,3,4,4,3,2,1]
   *
   * Output: true
   *
   * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
   *
   * Example 2:
   *
   * Input: [1,1,1,2,2,2,3,3]
   *
   * Output: false
   *
   * Explanation: No possible partition.
   *
   * Example 3:
   *
   * Input: [1]
   *
   * Output: false
   *
   * Explanation: No possible partition.
   *
   * Example 4:
   *
   * Input: [1,1]
   *
   * Output: true
   *
   * Explanation: Possible partition [1,1]
   *
   * Example 5:
   *
   * Input: [1,1,2,2,2,2]
   *
   * Output: true
   *
   * Explanation: Possible partition [1,1],[2,2],[2,2]
   *
   * Note:
   *
   * 1 <= deck.length <= 10000
   *
   * 0 <= deck[i] < 10000
   *
   * 给定一副牌，每张牌上都写着一个整数。
   *
   * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
   *
   * 每组都有 X 张牌。
   *
   * 组内所有的牌上都写着相同的整数。
   *
   * 仅当你可选的 X >= 2 时返回 true。
   *
   * 示例 1：
   *
   * 输入：[1,2,3,4,4,3,2,1]
   *
   * 输出：true
   *
   * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
   *
   * 示例 2：
   *
   * 输入：[1,1,1,2,2,2,3,3]
   *
   * 输出：false
   *
   * 解释：没有满足要求的分组。
   *
   * 示例 3：
   *
   * 输入：[1]
   *
   * 输出：false
   *
   * 解释：没有满足要求的分组。
   *
   * 示例 4：
   *
   * 输入：[1,1]
   *
   * 输出：
   *
   * 解释：可行的分组是 [1,1]
   *
   * 示例 5：
   *
   * 输入：[1,1,2,2,2,2]
   *
   * 输出：true
   *
   * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
   *
   * 提示：
   *
   * 1 <= deck.length <= 10000
   *
   * 0 <= deck[i] < 10000
   */
  class Solution {

    public boolean hasGroupsSizeX(int[] deck) {
      if (deck.length == 0) {
        return false;
      }
      Map<Integer, Integer> map = new HashMap<>();
      for (int n : deck) {
        map.put(n, map.getOrDefault(n, 0) + 1);
      }
      int pcm = Integer.MIN_VALUE;
      boolean nonFirst = false;
      for (int v : map.values()) {
        if (nonFirst) {
          pcm = getPcm(v, pcm);
        } else {
          pcm = v;
          nonFirst = true;
        }
        if (pcm < 2) {
          return false;
        }
      }
      return true;
    }

    private int getPcm(int a, int b) {
      if (a == b) {
        return a;
      }
      for (int i = Math.min(a, b); i >= 2; i--) {
        if (a % i == 0 && b % i == 0) {
          return i;
        }
      }
      return -1;
    }
  }
}
