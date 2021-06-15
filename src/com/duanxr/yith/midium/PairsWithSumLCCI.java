package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 段然 2021/6/15
 */
public class PairsWithSumLCCI {

  /**
   * Design an algorithm to find all pairs of integers within an array which sum to a specified value.
   *
   * Example 1:
   *
   * Input: nums = [5,6,5], target = 11
   * Output: [[5,6]]
   * Example 2:
   *
   * Input: nums = [5,6,5,6], target = 11
   * Output: [[5,6],[5,6]]
   * Note:
   *
   * nums.length <= 100000
   *
   * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
   *
   * 示例 1:
   *
   * 输入: nums = [5,6,5], target = 11
   * 输出: [[5,6]]
   * 示例 2:
   *
   * 输入: nums = [5,6,5,6], target = 11
   * 输出: [[5,6],[5,6]]
   * 提示：
   *
   * nums.length <= 100000
   *
   */
  class Solution {

    public List<List<Integer>> pairSums(int[] nums, int target) {
      List<List<Integer>> result = new ArrayList<>();

      Map<Integer, Integer> map = new HashMap<>();
      for (int i : nums) {
        int it = target - i;
        int compute = map.compute(it, (k, v) -> v == null ? -1 : v - 1);
        if (compute < 0) {
          map.compute(i, (k, v) -> v == null || v < 0 ? 1 : v + 1);
        } else {
          List<Integer> list = new ArrayList<>(2);
          list.add(it);
          list.add(i);
          result.add(list);
        }
      }

      return result;
    }
  }
}
