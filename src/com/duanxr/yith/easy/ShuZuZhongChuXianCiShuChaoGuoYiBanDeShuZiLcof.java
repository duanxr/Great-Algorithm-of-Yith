package com.duanxr.yith.easy;

/**
 * @author 段然 2021/3/18
 */
public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {

  /**
   * English description is not available for the problem.
   *
   * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
   *
   *  
   *
   * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
   *
   *  
   *
   * 示例 1:
   *
   * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
   * 输出: 2
   *  
   *
   * 限制：
   *
   * 1 <= 数组长度 <= 50000
   *
   *  
   *
   * 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
   *
   */
  class Solution {

    public int majorityElement(int[] nums) {
      int n = 0;
      int vote = 0;
      for (int num : nums) {
        if (n == num) {
          vote++;
        } else {
          vote--;
          if (vote <= 0) {
            n = num;
            vote = 1;
          }
        }
      }
      return n;
    }
  }
}
