package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/11
 */
public class TiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {

  /**
   * English description is not available for the problem.
   *
   * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
   *
   *  
   *
   * 示例：
   *
   * 输入：nums = [1,2,3,4]
   * 输出：[1,3,2,4]
   * 注：[3,1,2,4] 也是正确的答案之一。
   *  
   *
   * 提示：
   *
   * 0 <= nums.length <= 50000
   * 1 <= nums[i] <= 10000
   */
  class Solution {

    public int[] exchange(int[] nums) {
      int l = 0;
      int r = nums.length;
      int[] nnums = new int[nums.length];
      for (int num : nums) {
        if (num % 2 == 0) {
          nnums[--r]=num;
        } else {
          nnums[l++]=num;
        }
      }
      return nnums;
    }
  }
}
