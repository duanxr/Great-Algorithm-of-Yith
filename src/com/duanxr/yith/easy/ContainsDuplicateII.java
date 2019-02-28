package com.duanxr.yith.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Duanran 2019/2/15 0015
 */
public class ContainsDuplicateII {

  /**
   * Given an array of integers and an integer k, find out whether there are two distinct indices i
   * and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is
   * at most k.
   *
   * Example 1:
   *
   * Input: nums = [1,2,3,1], k = 3
   *
   * Output: true
   *
   * Example 2:
   *
   * Input: nums = [1,0,1,1], k = 1
   *
   * Output: true
   *
   * Example 3:
   *
   * Input: nums = [1,2,3,1,2,3], k = 2
   *
   * Output: false
   *
   * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
   *
   * 示例 1:
   *
   * 输入: nums = [1,2,3,1], k = 3
   *
   * 输出: true
   *
   * 示例 2:
   *
   * 输入: nums = [1,0,1,1], k = 1
   *
   * 输出: true
   *
   * 示例 3:
   *
   * 输入: nums = [1,2,3,1,2,3], k = 2
   *
   * 输出: false
   */
  class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
      if (k == 0) {
        return false;
      }
      Set<Integer> set = new HashSet<>(k);
      for (int i = 0; i < nums.length; i++) {
        if (!set.add(nums[i])) {
          return true;
        }
        if (i >= k) {
          set.remove(nums[i - k]);
        }
      }
      return false;
    }
  }
}
