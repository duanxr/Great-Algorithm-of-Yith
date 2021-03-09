package com.duanxr.yith.hard;

import java.util.Arrays;

/**
 * @author 段然 2021/3/9
 */
public class MedianOfTwoSortedArrays {

  /**
   * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums1 = [1,3], nums2 = [2]
   * Output: 2.00000
   * Explanation: merged array = [1,2,3] and median is 2.
   * Example 2:
   *
   * Input: nums1 = [1,2], nums2 = [3,4]
   * Output: 2.50000
   * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
   * Example 3:
   *
   * Input: nums1 = [0,0], nums2 = [0,0]
   * Output: 0.00000
   * Example 4:
   *
   * Input: nums1 = [], nums2 = [1]
   * Output: 1.00000
   * Example 5:
   *
   * Input: nums1 = [2], nums2 = []
   * Output: 2.00000
   *  
   *
   * Constraints:
   *
   * nums1.length == m
   * nums2.length == n
   * 0 <= m <= 1000
   * 0 <= n <= 1000
   * 1 <= m + n <= 2000
   * -106 <= nums1[i], nums2[i] <= 106
   *  
   *
   * Follow up: The overall run time complexity should be O(log (m+n)).
   *
   * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：nums1 = [1,3], nums2 = [2]
   * 输出：2.00000
   * 解释：合并数组 = [1,2,3] ，中位数 2
   * 示例 2：
   *
   * 输入：nums1 = [1,2], nums2 = [3,4]
   * 输出：2.50000
   * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
   * 示例 3：
   *
   * 输入：nums1 = [0,0], nums2 = [0,0]
   * 输出：0.00000
   * 示例 4：
   *
   * 输入：nums1 = [], nums2 = [1]
   * 输出：1.00000
   * 示例 5：
   *
   * 输入：nums1 = [2], nums2 = []
   * 输出：2.00000
   *  
   *
   * 提示：
   *
   * nums1.length == m
   * nums2.length == n
   * 0 <= m <= 1000
   * 0 <= n <= 1000
   * 1 <= m + n <= 2000
   * -106 <= nums1[i], nums2[i] <= 106
   *
   */
  class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int m = nums1.length;
      int n = nums2.length;
      int mn = m + n;
      boolean odd = mn % 2 == 1;
      int half = mn / 2;
      int[] array = new int[half + 1];
      int mi = 0;
      int ni = 0;
      for (int i = 0; i < array.length; i++) {
        if (mi < m && (ni >= n || nums1[mi] < nums2[ni])) {
          array[i] = nums1[mi++];
        } else {
          array[i] = nums2[ni++];
        }
      }
      return odd ? (double) array[array.length - 1]
          : ((double) array[array.length - 1] + (double) array[array.length - 2]) / 2;

    }
  }
}
