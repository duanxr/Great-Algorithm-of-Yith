package com.duanxr.leetcode.easy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Duanran 2019/1/22 0022
 */
public class SortArrayByParity {

  /**
   * Given an array A of non-negative integers, return an array consisting of all the even elements
   * of A, followed by all the odd elements of A.
   *
   * You may return any answer array that satisfies this condition.
   *
   *
   *
   * Example 1:
   *
   * Input: [3,1,2,4]
   *
   * Output: [2,4,3,1]
   *
   * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
   *
   *
   * Note:
   *
   * 1 <= A.length <= 5000
   *
   * 0 <= A[i] <= 5000
   *
   * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
   *
   * 你可以返回满足此条件的任何数组作为答案。
   *
   *
   *
   * 示例：
   *
   * 输入：[3,1,2,4]
   *
   * 输出：[2,4,3,1]
   *
   * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
   *
   *
   * 提示：
   *
   * 1 <= A.length <= 5000
   *
   * 0 <= A[i] <= 5000
   */
  class Solution {

    public int[] sortArrayByParity(int[] A) {
      List<Integer> j = new LinkedList<>();
      List<Integer> o = new LinkedList<>();
      for (int i : A) {
        if (i % 2 == 0) {
          o.add(i);
        } else {
          j.add(i);
        }
      }
      int[] re = new int[A.length];
      Iterator<Integer> oiter = o.iterator();
      int oi = 0;
      while (oiter.hasNext()) {
        re[oi] = oiter.next();
        oi++;
      }
      oiter = j.iterator();
      while (oiter.hasNext()) {
        re[oi] = oiter.next();
        oi++;
      }
      return re;
    }
  }
}
