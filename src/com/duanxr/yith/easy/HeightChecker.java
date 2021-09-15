package com.duanxr.yith.easy;

import java.util.Arrays;

/**
 * @author 段然 2021/9/15
 */
public class HeightChecker {

  /**
   * A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
   *
   * You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).
   *
   * Return the number of indices where heights[i] != expected[i].
   *
   *  
   *
   * Example 1:
   *
   * Input: heights = [1,1,4,2,1,3]
   * Output: 3
   * Explanation:
   * heights:  [1,1,4,2,1,3]
   * expected: [1,1,1,2,3,4]
   * Indices 2, 4, and 5 do not match.
   * Example 2:
   *
   * Input: heights = [5,1,2,3,4]
   * Output: 5
   * Explanation:
   * heights:  [5,1,2,3,4]
   * expected: [1,2,3,4,5]
   * All indices do not match.
   * Example 3:
   *
   * Input: heights = [1,2,3,4,5]
   * Output: 0
   * Explanation:
   * heights:  [1,2,3,4,5]
   * expected: [1,2,3,4,5]
   * All indices match.
   *  
   *
   * Constraints:
   *
   * 1 <= heights.length <= 100
   * 1 <= heights[i] <= 100
   *
   * 学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
   *
   * 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
   *
   * 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
   *
   * 返回满足 heights[i] != expected[i] 的 下标数量 。
   *
   *  
   *
   * 示例：
   *
   * 输入：heights = [1,1,4,2,1,3]
   * 输出：3
   * 解释：
   * 高度：[1,1,4,2,1,3]
   * 预期：[1,1,1,2,3,4]
   * 下标 2 、4 、5 处的学生高度不匹配。
   * 示例 2：
   *
   * 输入：heights = [5,1,2,3,4]
   * 输出：5
   * 解释：
   * 高度：[5,1,2,3,4]
   * 预期：[1,2,3,4,5]
   * 所有下标的对应学生高度都不匹配。
   * 示例 3：
   *
   * 输入：heights = [1,2,3,4,5]
   * 输出：0
   * 解释：
   * 高度：[1,2,3,4,5]
   * 预期：[1,2,3,4,5]
   * 所有下标的对应学生高度都匹配。
   *  
   *
   * 提示：
   *
   * 1 <= heights.length <= 100
   * 1 <= heights[i] <= 100
   *
   */
  class Solution {

    public int heightChecker(int[] heights) {
      int[] ints = Arrays.copyOf(heights, heights.length);
      Arrays.sort(ints);
      int count = 0;

      for (int i = 0; i < ints.length; i++) {
        if (heights[i] != ints[i]) {
          count++;
        }
      }

      return count;
    }
  }
}
