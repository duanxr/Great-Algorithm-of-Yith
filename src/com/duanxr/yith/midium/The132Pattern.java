package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author 段然 2021/7/20
 */
public class The132Pattern {
  /**
   * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
   *
   * Return true if there is a 132 pattern in nums, otherwise, return false.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [1,2,3,4]
   * Output: false
   * Explanation: There is no 132 pattern in the sequence.
   * Example 2:
   *
   * Input: nums = [3,1,4,2]
   * Output: true
   * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
   * Example 3:
   *
   * Input: nums = [-1,3,2,0]
   * Output: true
   * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
   *  
   *
   * Constraints:
   *
   * n == nums.length
   * 1 <= n <= 2 * 105
   * -109 <= nums[i] <= 109
   *
   * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
   *
   * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：nums = [1,2,3,4]
   * 输出：false
   * 解释：序列中不存在 132 模式的子序列。
   * 示例 2：
   *
   * 输入：nums = [3,1,4,2]
   * 输出：true
   * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
   * 示例 3：
   *
   * 输入：nums = [-1,3,2,0]
   * 输出：true
   * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
   *  
   *
   * 提示：
   *
   * n == nums.length
   * 1 <= n <= 2 * 105
   * -109 <= nums[i] <= 109
   *
   */
  class Solution {

    public boolean find132pattern(int[] nums) {
      if (nums.length < 3) {
        return false;
      }
      Stack<Integer> us = new Stack<>();
      Stack<Integer> ds = new Stack<>();
      int[] compareNums = new int[nums.length];
      Arrays.fill(compareNums, Integer.MIN_VALUE);
      for (int i = nums.length - 1; i >= 1; i--) {
        int n = nums[i];

        while (!us.isEmpty() && us.peek() < n) {
          ds.push(us.pop());
        }
        while (!ds.isEmpty() && ds.peek() >= n) {
          us.push(ds.pop());
        }

        if (!ds.isEmpty()) {
          compareNums[i] = ds.peek();
        }
        if (us.isEmpty() || us.peek() != n) {
          ds.push(n);
        }

      }
      int lmin = nums[0];
      for (int i = 1; i < nums.length; i++) {
        int n = nums[i];
        if (lmin < compareNums[i]) {
          return true;
        }
        if (n < lmin) {
          lmin = n;
        }
      }
      return false;
    }

  }

  class Solution2 {

    public boolean find132pattern(int[] nums) {
      if (nums.length < 3) {
        return false;
      }
      Stack<Integer> us = new Stack<>();
      Stack<Integer> ds = new Stack<>();
      int[] compareNums = new int[nums.length];
      Arrays.fill(compareNums, Integer.MIN_VALUE);
      for (int i = nums.length - 1; i >= 1; i--) {
        int n = nums[i];

        while (!us.isEmpty() && us.peek() < n) {
          ds.push(us.pop());
        }
        while (!ds.isEmpty() && ds.peek() >= n) {
          us.push(ds.pop());
        }

        if (!ds.isEmpty()) {
          compareNums[i] = ds.peek();
        }
        ds.push(n);
      }
      int lmin = nums[0];
      for (int i = 1; i < nums.length; i++) {
        int n = nums[i];
        if (lmin < compareNums[i]) {
          return true;
        }
        if (n < lmin) {
          lmin = n;
        }
      }
      return false;
    }

    private int find(PriorityQueue<Integer> priorityQueue, int n) {
      int r = Integer.MIN_VALUE;
      List<Integer> list = new ArrayList<>(priorityQueue);
      list.sort(Comparator.comparingInt(Integer::intValue));
      for (Integer i : list) {
        if (i < n) {
          r = i;
        } else {
          break;
        }
      }
      return r;
    }
  }


  class Solution1 {

    public boolean find132pattern(int[] nums) {
      if (nums.length < 3) {
        return false;
      }
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
      int[] compareNums = new int[nums.length];
      Arrays.fill(compareNums, Integer.MIN_VALUE);
      for (int i = nums.length - 1; i >= 1; i--) {
        int n = nums[i];
        priorityQueue.offer(n);

        if (!priorityQueue.isEmpty() && priorityQueue.peek() < n) {
          compareNums[i] = find(priorityQueue, n);
        }
      }
      int lmin = nums[0];
      for (int i = 1; i < nums.length; i++) {
        int n = nums[i];
        if (lmin < compareNums[i]) {
          return true;
        }
        if (n < lmin) {
          lmin = n;
        }
      }
      return false;
    }

    private int find(PriorityQueue<Integer> priorityQueue, int n) {
      int r = Integer.MIN_VALUE;
      List<Integer> list = new ArrayList<>(priorityQueue);
      list.sort(Comparator.comparingInt(Integer::intValue));
      for (Integer i : list) {
        if (i < n) {
          r = i;
        } else {
          break;
        }
      }
      return r;
    }
  }
}
