package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/18
 */
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {

  /**
   * English description is not available for the problem.
   *
   * 统计一个数字在排序数组中出现的次数。
   *
   *  
   *
   * 示例 1:
   *
   * 输入: nums = [5,7,7,8,8,10], target = 8
   * 输出: 2
   * 示例 2:
   *
   * 输入: nums = [5,7,7,8,8,10], target = 6
   * 输出: 0
   *  
   *
   * 限制：
   *
   * 0 <= 数组长度 <= 50000
   *
   *  
   *
   * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
   *
   */
  class Solution {

    public int search(int[] nums, int target) {
      return findN(nums, target, 0, nums.length - 1);
    }

    private int findN(int[] nums, int target, int l, int r) {
      if (l > r) {
        return 0;
      }
      int i = l + ((r - l) / 2);
      int n = 0;
      if (nums[i] == target) {
        n++;
      }
      if (nums[i] >= target) {
        n += findN(nums, target, l, i - 1);
      }
      if (nums[i] <= target) {
        n += findN(nums, target, i + 1, r);
      }
      return n;
    }
  }
}
