package com.duanxr.yith.midium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 段然 2021/9/6
 */
public class SmallestKLCCI {

  /**
   * Design an algorithm to find the smallest K numbers in an array.
   *
   * Example:
   *
   * Input:  arr = [1,3,5,7,2,4,6,8], k = 4
   * Output:  [1,2,3,4]
   * Note:
   *
   * 0 <= len(arr) <= 100000
   * 0 <= k <= min(100000, len(arr))
   *
   * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
   *
   * 示例：
   *
   * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
   * 输出： [1,2,3,4]
   * 提示：
   *
   * 0 <= len(arr) <= 100000
   * 0 <= k <= min(100000, len(arr))
   *
   */
  class Solution {

    public int[] smallestK(int[] arr, int k) {
      if (arr.length == k || arr.length == 0) {
        return arr;
      }
      if (k == 0) {
        return new int[0];
      }
      PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
      for (int i : arr) {
        if (queue.size() < k || i < queue.peek()) {
          queue.offer(i);
          if (queue.size() > k) {
            queue.poll();
          }
        }
      }
      int[] ints = new int[queue.size()];
      int i = 0;
      for (Integer n : queue) {
        ints[i++] = n;
      }
      return ints;
    }
  }
}
