package com.duanxr.yith.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 段然 2021/3/8
 */
public class DistributeCandies {

  /**
   * Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to gain weight, so she visited a doctor.
   *
   * The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice.
   *
   * Given the integer array candyType of length n, return the maximum number of different types of candies she can eat if she only eats n / 2 of them.
   *
   *  
   *
   * Example 1:
   *
   * Input: candyType = [1,1,2,2,3,3]
   * Output: 3
   * Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type.
   * Example 2:
   *
   * Input: candyType = [1,1,2,3]
   * Output: 2
   * Explanation: Alice can only eat 4 / 2 = 2 candies. Whether she eats types [1,2], [1,3], or [2,3], she still can only eat 2 different types.
   * Example 3:
   *
   * Input: candyType = [6,6,6,6]
   * Output: 1
   * Explanation: Alice can only eat 4 / 2 = 2 candies. Even though she can eat 2 candies, she only has 1 type.
   *  
   *
   * Constraints:
   *
   * n == candyType.length
   * 2 <= n <= 104
   * n is even.
   * -105 <= candyType[i] <= 105
   *
   * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
   *
   * 示例 1:
   *
   * 输入: candies = [1,1,2,2,3,3]
   * 输出: 3
   * 解析: 一共有三种种类的糖果，每一种都有两个。
   *      最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
   * 示例 2 :
   *
   * 输入: candies = [1,1,2,3]
   * 输出: 2
   * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
   * 注意:
   *
   * 数组的长度为[2, 10,000]，并且确定为偶数。
   * 数组中数字的大小在范围[-100,000, 100,000]内。
   *
   */
  class Solution {

    public int distributeCandies(int[] candies) {
      int sr = 0;
      Set<Integer> set = new HashSet<>();
      for (int i : candies) {
        set.add(i);
      }
      int h = candies.length / 2;
      int l = set.size();
      return l > h ? h : l;
    }
  }
}
