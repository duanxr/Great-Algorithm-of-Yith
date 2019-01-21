package com.duanxr.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Duanran 2019/1/21 0021
 */
public class LongestHarmoniousSubsequence {

  /**
   * We define a harmonious array is an array where the difference between its maximum value and its
   * minimum value is exactly 1.
   *
   * Now, given an integer array, you need to find the length of its longest harmonious subsequence
   * among all its possible subsequences.
   *
   * Example 1:
   *
   * Input: [1,3,2,2,5,2,3,7]
   *
   * Output: 5
   *
   * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
   *
   * Note: The length of the input array will not exceed 20,000.
   *
   * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
   *
   * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
   *
   * 示例 1:
   *
   * 输入: [1,3,2,2,5,2,3,7]
   *
   * 输出: 5
   *
   * 原因: 最长的和谐数组是：[3,2,2,2,3].
   *
   * 说明: 输入的数组长度最大不超过20,000.
   */
  class Solution {

    public int findLHS(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int n : nums) {
        addMap(map, n);
      }
      int r = 0;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        int e = entry.getKey();
        if (map.containsKey(e + 1)) {
          int a = entry.getValue() + map.getOrDefault(e + 1, 0);
          if (a > r) {
            r = a;
          }
        }
      }
      return r;
    }

    private void addMap(Map<Integer, Integer> map, int n) {
      if (map.containsKey(n)) {
        map.put(n, map.get(n) + 1);
      } else {
        map.put(n, 1);
      }
    }
  }
}
