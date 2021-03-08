package com.duanxr.yith.middle;

/**
 * @author 段然 2021/3/8
 */
public class SumOfTwoIntegers {

  /**
   * Given two integers a and b, return the sum of the two integers without using the operators + and -.
   *
   *  
   *
   * Example 1:
   *
   * Input: a = 1, b = 2
   * Output: 3
   * Example 2:
   *
   * Input: a = 2, b = 3
   * Output: 5
   *  
   *
   * Constraints:
   *
   * -1000 <= a, b <= 1000
   *
   *
   * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
   *
   * 示例 1:
   *
   * 输入: a = 1, b = 2
   * 输出: 3
   * 示例 2:
   *
   * 输入: a = -2, b = 3
   * 输出: 1
   *
   */
  //TODO
  class Solution {
    public int getSum(int a, int b) {
      return Math.addExact(a,b);
    }
  }
}
