package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author 段然 2021/3/25
 */
public class PowerSetLCCI {

  /**
   * Write a method to return all subsets of a set. The elements in a set are pairwise distinct.
   *
   * Note: The result set should not contain duplicated subsets.
   *
   * Example:
   *
   *  Input:  nums = [1,2,3]
   *  Output:
   * [
   *   [3],
   *   [1],
   *   [2],
   *   [1,2,3],
   *   [1,3],
   *   [2,3],
   *   [1,2],
   *   []
   * ]
   *
   * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
   *
   * 说明：解集不能包含重复的子集。
   *
   * 示例:
   *
   *  输入： nums = [1,2,3]
   *  输出：
   * [
   *   [3],
   *   [1],
   *   [2],
   *   [1,2,3],
   *   [1,3],
   *   [2,3],
   *   [1,2],
   *   []
   * ]
   *
   */
  class Solution {

    public List<List<Integer>> subsets(int[] nums) {
      int capacity = getCapacity(nums.length);
      List<List<Integer>> lists = new ArrayList<>(capacity);
      lists.add(Collections.emptyList());
      Stack<Integer> stack = new Stack<>();
      findSet(0, nums, stack, lists);
      return lists;
    }

    private int getCapacity(int length) {
      return (int) Math.pow(2, length);
    }

    private void findSet(int i, int[] nums, Stack<Integer> stack,
        List<List<Integer>> lists) {
      for (; i < nums.length; i++) {
        stack.push(nums[i]);
        lists.add(new ArrayList<>(stack));
        findSet(i + 1, nums, stack, lists);
        stack.pop();
      }
    }

  }
}
