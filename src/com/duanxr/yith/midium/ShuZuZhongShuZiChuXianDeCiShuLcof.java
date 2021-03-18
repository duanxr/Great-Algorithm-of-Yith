package com.duanxr.yith.midium;

/**
 * @author 段然 2021/3/17
 */
public class ShuZuZhongShuZiChuXianDeCiShuLcof {

  /**
   * English description is not available for the problem.
   *
   * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
   *
   * 示例 1：
   *
   * 输入：nums = [4,1,4,6]
   * 输出：[1,6] 或 [6,1]
   * 示例 2：
   *
   * 输入：nums = [1,2,10,4,1,4,3,3]
   * 输出：[2,10] 或 [10,2]
   *  
   *
   * 限制：
   *
   * 2 <= nums.length <= 10000
   *  
   */
  class Solution {

    public int[] singleNumbers(int[] nums) {
      return find(nums, 0, 0, 0);
    }

    private int[] find(int[] nums, int bit, int filter, int mask) {
      if (bit > 31) {
        return new int[0];
      }
      int xor0 = 0;
      int xor1 = 0;
      for (int i = 0; i < nums.length; i++) {
        int n = nums[i];
        if (((n & mask) | filter) == filter) {
          if ((n & 1 << bit) == 0) {
            xor0 ^= n;
          } else {
            xor1 ^= n;
          }
        }
      }
      if (xor0 != 0 && xor1 != 0) {
        int[] result = new int[2];
        result[0] = xor0;
        result[1] = xor1;
        return result;
      } else {
        filter = xor0 == 0 ? (filter | (1 << bit)) : filter;
        return find(nums, bit + 1, filter, mask << 1 | 1);
      }
    }

    class Solution1 {

      public int[] singleNumbers(int[] nums) {
        int bit = 0;
        int xor0 = 0;
        int xor1 = 0;
        while (xor0 == 0 || xor1 == 0) {
          xor0 = 0;
          xor1 = 0;
          for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (((n >>> bit) & 1) == 0) {
              xor0 ^= n;
            } else {
              xor1 ^= n;
            }
          }
          bit++;
        }
        int[] result = new int[2];
        result[0] = xor0;
        result[1] = xor1;
        return result;
      }
    }

  }
}
