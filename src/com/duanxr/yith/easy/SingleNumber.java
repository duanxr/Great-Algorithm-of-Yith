package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class SingleNumber {

  /**
   * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
   *
   * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [2,2,1]
   * Output: 1
   * Example 2:
   *
   * Input: nums = [4,1,2,1,2]
   * Output: 4
   * Example 3:
   *
   * Input: nums = [1]
   * Output: 1
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 3 * 104
   * -3 * 104 <= nums[i] <= 3 * 104
   * Each element in the array appears twice except for one element which appears only once.
   *
   * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
   *
   * 说明：
   *
   * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
   *
   * 示例 1:
   *
   * 输入: [2,2,1]
   * 输出: 1
   * 示例 2:
   *
   * 输入: [4,1,2,1,2]
   * 输出: 4
   *
   */
  class Solution {

    public int singleNumber(int[] nums) {
      int result = 0;
      for (int i : nums) {
        result = result ^ i;
      }
      return result;
    }
  }
}
