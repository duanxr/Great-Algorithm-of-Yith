package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/8
 */
public class MinimumMovesToEqualArrayElements {

  /**
   * Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
   *
   * In one move, you can increment n - 1 elements of the array by 1.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [1,2,3]
   * Output: 3
   * Explanation: Only three moves are needed (remember each move increments two elements):
   * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
   * Example 2:
   *
   * Input: nums = [1,1,1]
   * Output: 0
   *  
   *
   * Constraints:
   *
   * n == nums.length
   * 1 <= nums.length <= 104
   * -109 <= nums[i] <= 109
   *
   * 给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。
   *
   *  
   *
   * 示例：
   *
   * 输入：
   * [1,2,3]
   * 输出：
   * 3
   * 解释：
   * 只需要3次操作（注意每次操作会增加两个元素的值）：
   * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
   *
   */
  class Solution {

    public int minMoves(int[] nums) {
      int sum = 0;
      int min = Integer.MAX_VALUE;
      for (int n : nums) {
        sum += n;
        min = Math.min(min, n);
      }
      sum -= min * nums.length;
      return sum;
    }
  }
}
