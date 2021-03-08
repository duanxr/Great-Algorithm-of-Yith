package com.duanxr.yith.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 段然 2021/3/8
 */
public class NextGreaterElementI {

  /**
   * You are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.
   *
   * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
   *
   * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, return -1 for this number.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
   * Output: [-1,3,-1]
   * Explanation:
   * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
   * For number 1 in the first array, the next greater number for it in the second array is 3.
   * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
   * Example 2:
   *
   * Input: nums1 = [2,4], nums2 = [1,2,3,4]
   * Output: [3,-1]
   * Explanation:
   * For number 2 in the first array, the next greater number for it in the second array is 3.
   * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
   *  
   *
   * Constraints:
   *
   * 1 <= nums1.length <= nums2.length <= 1000
   * 0 <= nums1[i], nums2[i] <= 104
   * All integers in nums1 and nums2 are unique.
   * All the integers of nums1 also appear in nums2.
   *  
   *
   * Follow up: Could you find an O(nums1.length + nums2.length) solution?
   *
   * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
   *
   * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
   *
   * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
   *
   *  
   *
   * 示例 1:
   *
   * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
   * 输出: [-1,3,-1]
   * 解释:
   *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
   *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
   *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
   * 示例 2:
   *
   * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
   * 输出: [3,-1]
   * 解释:
   *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
   *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
   *  
   *
   * 提示：
   *
   * 1 <= nums1.length <= nums2.length <= 1000
   * 0 <= nums1[i], nums2[i] <= 104
   * nums1和nums2中所有整数 互不相同
   * nums1 中的所有整数同样出现在 nums2 中
   *  
   *
   * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
   *
   */
  class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      Map<Integer, Integer> result = new HashMap<>();
      for (int i = 0; i < nums2.length; i++) {
        result.put(nums2[i], i);
      }
      int[] r = new int[nums1.length];
      OUTER:
      for (int j = 0; j < nums1.length; j++) {
        int n = nums1[j];
        for (int i = result.get(n); i < nums2.length; i++) {
          if (nums2[i] > n) {
            r[j] = nums2[i];
            continue OUTER;
          }
          r[j] = -1;
        }
      }
      return r;
    }
  }
}
