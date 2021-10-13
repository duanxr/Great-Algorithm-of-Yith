package com.duanxr.yith.easy;

/**
 * @author 段然 2021/10/13
 */
public class ThreeConsecutiveOdds {

  /**
   * Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
   *  
   *
   * Example 1:
   *
   * Input: arr = [2,6,4,1]
   * Output: false
   * Explanation: There are no three consecutive odds.
   * Example 2:
   *
   * Input: arr = [1,2,34,3,4,5,7,23,12]
   * Output: true
   * Explanation: [5,7,23] are three consecutive odds.
   *  
   *
   * Constraints:
   *
   * 1 <= arr.length <= 1000
   * 1 <= arr[i] <= 1000
   *
   * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：arr = [2,6,4,1]
   * 输出：false
   * 解释：不存在连续三个元素都是奇数的情况。
   * 示例 2：
   *
   * 输入：arr = [1,2,34,3,4,5,7,23,12]
   * 输出：true
   * 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
   *  
   *
   * 提示：
   *
   * 1 <= arr.length <= 1000
   * 1 <= arr[i] <= 1000
   *
   */
  class Solution {

    public boolean threeConsecutiveOdds(int[] arr) {
      int count = 0;
      for (int n : arr) {
        if (n % 2 == 1) {
          count++;
          if (count == 3) {
            return true;
          }
        } else {
          count = 0;
        }
      }
      return false;
    }
  }
}
