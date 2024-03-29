package com.duanxr.yith.midium;

/**
 * @author 段然 2021/9/10
 */
public class SearchInRotatedSortedArray {

  /**
   * There is an integer array nums sorted in ascending order (with distinct values).
   *
   * Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
   *
   * Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
   *
   * You must write an algorithm with O(log n) runtime complexity.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [4,5,6,7,0,1,2], target = 0
   * Output: 4
   * Example 2:
   *
   * Input: nums = [4,5,6,7,0,1,2], target = 3
   * Output: -1
   * Example 3:
   *
   * Input: nums = [1], target = 0
   * Output: -1
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 5000
   * -104 <= nums[i] <= 104
   * All values of nums are unique.
   * nums is guaranteed to be rotated at some pivot.
   * -104 <= target <= 104
   *
   * 整数数组 nums 按升序排列，数组中的值 互不相同 。
   *
   * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
   *
   * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：nums = [4,5,6,7,0,1,2], target = 0
   * 输出：4
   * 示例 2：
   *
   * 输入：nums = [4,5,6,7,0,1,2], target = 3
   * 输出：-1
   * 示例 3：
   *
   * 输入：nums = [1], target = 0
   * 输出：-1
   *  
   *
   * 提示：
   *
   * 1 <= nums.length <= 5000
   * -10^4 <= nums[i] <= 10^4
   * nums 中的每个值都 独一无二
   * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
   * -10^4 <= target <= 10^4
   *  
   *
   * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
   *
   */
  class Solution {

    public int search(int[] nums, int target) {
      return target == nums[0] ? 0 : search0(nums, target, nums[0], 0, nums.length - 1);
    }

    private int search0(int[] nums, int target, int pivot, int low, int high) {
      while (low <= high) {
        int mid = (low + high) >>> 1;
        int midVal = nums[mid];

        boolean th = target > pivot;
        boolean ch = midVal >= pivot;

        if (th == ch) {
          if (midVal < target) {
            low = mid + 1;
          } else if (midVal > target) {
            high = mid - 1;
          } else {
            return mid;
          }
        } else {
          if (ch) {
            low = mid + 1;
          } else {
            high = mid - 1;
          }
        }
      }
      return -1;
    }
  }
}
