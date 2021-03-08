package com.duanxr.yith.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/3/8
 */
public class FindAllNumbersDisappearedInAnArray {

  /**
   * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
   *
   * Find all the elements of [1, n] inclusive that do not appear in this array.
   *
   * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
   *
   * Example:
   *
   * Input:
   * [4,3,2,7,8,2,3,1]
   *
   * Output:
   * [5,6]
   *
   * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
   *
   * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
   *
   * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
   *
   * 示例:
   *
   * 输入:
   * [4,3,2,7,8,2,3,1]
   *
   * 输出:
   * [5,6]
   *
   */
  class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
      boolean[] bit = new boolean[nums.length];
      for (int i : nums) {
        bit[i - 1] = true;
      }
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < bit.length; i++) {
        if (bit[i] == false) {
          list.add(i + 1);
        }
      }
      return list;
    }

  }
}
