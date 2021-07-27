package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/7/27
 */
public class LongestCommonSubsequenceBetweenSortedArrays {

  /**
   * Given an array of integer arrays arrays where each arrays[i] is sorted in strictly increasing order, return an integer array representing the longest common subsequence between all the arrays.
   *
   * A subsequence is a sequence that can be derived from another sequence by deleting some elements (possibly none) without changing the order of the remaining elements.
   *
   *  
   *
   * Example 1:
   *
   * Input: arrays = [[1,3,4],
   *                  [1,4,7,9]]
   * Output: [1,4]
   * Explanation: The longest common subsequence in the two arrays is [1,4].
   * Example 2:
   *
   * Input: arrays = [[2,3,6,8],
   *                  [1,2,3,5,6,7,10],
   *                  [2,3,4,6,9]]
   * Output: [2,3,6]
   * Explanation: The longest common subsequence in all three arrays is [2,3,6].
   * Example 3:
   *
   * Input: arrays = [[1,2,3,4,5],
   *                  [6,7,8]]
   * Output: []
   * Explanation: There is no common subsequence between the two arrays.
   *  
   *
   * Constraints:
   *
   * 2 <= arrays.length <= 100
   * 1 <= arrays[i].length <= 100
   * 1 <= arrays[i][j] <= 100
   * arrays[i] is sorted in strictly increasing order.
   *
   * 给定一个由整数数组组成的数组arrays，其中arrays[i]是严格递增排序的，返回一个表示所有数组之间的最长公共子序列的整数数组。
   *
   * 子序列是从另一个序列派生出来的序列，删除一些元素或不删除任何元素，而不改变其余元素的顺序。
   *
   * 示例1:
   *
   * 输入: arrays = [[1,3,4],
   *                [1,4,7,9]]
   * 输出: [1,4]
   * 解释: 这两个数组中的最长子序列是[1,4]。
   * 示例 2:
   *
   * 输入: arrays = [[2,3,6,8],
   *                [1,2,3,5,6,7,10],
   *                [2,3,4,6,9]]
   * 输出: [2,3,6]
   * 解释: 这三个数组中的最长子序列是[2,3,6]。
   * 示例 3:
   *
   * 输入: arrays = [[1,2,3,4,5],
   *                [6,7,8]]
   * 输出: []
   * 解释: 这两个数组之间没有公共子序列。
   *  
   *
   * 限制条件:
   *
   * 2 <= arrays.length <= 100
   * 1 <= arrays[i].length <= 100
   * 1 <= arrays[i][j] <= 100
   * arrays[i] 是严格递增排序.
   *
   */
  class Solution {

    public List<Integer> longestCommomSubsequence(int[][] arrays) {
      int[] map = new int[101];
      for (int[] array : arrays) {
        for (int i : array) {
          map[i]++;
        }
      }
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j < map.length; j++) {
        int i = map[j];
        if (i == arrays.length) {
          list.add(j);
        }
      }
      return list;
    }
  }
}
