package com.duanxr.yith.midium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 段然 2021/5/24
 */
public class LongestArithmeticSubsequenceOfGivenDifference {

  /**
   * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
   *
   * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：arr = [1,2,3,4], difference = 1
   * 输出：4
   * 解释：最长的等差子序列是 [1,2,3,4]。
   * 示例 2：
   *
   * 输入：arr = [1,3,5,7], difference = 1
   * 输出：1
   * 解释：最长的等差子序列是任意单个元素。
   * 示例 3：
   *
   * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
   * 输出：4
   * 解释：最长的等差子序列是 [7,5,3,1]。
   *  
   *
   * 提示：
   *
   * 1 <= arr.length <= 105
   * -104 <= arr[i], difference <= 104
   *
   * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
   *
   * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：arr = [1,2,3,4], difference = 1
   * 输出：4
   * 解释：最长的等差子序列是 [1,2,3,4]。
   * 示例 2：
   *
   * 输入：arr = [1,3,5,7], difference = 1
   * 输出：1
   * 解释：最长的等差子序列是任意单个元素。
   * 示例 3：
   *
   * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
   * 输出：4
   * 解释：最长的等差子序列是 [7,5,3,1]。
   *  
   *
   * 提示：
   *
   * 1 <= arr.length <= 105
   * -104 <= arr[i], difference <= 104
   *
   */
  class Solution {

    public int longestSubsequence(int[] arr, int difference) {
      int[] map = new int[65536];
      int max = 0;
      for (int n : arr) {
        int key = n + 32767;
        int remove = map[key] + 1;
        map[key + difference] = Math.max(map[key + difference], remove);
        max = Math.max(max, map[key + difference]);
      }
      return max;
    }
  }


  class Solution1 {

    public int longestSubsequence(int[] arr, int difference) {
      Map<Integer, Integer> map = new HashMap<>();
      int max = 0;
      for (int n : arr) {
        Integer remove = map.remove(n);
        max = Math.max(max, map.compute(n + difference, (k, v) -> {
          int c = remove == null ? 1 : remove + 1;
          int o = v == null ? 0 : v;
          return Math.max(c, o);
        }));
      }
      return max;
    }
  }
}
