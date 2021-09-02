package com.duanxr.yith.midium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author 段然 2021/9/2
 */
public class SplitArrayIntoConsecutiveSubsequences {

  /**
   * You are given an integer array nums that is sorted in non-decreasing order.
   *
   * Determine if it is possible to split nums into one or more subsequences such that both of the following conditions are true:
   *
   * Each subsequence is a consecutive increasing sequence (i.e. each integer is exactly one more than the previous integer).
   * All subsequences have a length of 3 or more.
   * Return true if you can split nums according to the above conditions, or false otherwise.
   *
   * A subsequence of an array is a new array that is formed from the original array by deleting some (can be none) of the elements without disturbing the relative positions of the remaining elements. (i.e., [1,3,5] is a subsequence of [1,2,3,4,5] while [1,3,2] is not).
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [1,2,3,3,4,5]
   * Output: true
   * Explanation: nums can be split into the following subsequences:
   * [1,2,3,3,4,5] --> 1, 2, 3
   * [1,2,3,3,4,5] --> 3, 4, 5
   * Example 2:
   *
   * Input: nums = [1,2,3,3,4,4,5,5]
   * Output: true
   * Explanation: nums can be split into the following subsequences:
   * [1,2,3,3,4,4,5,5] --> 1, 2, 3, 4, 5
   * [1,2,3,3,4,4,5,5] --> 3, 4, 5
   * Example 3:
   *
   * Input: nums = [1,2,3,4,4,5]
   * Output: false
   * Explanation: It is impossible to split nums into consecutive increasing subsequences of length 3 or more.
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 104
   * -1000 <= nums[i] <= 1000
   * nums is sorted in non-decreasing order.
   *
   * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。
   *
   * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
   *
   *  
   *
   * 示例 1：
   *
   * 输入: [1,2,3,3,4,5]
   * 输出: True
   * 解释:
   * 你可以分割出这样两个连续子序列 :
   * 1, 2, 3
   * 3, 4, 5
   * 示例 2：
   *
   * 输入: [1,2,3,3,4,4,5,5]
   * 输出: True
   * 解释:
   * 你可以分割出这样两个连续子序列 :
   * 1, 2, 3, 4, 5
   * 3, 4, 5
   * 示例 3：
   *
   * 输入: [1,2,3,4,4,5]
   * 输出: False
   *  
   *
   * 提示：
   *
   * 1 <= nums.length <= 10000
   *
   */
  class Solution {

    public boolean isPossible(int[] nums) {
      Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
      for (int n : nums) {
        PriorityQueue<Integer> lq = map.get(n - 1);
        PriorityQueue<Integer> q = map.computeIfAbsent(n, k -> new PriorityQueue<>());
        if (lq == null || lq.isEmpty()) {
          q.offer(1);
        } else {
          q.offer(lq.poll() + 1);
        }
      }
      for (PriorityQueue<Integer> queue : map.values()) {
        if (!queue.isEmpty() && queue.peek() < 3) {
          return false;
        }
      }
      return true;
    }
  }
}
