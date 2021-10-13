package com.duanxr.yith.midium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 段然 2021/10/13
 */
public class DivideArrayInSetsOfKConsecutiveNumbers {

  /**
   * Given an array of integers nums and a positive integer k, find whether it is possible to divide this array into sets of k consecutive numbers.
   *
   * Return true if it is possible. Otherwise, return false.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [1,2,3,3,4,4,5,6], k = 4
   * Output: true
   * Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
   * Example 2:
   *
   * Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
   * Output: true
   * Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
   * Example 3:
   *
   * Input: nums = [3,3,2,2,1,1], k = 3
   * Output: true
   * Example 4:
   *
   * Input: nums = [1,2,3,4], k = 3
   * Output: false
   * Explanation: Each array should be divided in subarrays of size 3.
   *  
   *
   * Constraints:
   *
   * 1 <= k <= nums.length <= 105
   * 1 <= nums[i] <= 109
   *  
   *
   * Note: This question is the same as 846: https://leetcode.com/problems/hand-of-straights/
   *
   * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
   * 如果可以，请返回 True；否则，返回 False。
   *
   *  
   *
   * 注意：此题目与 846 重复：https://leetcode-cn.com/problems/hand-of-straights/
   *
   *  
   *
   * 示例 1：
   *
   * 输入：nums = [1,2,3,3,4,4,5,6], k = 4
   * 输出：true
   * 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
   * 示例 2：
   *
   * 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
   * 输出：true
   * 解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
   * 示例 3：
   *
   * 输入：nums = [3,3,2,2,1,1], k = 3
   * 输出：true
   * 示例 4：
   *
   * 输入：nums = [1,2,3,4], k = 3
   * 输出：false
   * 解释：数组不能分成几个大小为 3 的子数组。
   *  
   *
   * 提示：
   *
   * 1 <= nums.length <= 10^5
   * 1 <= nums[i] <= 10^9
   * 1 <= k <= nums.length
   *
   */
  class Solution {

    public boolean isPossibleDivide(int[] nums, int k) {
      Arrays.sort(nums);
      Map<Integer, Queue<Integer>> map = new HashMap<>();
      for (int num : nums) {
        Queue<Integer> queue = map.computeIfAbsent(num, key -> new ArrayDeque<>());
        if (queue.isEmpty()) {
          map.computeIfAbsent(num + 1, key -> new ArrayDeque<>()).offer(1);
        } else {
          Integer poll = queue.poll();
          if (poll < k - 1) {
            map.computeIfAbsent(num + 1, key -> new ArrayDeque<>()).offer(poll + 1);
          }
        }
      }
      for (Queue<Integer> value : map.values()) {
        if (!value.isEmpty()) {
          return false;
        }
      }
      return true;
    }
  }

  class Solution1 {

    public boolean isPossibleDivide(int[] nums, int k) {
      Arrays.sort(nums);
      Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
      for (int num : nums) {
        PriorityQueue<Integer> queue = map.computeIfAbsent(num, key -> new PriorityQueue<>());
        if (queue.isEmpty()) {
          map.computeIfAbsent(num + 1, key -> new PriorityQueue<>()).offer(1);
        } else {
          Integer poll = queue.poll();
          if (poll < k - 1) {
            map.computeIfAbsent(num + 1, key -> new PriorityQueue<>()).offer(poll + 1);
          }
        }
      }
      for (PriorityQueue<Integer> value : map.values()) {
        if (!value.isEmpty()) {
          return false;
        }
      }
      return true;
    }
  }
}
