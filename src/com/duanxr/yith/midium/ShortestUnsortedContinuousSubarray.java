package com.duanxr.yith.midium;

/**
 * @author 段然 2021/3/8
 */
public class ShortestUnsortedContinuousSubarray {

  /**
   * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
   *
   * 请你找出符合题意的 最短 子数组，并输出它的长度。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：nums = [2,6,4,8,10,9,15]
   * 输出：5
   * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
   * 示例 2：
   *
   * 输入：nums = [1,2,3,4]
   * 输出：0
   * 示例 3：
   *
   * 输入：nums = [1]
   * 输出：0
   *  
   *
   * 提示：
   *
   * 1 <= nums.length <= 104
   * -105 <= nums[i] <= 105
   *  
   *
   * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
   *
   * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
   *
   * Return the shortest such subarray and output its length.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [2,6,4,8,10,9,15]
   * Output: 5
   * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
   * Example 2:
   *
   * Input: nums = [1,2,3,4]
   * Output: 0
   * Example 3:
   *
   * Input: nums = [1]
   * Output: 0
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 104
   * -105 <= nums[i] <= 105
   *  
   *
   * Follow up: Can you solve it in O(n) time complexity?
   *
   */
  class Solution {

    public int findUnsortedSubarray(int[] nums) {
      int left = 0;
      for (int i = 0; i < nums.length; i++) {
        if (i == nums.length - 1) {
          return 0;
        }
        left = i;
        if (nums[i + 1] < nums[i]) {
          break;
        }
      }
      int right = nums.length - 1;
      for (int i = nums.length - 1; i > 0; i--) {
        right = i;
        if (nums[i - 1] > nums[i]) {
          break;
        }
      }
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int i = left; i <= right; i++) {
        if (nums[i] > max) {
          max = nums[i];
        }
        if (nums[i] < min) {
          min = nums[i];
        }
      }
      int finalLeft = left;
      for (int i = left; i >= 0; i--) {
        if (nums[i] > min) {
          finalLeft = i;
        } else {
          break;
        }
      }
      int finalRight = right;
      for (int i = right; i < nums.length; i++) {
        if (nums[i] < max) {
          finalRight = i + 1;
        } else {
          break;
        }
      }
      return finalRight - finalLeft;
    }
  }
}
