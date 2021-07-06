package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/7/6
 */
public class Combinations {

  /**
   * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
   *
   * You may return the answer in any order.
   *
   *  
   *
   * Example 1:
   *
   * Input: n = 4, k = 2
   * Output:
   * [
   *   [2,4],
   *   [3,4],
   *   [2,3],
   *   [1,2],
   *   [1,3],
   *   [1,4],
   * ]
   * Example 2:
   *
   * Input: n = 1, k = 1
   * Output: [[1]]
   *  
   *
   * Constraints:
   *
   * 1 <= n <= 20
   * 1 <= k <= n
   *
   * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
   *
   * 示例:
   *
   * 输入: n = 4, k = 2
   * 输出:
   * [
   *   [2,4],
   *   [3,4],
   *   [2,3],
   *   [1,2],
   *   [1,3],
   *   [1,4],
   * ]
   *
   */
  class Solution {

    public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> result = new ArrayList<>();
      int[] slot = new int[k];
      recurse(n, 0, slot, result,0);
      return result;
    }

    private void recurse(int n, int si, int[] slot, List<List<Integer>> result, int li) {
      if (si == slot.length) {
        List<Integer> list = new ArrayList<>();
        for (int sn : slot) {
          list.add(sn);
        }
        result.add(list);
        return;
      }
      for (int i = li+1; i <= n; i++) {
        slot[si] = i;
        recurse(n, si+1, slot, result, i);
      }
    }
  }
}
