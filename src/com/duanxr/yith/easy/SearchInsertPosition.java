package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class SearchInsertPosition {

  /**
   * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [1,3,5,6], target = 5
   * Output: 2
   * Example 2:
   *
   * Input: nums = [1,3,5,6], target = 2
   * Output: 1
   * Example 3:
   *
   * Input: nums = [1,3,5,6], target = 7
   * Output: 4
   * Example 4:
   *
   * Input: nums = [1,3,5,6], target = 0
   * Output: 0
   * Example 5:
   *
   * Input: nums = [1], target = 0
   * Output: 0
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 104
   * -104 <= nums[i] <= 104
   * nums contains distinct values sorted in ascending order.
   * -104 <= target <= 104
   *
   * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
   *
   * 你可以假设数组中无重复元素。
   *
   * 示例 1:
   *
   * 输入: [1,3,5,6], 5
   * 输出: 2
   * 示例 2:
   *
   * 输入: [1,3,5,6], 2
   * 输出: 1
   * 示例 3:
   *
   * 输入: [1,3,5,6], 7
   * 输出: 4
   * 示例 4:
   *
   * 输入: [1,3,5,6], 0
   * 输出: 0
   *
   */
  class Solution {

    public int searchInsert(int[] nums, int target) {
      if (nums[nums.length - 1] < target) {
        return nums.length;
      }
      if (nums[0] > target) {
        return 0;
      }
      return searchInsert(nums, target, 0, nums.length);
    }

    private int searchInsert(int[] nums, int target, int left, int right) {
      int m = right - left;
      m /= 2;
      System.out.println(left + " " + right + " " + m);
      if (nums[left + m] == target) {
        return left + m;
      }
      if (m == 0) {
        if (nums[left + m] >= target) {
          return left + m;
        }
        return left + m + 1;
      }

      if (nums[left + m] > target) {
        return searchInsert(nums, target, left, right - m);
      }
      if (nums[left + m] < target) {
        return searchInsert(nums, target, right - m, right);
      }
      return -1;
    }
  }
}
