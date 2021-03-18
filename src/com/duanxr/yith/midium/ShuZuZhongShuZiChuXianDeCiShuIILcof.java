package com.duanxr.yith.midium;

/**
 * @author 段然 2021/3/17
 */
public class ShuZuZhongShuZiChuXianDeCiShuIILcof {

  /**
   * English description is not available for the problem.
   *
   * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：nums = [3,4,3,3]
   * 输出：4
   * 示例 2：
   *
   * 输入：nums = [9,1,7,9,7,9,7]
   * 输出：1
   *  
   *
   * 限制：
   *
   * 1 <= nums.length <= 10000
   * 1 <= nums[i] < 2^31
   *  
   *
   */
  class Solution {

    public int singleNumber(int[] nums) {
      int[] bits = new int[32];
      for (int num : nums) {
        int filter = 1;
        for (int i = 0; i < bits.length; i++) {
          if ((num & filter) == filter) {
            bits[i]++;
          }
          filter = filter << 1;
        }
      }
      int bit = 1;
      int result = 0;
      for (int i : bits) {
        if (i % 3 != 0) {
          result = bit | result;
        }
        bit = bit << 1;
      }
      return result;
    }
  }
}
