package com.duanxr.yith.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 段然 2021/3/8
 */
public class DegreeOfAnArray {

  /**
   * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
   *
   * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [1,2,2,3,1]
   * Output: 2
   * Explanation:
   * The input array has a degree of 2 because both elements 1 and 2 appear twice.
   * Of the subarrays that have the same degree:
   * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
   * The shortest length is 2. So return 2.
   * Example 2:
   *
   * Input: nums = [1,2,2,3,1,4,2]
   * Output: 6
   * Explanation:
   * The degree is 3 because the element 2 is repeated 3 times.
   * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
   *  
   *
   * Constraints:
   *
   * nums.length will be between 1 and 50,000.
   * nums[i] will be an integer between 0 and 49,999.
   *
   * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
   *
   * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：[1, 2, 2, 3, 1]
   * 输出：2
   * 解释：
   * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
   * 连续子数组里面拥有相同度的有如下所示:
   * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
   * 最短连续子数组[2, 2]的长度为2，所以返回2.
   * 示例 2：
   *
   * 输入：[1,2,2,3,1,4,2]
   * 输出：6
   *  
   *
   * 提示：
   *
   * nums.length 在1到 50,000 区间范围内。
   * nums[i] 是一个在 0 到 49,999 范围内的整数。
   *
   */
  class Solution {

    private class ArrayHelper {

      public int left;
      public int right;
      public int count;
      public int n;
    }

    public int findShortestSubArray(int[] nums) {
      Map<Integer, ArrayHelper> count = new HashMap<>();
      int max = 0;
      for (int i = 0; i < nums.length; i++) {
        int n = nums[i];
        if (!count.containsKey(n)) {
          ArrayHelper arrayHelper = new ArrayHelper();
          arrayHelper.left = i;
          arrayHelper.right = i;
          arrayHelper.count = 1;
          arrayHelper.n = n;
          count.put(n, arrayHelper);
          max = Math.max(max, 1);
        } else {
          ArrayHelper arrayHelper = count.get(n);
          arrayHelper.count = arrayHelper.count + 1;
          arrayHelper.right = i;
          max = Math.max(max, arrayHelper.count);
        }
      }
      int r = Integer.MAX_VALUE;
      for (java.util.Map.Entry<Integer, ArrayHelper> entry : count.entrySet()) {
        ArrayHelper arrayHelper = entry.getValue();
        if (arrayHelper.count == max) {
          int n = entry.getKey();
          r = Math.min(arrayHelper.right - arrayHelper.left + 1, r);
        }
      }
      return r;
    }

  }
}
