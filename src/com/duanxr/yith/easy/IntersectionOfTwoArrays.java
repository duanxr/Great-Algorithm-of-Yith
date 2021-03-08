package com.duanxr.yith.easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author 段然 2021/3/8
 */
public class IntersectionOfTwoArrays {

  /**
   * Given two arrays, write a function to compute their intersection.
   *
   * Example 1:
   *
   * Input: nums1 = [1,2,2,1], nums2 = [2,2]
   * Output: [2]
   * Example 2:
   *
   * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
   * Output: [9,4]
   * Note:
   *
   * Each element in the result must be unique.
   * The result can be in any order.
   *
   * 给定两个数组，编写一个函数来计算它们的交集。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
   * 输出：[2]
   * 示例 2：
   *
   * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
   * 输出：[9,4]
   *  
   *
   * 说明：
   *
   * 输出结果中的每个元素一定是唯一的。
   * 我们可以不考虑输出结果的顺序。
   *
   */
  class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
      Set<Integer> list = new LinkedHashSet<>();
      Set<Integer> set = new HashSet<>();
      boolean less = nums1.length < nums2.length;
      int[] lessNums;
      int[] moreNums;
      if (less) {
        lessNums = nums1;
        moreNums = nums2;
      } else {
        lessNums = nums2;
        moreNums = nums1;
      }
      for (int num : lessNums) {
        set.add(num);
      }
      for (int num : moreNums) {
        if (set.contains(num)) {
          list.add(num);
        }
      }
      int[] r = new int[list.size()];
      Iterator iterator = list.iterator();
      int i = 0;
      while (iterator.hasNext()) {
        r[i] = (int) iterator.next();
        i++;
      }
      return r;
    }
  }
}
