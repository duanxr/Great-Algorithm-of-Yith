package com.duanxr.yith.middle;

import java.util.Arrays;

/**
 * @author Duanran 4/23/2020
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

  /**
   * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
   *
   * Your algorithm's runtime complexity must be in the order of O(log n).
   *
   * If the target is not found in the array, return [-1, -1].
   *
   * Example 1:
   *
   * Input: nums = [5,7,7,8,8,10], target = 8
   * Output: [3,4]
   * Example 2:
   *
   * Input: nums = [5,7,7,8,8,10], target = 6
   * Output: [-1,-1]
   *
   * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
   *
   * 你的算法时间复杂度必须是 O(log n) 级别。
   *
   * 如果数组中不存在目标值，返回 [-1, -1]。
   *
   * 示例 1:
   *
   * 输入: nums = [5,7,7,8,8,10], target = 8
   * 输出: [3,4]
   * 示例 2:
   *
   * 输入: nums = [5,7,7,8,8,10], target = 6
   * 输出: [-1,-1]
   */
  class Solution {

    public int[] searchRange(int[] nums, int target) {
      int[] result = new int[2];
      int index = Arrays.binarySearch(nums, target);
      if (index < 0) {
        result[0] = -1;
        result[1] = -1;
      } else {
        result[0] = index;
        result[1] = index;
        while (result[0] > 0) {
          if (nums[result[0] - 1] != target) {
            break;
          }
          result[0]--;
        }
        while (result[1] < nums.length - 1) {
          if (nums[result[1] + 1] != target) {
            break;
          }
          result[1]++;
        }
      }
      return result;
    }
  }
}
