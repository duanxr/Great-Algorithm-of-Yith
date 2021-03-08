package com.duanxr.yith.easy;

import java.util.Arrays;

/**
 * @author 段然 2021/3/8
 */
public class MergeSortedArray {

  /**
   * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
   *
   * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
   * Output: [1,2,2,3,5,6]
   * Example 2:
   *
   * Input: nums1 = [1], m = 1, nums2 = [], n = 0
   * Output: [1]
   *  
   *
   * Constraints:
   *
   * nums1.length == m + n
   * nums2.length == n
   * 0 <= m, n <= 200
   * 1 <= m + n <= 200
   * -109 <= nums1[i], nums2[i] <= 109
   *
   * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
   *
   * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
   * 输出：[1,2,2,3,5,6]
   * 示例 2：
   *
   * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
   * 输出：[1]
   *  
   *
   * 提示：
   *
   * nums1.length == m + n
   * nums2.length == n
   * 0 <= m, n <= 200
   * 1 <= m + n <= 200
   * -109 <= nums1[i], nums2[i] <= 109
   *
   */
  class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
      int[] nums3 = Arrays.copyOf(nums1, m);
      int im = 0;
      int in = 0;
      for (int i = 0; i < nums1.length; i++) {
        int nn;
        if (in >= nums2.length || im < nums3.length && nums3[im] < nums2[in]) {
          nn = nums3[im++];
        } else {
          nn = nums2[in++];
        }
        nums1[i] = nn;
      }
    }
  }
}
