package com.duanxr.yith.midium;

import java.util.Arrays;

/**
 * @author 段然 2021/3/8
 */
public class RotateArray {

  /**
   * Given an array, rotate the array to the right by k steps, where k is non-negative.
   *
   * Follow up:
   *
   * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
   * Could you do it in-place with O(1) extra space?
   *  
   *
   * Example 1:
   *
   * Input: nums = [1,2,3,4,5,6,7], k = 3
   * Output: [5,6,7,1,2,3,4]
   * Explanation:
   * rotate 1 steps to the right: [7,1,2,3,4,5,6]
   * rotate 2 steps to the right: [6,7,1,2,3,4,5]
   * rotate 3 steps to the right: [5,6,7,1,2,3,4]
   * Example 2:
   *
   * Input: nums = [-1,-100,3,99], k = 2
   * Output: [3,99,-1,-100]
   * Explanation:
   * rotate 1 steps to the right: [99,-1,-100,3]
   * rotate 2 steps to the right: [3,99,-1,-100]
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 2 * 104
   * -231 <= nums[i] <= 231 - 1
   * 0 <= k <= 105
   *
   * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
   *
   *  
   *
   * 进阶：
   *
   * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
   * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
   *  
   *
   * 示例 1:
   *
   * 输入: nums = [1,2,3,4,5,6,7], k = 3
   * 输出: [5,6,7,1,2,3,4]
   * 解释:
   * 向右旋转 1 步: [7,1,2,3,4,5,6]
   * 向右旋转 2 步: [6,7,1,2,3,4,5]
   * 向右旋转 3 步: [5,6,7,1,2,3,4]
   * 示例 2:
   *
   * 输入：nums = [-1,-100,3,99], k = 2
   * 输出：[3,99,-1,-100]
   * 解释:
   * 向右旋转 1 步: [99,-1,-100,3]
   * 向右旋转 2 步: [3,99,-1,-100]
   *  
   *
   * 提示：
   *
   * 1 <= nums.length <= 2 * 104
   * -231 <= nums[i] <= 231 - 1
   * 0 <= k <= 105
   *
   */
  class Solution {

    public void rotate(int[] nums, int k) {
      int length = nums.length;
      k = k % length;
      int[] head = Arrays.copyOf(nums, k);
      for (int i = length - 1; i >= 0; i--) {
        if (i >= k) {
          int temp = nums[i];
          int target = (i + k) % length;
          nums[i] = nums[target];
          nums[target] = temp;
        }
      }
      for (int i = 0; i < k; i++) {
        int target = (i + k) % length;
        nums[target] = head[i];
      }
    }
  }
}
