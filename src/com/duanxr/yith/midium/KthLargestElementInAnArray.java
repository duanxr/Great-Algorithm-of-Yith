package com.duanxr.yith.midium;

import java.util.PriorityQueue;

/**
 * @author 段然 2021/6/29
 */
public class KthLargestElementInAnArray {

  /**
   * Given an integer array nums and an integer k, return the kth largest element in the array.
   *
   * Note that it is the kth largest element in the sorted order, not the kth distinct element.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [3,2,1,5,6,4], k = 2 Output: 5 Example 2:
   *
   * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4 Output: 4  
   *
   * Constraints:
   *
   * 1 <= k <= nums.length <= 104 -104 <= nums[i] <= 104
   *
   * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
   *
   * 示例 1:
   *
   * 输入: [3,2,1,5,6,4] 和 k = 2 输出: 5 示例 2:
   *
   * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4 输出: 4 说明:
   *
   * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
   */
  class Solution {

    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
      for (int n : nums) {
        maxHeap.offer(n);
        if (maxHeap.size() > k) {
          maxHeap.poll();
        }
      }
      return maxHeap.poll();
    }
  }
}
