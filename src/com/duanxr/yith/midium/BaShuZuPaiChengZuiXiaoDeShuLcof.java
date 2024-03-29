package com.duanxr.yith.midium;

import java.util.Arrays;

/**
 * @author 段然 2021/3/18
 */
public class BaShuZuPaiChengZuiXiaoDeShuLcof {

  /**
   * English description is not available for the problem.
   * 
   * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
   *
   *  
   *
   * 示例 1:
   *
   * 输入: [10,2]
   * 输出: "102"
   * 示例 2:
   *
   * 输入: [3,30,34,5,9]
   * 输出: "3033459"
   *  
   *
   * 提示:
   *
   * 0 < nums.length <= 100
   * 说明:
   *
   * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
   * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
   *
   */
  class Solution {

    private int combine(int a, int b) {
      if (b == 0) {
        return a * 10;
      }
      int n = a;
      int bb = b;
      while (bb != 0) {
        bb /= 10;
        n *= 10;
      }
      return n + b;
    }

    public String minNumber(int[] nums) {
      StringBuilder sb = new StringBuilder();
      Arrays.stream(nums).boxed().sorted((o1, o2) -> combine(o1, o2) - combine(o2, o1))
          .forEach(sb::append);
      return sb.toString();
    }
  }
}
