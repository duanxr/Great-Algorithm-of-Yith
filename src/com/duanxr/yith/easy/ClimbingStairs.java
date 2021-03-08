package com.duanxr.yith.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 段然 2021/3/8
 */
public class ClimbingStairs {

  /**
   * You are climbing a staircase. It takes n steps to reach the top.
   *
   * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
   *
   *  
   *
   * Example 1:
   *
   * Input: n = 2
   * Output: 2
   * Explanation: There are two ways to climb to the top.
   * 1. 1 step + 1 step
   * 2. 2 steps
   * Example 2:
   *
   * Input: n = 3
   * Output: 3
   * Explanation: There are three ways to climb to the top.
   * 1. 1 step + 1 step + 1 step
   * 2. 1 step + 2 steps
   * 3. 2 steps + 1 step
   *  
   *
   * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
   *
   * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
   *
   * 注意：给定 n 是一个正整数。
   *
   * 示例 1：
   *
   * 输入： 2
   * 输出： 2
   * 解释： 有两种方法可以爬到楼顶。
   * 1.  1 阶 + 1 阶
   * 2.  2 阶
   * 示例 2：
   *
   * 输入： 3
   * 输出： 3
   * 解释： 有三种方法可以爬到楼顶。
   * 1.  1 阶 + 1 阶 + 1 阶
   * 2.  1 阶 + 2 阶
   * 3.  2 阶 + 1 阶
   *
   */
  class Solution {

    private Map<Integer, Integer> map;

    public Solution() {
      map = new HashMap<>();
      map.put(1, 1);
      map.put(2, 2);
    }

    public int climbStairs(int n) {
      if (map.containsKey(n)) {
        return map.get(n);
      } else {
        int value = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, value);
        return value;
      }
    }
  }
}
