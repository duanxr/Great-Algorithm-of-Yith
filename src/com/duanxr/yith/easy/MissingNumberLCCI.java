package com.duanxr.yith.easy;

/**
 * @author 段然 2021/5/25
 */
public class MissingNumberLCCI {

  /**
   * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
   *
   * 注意：本题相对书上原题稍作改动
   *
   * 示例 1：
   *
   * 输入：[3,0,1]
   * 输出：2
   *  
   *
   * 示例 2：
   *
   * 输入：[9,6,4,2,3,5,7,0,1]
   * 输出：8
   *
   * An array contains all the integers from 0 to n, except for one number which is missing.  Write code to find the missing integer. Can you do it in O(n) time?
   *
   * Note: This problem is slightly different from the original one the book.
   *
   * Example 1:
   *
   * Input: [3,0,1]
   * Output: 2
   *  
   *
   * Example 2:
   *
   * Input: [9,6,4,2,3,5,7,0,1]
   * Output: 8
   *
   */
  class Solution {

    public int missingNumber(int[] nums) {
      int nsum = nums.length * (nums.length+1) / 2;
      int sum = 0;
      for (int num : nums) {
        sum += num;
      }
      return nsum - sum;
    }
  }


  class Solution1 {

    public int missingNumber(int[] nums) {
      int nsum = 0;
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        sum += num;
        nsum += i;
      }
      return nsum + nums.length - sum;
    }
  }
}
