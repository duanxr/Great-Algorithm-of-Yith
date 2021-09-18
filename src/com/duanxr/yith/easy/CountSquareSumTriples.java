package com.duanxr.yith.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 段然 2021/9/18
 */
public class CountSquareSumTriples {

  /**
   * A square triple (a,b,c) is a triple where a, b, and c are integers and a2 + b2 = c2.
   *
   * Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.
   *
   *  
   *
   * Example 1:
   *
   * Input: n = 5
   * Output: 2
   * Explanation: The square triples are (3,4,5) and (4,3,5).
   * Example 2:
   *
   * Input: n = 10
   * Output: 4
   * Explanation: The square triples are (3,4,5), (4,3,5), (6,8,10), and (8,6,10).
   *  
   *
   * Constraints:
   *
   * 1 <= n <= 250
   *
   * 一个 平方和三元组 (a,b,c) 指的是满足 a2 + b2 = c2 的 整数 三元组 a，b 和 c 。
   *
   * 给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：n = 5
   * 输出：2
   * 解释：平方和三元组为 (3,4,5) 和 (4,3,5) 。
   * 示例 2：
   *
   * 输入：n = 10
   * 输出：4
   * 解释：平方和三元组为 (3,4,5)，(4,3,5)，(6,8,10) 和 (8,6,10) 。
   *  
   *
   * 提示：
   *
   * 1 <= n <= 250
   *
   */
  class Solution {

    public int countTriples(int n) {
      Set<Integer> set = new HashSet<>();
      int[] list = new int[n];
      while (n > 0) {
        int pow = n * n;
        n--;
        set.add(pow);
        list[n] = pow;
      }
      int count = 0;
      for (int i = list.length - 1; i >= 0; i--) {
        int c = list[i];
        for (int j = i - 1; j >= 0; j--) {
          int b = list[j];
          if (set.contains(c - b)) {
            count++;
          }
        }
      }
      return count;
    }
  }


  class Solution1 {

    public int countTriples(int n) {
      Set<Integer> set = new HashSet<>();
      List<Integer> list = new ArrayList<>();
      while (n > 0) {
        int pow = n * n;
        n--;
        set.add(pow);
        list.add(pow);
      }
      int count = 0;
      for (int i = 0; i < list.size(); i++) {
        int c = list.get(i);
        for (int j = i + 1; j < list.size(); j++) {
          int b = list.get(j);
          if (set.contains(c - b)) {
            count++;
          }
        }
      }
      return count;
    }
  }
}
