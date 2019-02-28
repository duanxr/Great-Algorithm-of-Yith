package com.duanxr.yith.easy;

import java.util.HashSet;

/**
 * @author Duanran 2019/1/18 0018
 */
public class NRepeatedElementinSize2NArray {

  /**
   * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is
   * repeated N times.
   *
   * Return the element repeated N times.
   *
   *
   *
   * Example 1:
   *
   * Input: [1,2,3,3]
   *
   * Output: 3
   *
   * Example 2:
   *
   * Input: [2,1,2,5,3,2]
   *
   * Output: 2
   *
   * Example 3:
   *
   * Input: [5,1,5,2,5,3,5,4]
   *
   * Output: 5
   *
   *
   * Note:
   *
   * 4 <= A.length <= 10000
   *
   * 0 <= A[i] < 10000
   *
   * A.length is even
   *
   * 
   * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
   *
   * 返回重复了 N 次的那个元素。
   *
   *
   *
   * 示例 1：
   *
   * 输入：[1,2,3,3]
   *
   * 输出：3
   *
   * 示例 2：
   *
   * 输入：[2,1,2,5,3,2]
   *
   * 输出：2
   *
   * 示例 3：
   *
   * 输入：[5,1,5,2,5,3,5,4]
   *
   * 输出：5
   *
   *
   * 提示：
   *
   * 4 <= A.length <= 10000
   *
   * 0 <= A[i] < 10000
   *
   * A.length 为偶数
   */
  class Solution {

    public int repeatedNTimes(int[] A) {
      HashSet<Integer> hashSet = new HashSet<>();
      for (int i : A) {
        if (hashSet.contains(i)) {
          return i;
        }
        hashSet.add(i);
      }
      return -1;
    }
  }
}
