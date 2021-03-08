package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class MaximumProductOfThreeNumbers {

  /**
   * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [1,2,3]
   * Output: 6
   * Example 2:
   *
   * Input: nums = [1,2,3,4]
   * Output: 24
   * Example 3:
   *
   * Input: nums = [-1,-2,-3]
   * Output: -6
   *  
   *
   * Constraints:
   *
   * 3 <= nums.length <= 104
   * -1000 <= nums[i] <= 1000
   *
   * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：nums = [1,2,3]
   * 输出：6
   * 示例 2：
   *
   * 输入：nums = [1,2,3,4]
   * 输出：24
   * 示例 3：
   *
   * 输入：nums = [-1,-2,-3]
   * 输出：-6
   *  
   *
   * 提示：
   *
   * 3 <= nums.length <= 104
   * -1000 <= nums[i] <= 1000
   *
   */
  class Solution {

    public int maximumProduct(int[] nums) {
      int[] z = new int[3];
      int[] f = new int[3];
      int max = Integer.MIN_VALUE;
      for (int i : nums) {
        if (i > 0) {
          add(z, i);
        } else {
          add(f, i);
        }
      }
      if (z[0] == 0) {
        return f[0] * f[1] * f[2];
      }
      return Math.max(z[0] * z[1] * z[2], z[0] * f[1] * f[0]);
    }

    private void add(int[] ints, int i) {
      for (int j = 0; j < ints.length; j++) {
        if (Math.abs(ints[j]) < Math.abs(i)) {
          for (int k = ints.length - 1; k > j; k--) {
            ints[k] = ints[k - 1];
          }
          ints[j] = i;
          return;
        }
      }
    }
  }
}
