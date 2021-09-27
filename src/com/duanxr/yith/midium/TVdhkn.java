package com.duanxr.yith.midium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 段然 2021/9/27
 */
public class TVdhkn {

  /**
   * English description is not available for the problem. Please switch to Chinese.
   *
   * 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
   *
   * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：nums = [1,2,3]
   * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
   * 示例 2：
   *
   * 输入：nums = [0]
   * 输出：[[],[0]]
   *  
   *
   * 提示：
   *
   * 1 <= nums.length <= 10
   * -10 <= nums[i] <= 10
   * nums 中的所有元素 互不相同
   *  
   *
   * 注意：本题与主站 78 题相同： https://leetcode-cn.com/problems/subsets/
   *
   */
  class Solution {

    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> list = new ArrayList<>();
      list.add(Collections.emptyList());
      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < nums.length; i++) {
        put(nums, i, stack, list);
      }
      return list;
    }

    private void put(int[] nums, int i, Stack<Integer> stack, List<List<Integer>> list) {
      if (i == nums.length) {
        return;
      }
      stack.push(nums[i]);
      list.add(new ArrayList<>(stack));
      for (int j = i + 1; j < nums.length; j++) {
        put(nums, j, stack, list);
      }
      stack.pop();
    }
  }
}
