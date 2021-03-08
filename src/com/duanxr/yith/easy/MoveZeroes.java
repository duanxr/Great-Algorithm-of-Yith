package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class MoveZeroes {

  /**
   * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
   *
   * Example:
   *
   * Input: [0,1,0,3,12]
   * Output: [1,3,12,0,0]
   * Note:
   *
   * You must do this in-place without making a copy of the array.
   * Minimize the total number of operations.
   *
   * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
   *
   * 示例:
   *
   * 输入: [0,1,0,3,12]
   * 输出: [1,3,12,0,0]
   * 说明:
   *
   * 必须在原数组上操作，不能拷贝额外的数组。
   * 尽量减少操作次数。
   *
   */
  class Solution {

    public void moveZeroes(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
          for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != 0) {
              int tmp = nums[i];
              nums[i] = nums[j];
              nums[j] = tmp;
              if (j == nums.length - 1) {
                return;
              }
              break;
            }
          }
        }
      }
    }
  }
}
