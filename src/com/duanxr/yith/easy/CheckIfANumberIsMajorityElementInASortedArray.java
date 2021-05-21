package com.duanxr.yith.easy;

/**
 * @author 段然 2021/5/21
 */
public class CheckIfANumberIsMajorityElementInASortedArray {

  /**
   * Given an array nums sorted in non-decreasing order, and a number target, return True if and only if target is a majority element.
   *
   * A majority element is an element that appears more than N/2 times in an array of length N.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
   * Output: true
   * Explanation:
   * The value 5 appears 5 times and the length of the array is 9.
   * Thus, 5 is a majority element because 5 > 9/2 is true.
   * Example 2:
   *
   * Input: nums = [10,100,101,101], target = 101
   * Output: false
   * Explanation:
   * The value 101 appears 2 times and the length of the array is 4.
   * Thus, 101 is not a majority element because 2 > 4/2 is false.
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 1000
   * 1 <= nums[i] <= 10^9
   * 1 <= target <= 10^9
   *
   * 给出一个按 非递减 顺序排列的数组 nums，和一个目标数值 target。假如数组 nums 中绝大多数元素的数值都等于 target，则返回 True，否则请返回 False。
   *
   * 所谓占绝大多数，是指在长度为 N 的数组中出现必须 超过 N/2 次。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：nums = [2,4,5,5,5,5,5,6,6], target = 5
   * 输出：true
   * 解释：
   * 数字 5 出现了 5 次，而数组的长度为 9。
   * 所以，5 在数组中占绝大多数，因为 5 次 > 9/2。
   * 示例 2：
   *
   * 输入：nums = [10,100,101,101], target = 101
   * 输出：false
   * 解释：
   * 数字 101 出现了 2 次，而数组的长度是 4。
   * 所以，101 不是 数组占绝大多数的元素，因为 2 次 = 4/2。
   *  
   *
   * 提示：
   *
   * 1 <= nums.length <= 1000
   * 1 <= nums[i] <= 10^9
   * 1 <= target <= 10^9
   *
   */
  class Solution {

    public boolean isMajorityElement(int[] nums, int target) {
      int votes = 0;
      for (int n : nums) {
        votes += n == target ? 1 : -1;
      }
      return votes > 0;
    }
  }
}
