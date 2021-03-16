package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Duanran 4/24/2020
 */
public class Permutations {

  /**
   * Given a collection of distinct integers, return all possible permutations.
   *
   * Example:
   *
   * Input: [1,2,3]
   * Output:
   * [
   *   [1,2,3],
   *   [1,3,2],
   *   [2,1,3],
   *   [2,3,1],
   *   [3,1,2],
   *   [3,2,1]
   * ]
   *
   * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
   *
   * 示例:
   *
   * 输入: [1,2,3]
   * 输出:
   * [
   *   [1,2,3],
   *   [1,3,2],
   *   [2,1,3],
   *   [2,3,1],
   *   [3,1,2],
   *   [3,2,1]
   * ]
   *
   */
  class Solution {

    public List<List<Integer>> permute(int[] nums) {
      List<Integer> integers = new ArrayList<>(nums.length);
      for (int num : nums) {
        integers.add(num);
      }
      return permute(integers);
    }

    public List<List<Integer>> permute(List<Integer> integers) {
      if (integers.size() == 1) {
        return Collections.singletonList(Collections.singletonList(integers.get(0)));
      }
      List<List<Integer>> result = new ArrayList<>();
      for (int i = 0; i < integers.size(); i++) {
        int num = integers.get(i);
        List<Integer> list = new ArrayList<>(integers);
        list.remove(i);
        List<List<Integer>> permute = permute(list);

        for (List<Integer> integerss : permute) {
          List<Integer> lists = new ArrayList<>();
          lists.add(num);
          lists.addAll(integerss);
          result.add(lists);
        }
      }
      return result;
    }

  }
}
