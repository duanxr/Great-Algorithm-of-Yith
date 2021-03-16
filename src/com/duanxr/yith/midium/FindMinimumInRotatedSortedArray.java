package com.duanxr.yith.midium;

/**
 * @author 段然 2021/3/16
 */
public class FindMinimumInRotatedSortedArray {

  /**
   * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
   *
   * [4,5,6,7,0,1,2] if it was rotated 4 times.
   * [0,1,2,4,5,6,7] if it was rotated 7 times.
   * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
   *
   * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [3,4,5,1,2]
   * Output: 1
   * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
   * Example 2:
   *
   * Input: nums = [4,5,6,7,0,1,2]
   * Output: 0
   * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
   * Example 3:
   *
   * Input: nums = [11,13,15,17]
   * Output: 11
   * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
   *  
   *
   * Constraints:
   *
   * n == nums.length
   * 1 <= n <= 5000
   * -5000 <= nums[i] <= 5000
   * All the integers of nums are unique.
   * nums is sorted and rotated between 1 and n times.
   *
   * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
   *
   * 请找出其中最小的元素。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：nums = [3,4,5,1,2]
   * 输出：1
   * 示例 2：
   *
   * 输入：nums = [4,5,6,7,0,1,2]
   * 输出：0
   * 示例 3：
   *
   * 输入：nums = [1]
   * 输出：1
   *  
   *
   * 提示：
   *
   * 1 <= nums.length <= 5000
   * -5000 <= nums[i] <= 5000
   * nums 中的所有整数都是 唯一 的
   * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
   *
   */
  class Solution {

    public int findMin(int[] nums) {

      int right = nums.length - 1;
      int left = 0;

      int value = nums[0];
      int min = value;

      while (left <= right) {
        int index = left + (right - left) / 2;
        int num = nums[index];
        min = Math.min(num, min);
        if (num >= value) {
          left = index + 1;
        } else {
          right = index - 1;
        }
      }
      return min;
    }
  }

}
