package com.duanxr.yith.easy;

/**
 * @author 段然 2021/5/25
 */
public class MagicIndexLCCI {

  /**
   * A magic index in an array A[0...n-1] is defined to be an index such that A[i] = i. Given a sorted array of integers, write a method to find a magic index, if one exists, in array A. If not, return -1. If there are more than one magic index, return the smallest one.
   *
   * Example1:
   *
   *  Input: nums = [0, 2, 3, 4, 5]
   *  Output: 0
   * Example2:
   *
   *  Input: nums = [1, 1, 1]
   *  Output: 1
   * Note:
   *
   * 1 <= nums.length <= 1000000
   * This problem is the follow-up of the original problem in the book, i.e. the values are not distinct.
   *
   * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
   *
   * 示例1:
   *
   *  输入：nums = [0, 2, 3, 4, 5]
   *  输出：0
   *  说明: 0下标的元素为0
   * 示例2:
   *
   *  输入：nums = [1, 1, 1]
   *  输出：1
   * 说明:
   *
   * nums长度在[1, 1000000]之间
   * 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
   *
   */
  class Solution {

    public int findMagicIndex(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        if (i == nums[i]) {
          return i;
        }
      }
      return -1;
    }
  }

}
