package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class BinarySearch {

  /**
   * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [-1,0,3,5,9,12], target = 9
   * Output: 4
   * Explanation: 9 exists in nums and its index is 4
   * Example 2:
   *
   * Input: nums = [-1,0,3,5,9,12], target = 2
   * Output: -1
   * Explanation: 2 does not exist in nums so return -1
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 104
   * -9999 <= nums[i], target <= 9999
   * All the integers in nums are unique.
   * nums is sorted in an ascending order.
   *
   * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
   *
   *
   * 示例 1:
   *
   * 输入: nums = [-1,0,3,5,9,12], target = 9
   * 输出: 4
   * 解释: 9 出现在 nums 中并且下标为 4
   * 示例 2:
   *
   * 输入: nums = [-1,0,3,5,9,12], target = 2
   * 输出: -1
   * 解释: 2 不存在 nums 中因此返回 -1
   *  
   *
   * 提示：
   *
   * 你可以假设 nums 中的所有元素是不重复的。
   * n 将在 [1, 10000]之间。
   * nums 的每个元素都将在 [-9999, 9999]之间。
   *
   */
  class Solution {

    public int search(int[] nums, int target) {

      int l = 0;
      int r = nums.length - 1;
      int index = (r - l) / 2;
      while (true) {
        if (nums[index] == target) {
          return index;
        }
        if (r <= l) {
          return -1;
        }
        if (nums[index] > target) {
          r = index - 1;
          index = l + (r - l) / 2;
        } else {
          l = index + 1;
          index = l + (r - l) / 2;
        }
      }
    }
  }
}
