package com.duanxr.yith.hard;

import java.util.LinkedList;

/**
 * @author 段然 2021/3/18
 */
public class HuaDongChuangKouDeZuiDaZhiLcof {

  /**
   * English description is not available for the problem.
   *
   * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
   *
   * 示例:
   *
   * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
   * 输出: [3,3,5,5,6,7]
   * 解释:
   *
   *   滑动窗口的位置                最大值
   * ---------------               -----
   * [1  3  -1] -3  5  3  6  7       3
   *  1 [3  -1  -3] 5  3  6  7       3
   *  1  3 [-1  -3  5] 3  6  7       5
   *  1  3  -1 [-3  5  3] 6  7       5
   *  1  3  -1  -3 [5  3  6] 7       6
   *  1  3  -1  -3  5 [3  6  7]      7
   *  
   *
   * 提示：
   *
   * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
   *
   * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
   *
   */
  class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
      if (nums.length == 0) {
        return new int[0];
      }
      int[] max = new int[nums.length - k + 1];
      LinkedList<Integer> list = new LinkedList<>();
      for (int i = 0; i < nums.length; i++) {
        while (!list.isEmpty() && list.getLast() < nums[i]) {
          list.removeLast();
        }
        list.addLast(nums[i]);
        if (i >= k) {
          if (list.getFirst() == nums[i - k]) {
            list.removeFirst();
          }
        }
        if (i >= k - 1) {
          max[i - k + 1] = list.getFirst();
        }
      }
      return max;
    }
  }
}
