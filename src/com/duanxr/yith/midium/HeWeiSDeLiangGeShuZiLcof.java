package com.duanxr.yith.midium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 段然 2021/3/15
 */
public class HeWeiSDeLiangGeShuZiLcof {

  /**
   * English description is not available for the problem.
   *
   * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
   *  
   *
   * 示例 1：
   *
   * 输入：nums = [2,7,11,15], target = 9
   * 输出：[2,7] 或者 [7,2]
   * 示例 2：
   *
   * 输入：nums = [10,26,30,31,47,60], target = 40
   * 输出：[10,30] 或者 [30,10]
   *  
   *
   * 限制：
   *
   * 1 <= nums.length <= 10^5
   * 1 <= nums[i] <= 10^6
   *
   */
  class Solution {

    public int[] twoSum(int[] nums, int target) {
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
        set.add(target - nums[i]);
      }
      for (int i = 0; i < nums.length; i++) {
        if (set.contains(nums[i])) {
          int[] ints = new int[2];
          ints[0] = nums[i];
          ints[1] = target - nums[i];
          return ints;
        }
      }
      return new int[0];
    }
  }
}
