package com.duanxr.yith.midium;

import java.util.Arrays;

/**
 * @author 段然 2021/3/17
 */
public class NGeTouZiDeDianShuLcof {

  /**
   * English description is not available for the problem.
   *
   * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
   *
   *  
   *
   * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
   *
   *  
   *
   * 示例 1:
   *
   * 输入: 1
   * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
   * 示例 2:
   *
   * 输入: 2
   * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
   *  
   *
   * 限制：
   *
   * 1 <= n <= 11
   *
   */
  class Solution {

    public double[] dicesProbability(int n) {
      if (n == 0) {
        return new double[0];
      }
      int[] count = null;
      for (int i = 1; i <= n; i++) {
        int[] newCount = new int[5 * i + 1];
        if (count != null) {
          for (int j = 0; j <= 5; j++) {
            for (int k = 0; k < count.length; k++) {
              newCount[k + j] += count[k];
            }
          }
        } else {
          Arrays.fill(newCount, 1);
        }
        count = newCount;
      }
      int sum = 0;
      for (int i : count) {
        sum += i;
      }
      double[] result = new double[count.length];
      for (int i = 0; i < result.length; i++) {
        result[i] = count[i] / (double) sum;
      }
      return result;
    }
  }
}
