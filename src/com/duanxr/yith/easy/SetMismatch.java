package com.duanxr.yith.easy;

/**
 * @author Duanran 2019/2/1 0001
 */
public class SetMismatch {

  /**
   * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error,
   * one of the numbers in the set got duplicated to another number in the set, which results in
   * repetition of one number and loss of another number.
   *
   * Given an array nums representing the data status of this set after the error. Your task is to
   * firstly find the number occurs twice and then find the number that is missing. Return them in
   * the form of an array.
   *
   * Example 1:
   *
   * Input: nums = [1,2,2,4]
   *
   * Output: [2,3]
   *
   * Note:
   *
   * The given array size will in the range [2, 10000].
   *
   * The given array's numbers won't have any order.
   *
   * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
   *
   * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
   *
   * 示例 1:
   *
   * 输入: nums = [1,2,2,4]
   *
   * 输出: [2,3]
   *
   * 注意:
   *
   * 给定数组的长度范围是 [2, 10000]。
   *
   * 给定的数组是无序的。
   */
  class Solution {

    public int[] findErrorNums(int[] nums) {
      boolean[] bit = new boolean[nums.length];
      int repeat = Integer.MIN_VALUE;
      long count = 0;
      for (int n : nums) {
        if (repeat == Integer.MIN_VALUE) {
          if (!bit[n - 1]) {
            bit[n - 1] = true;
          } else {
            repeat = n;
          }
        }
        count += n;
      }
      count -= repeat;
      int missing = getSn(nums.length) - (int) count;
      int[] result = new int[2];
      result[0] = repeat;
      result[1] = missing;
      return result;
    }

    public int getSn(int n) {
      return ((n + 1) * n) / 2;
    }
  }
}
