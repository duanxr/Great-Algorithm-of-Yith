package com.duanxr.yith.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 段然 2021/3/8
 */
public class TwoSumIIInputArrayIsSorted {

  /**
   * Given an array of integers numbers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
   *
   * Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
   *
   * You may assume that each input would have exactly one solution and you may not use the same element twice.
   *
   *  
   *
   * Example 1:
   *
   * Input: numbers = [2,7,11,15], target = 9
   * Output: [1,2]
   * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
   * Example 2:
   *
   * Input: numbers = [2,3,4], target = 6
   * Output: [1,3]
   * Example 3:
   *
   * Input: numbers = [-1,0], target = -1
   * Output: [1,2]
   *  
   *
   * Constraints:
   *
   * 2 <= numbers.length <= 3 * 104
   * -1000 <= numbers[i] <= 1000
   * numbers is sorted in increasing order.
   * -1000 <= target <= 1000
   * Only one valid answer exists.
   *
   * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
   *
   * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
   *
   * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
   *
   *  
   * 示例 1：
   *
   * 输入：numbers = [2,7,11,15], target = 9
   * 输出：[1,2]
   * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
   * 示例 2：
   *
   * 输入：numbers = [2,3,4], target = 6
   * 输出：[1,3]
   * 示例 3：
   *
   * 输入：numbers = [-1,0], target = -1
   * 输出：[1,2]
   *  
   *
   * 提示：
   *
   * 2 <= numbers.length <= 3 * 104
   * -1000 <= numbers[i] <= 1000
   * numbers 按 递增顺序 排列
   * -1000 <= target <= 1000
   * 仅存在一个有效答案
   *
   */
  class Solution {

    public int[] twoSum(int[] numbers, int target) {
      Map<Integer, Integer> map = new HashMap<>(numbers.length / 2);
      for (int i = 0; i < numbers.length; i++) {
        if (map.containsKey(target - numbers[i])) {
          int[] r = new int[2];
          r[0] = map.get(target - numbers[i]) + 1;
          r[1] = i + 1;
          return r;
        }
        map.put(numbers[i], i);
      }
      return null;
    }
  }
}
