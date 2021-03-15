package com.duanxr.yith.easy;

import java.util.Arrays;

/**
 * @author 段然 2021/3/15
 */
public class PuKePaiZhongDeShunZiLcof {

  /**
   * English description is not available for the problem.
   *
   * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
   *
   * 示例 1:
   *
   * 输入: [1,2,3,4,5]
   * 输出: True
   *  
   *
   * 示例 2:
   *
   * 输入: [0,0,1,2,5]
   * 输出: True
   *  
   *
   * 限制：
   *
   * 数组长度为 5 
   *
   * 数组的数取值为 [0, 13] .
   *
   */
  class Solution {

    public boolean isStraight(int[] nums) {
      Arrays.sort(nums);
      int jokers = 1;
      int last = -1;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
          jokers++;
        } else {
          if (last != -1) {
            while (nums[i] != last + 1) {
              if (jokers == 0) {
                return false;
              }
              last++;
              jokers--;
            }
          }
          last = nums[i];
        }
      }
      return true;
    }
  }
}
