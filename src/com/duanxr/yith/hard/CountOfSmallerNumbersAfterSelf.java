package com.duanxr.yith.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/7/23
 */
public class CountOfSmallerNumbersAfterSelf {

  /**
   * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [5,2,6,1]
   * Output: [2,1,1,0]
   * Explanation:
   * To the right of 5 there are 2 smaller elements (2 and 1).
   * To the right of 2 there is only 1 smaller element (1).
   * To the right of 6 there is 1 smaller element (1).
   * To the right of 1 there is 0 smaller element.
   * Example 2:
   *
   * Input: nums = [-1]
   * Output: [0]
   * Example 3:
   *
   * Input: nums = [-1,-1]
   * Output: [0,0]
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 105
   * -104 <= nums[i] <= 104
   *
   * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
   *
   *  
   *
   * 示例：
   *
   * 输入：nums = [5,2,6,1]
   * 输出：[2,1,1,0]
   * 解释：
   * 5 的右侧有 2 个更小的元素 (2 和 1)
   * 2 的右侧仅有 1 个更小的元素 (1)
   * 6 的右侧有 1 个更小的元素 (1)
   * 1 的右侧有 0 个更小的元素
   *  
   *
   * 提示：
   *
   * 0 <= nums.length <= 10^5
   * -10^4 <= nums[i] <= 10^4
   *
   */
  class Solution {

    public List<Integer> countSmaller(int[] nums) {
      int[] result = new int[nums.length];
      int[] ints = new int[nums.length];
      int n = nums.length - 1;
      for (int i = n; i >= 0; i--) {
        int size = nums.length - 1 - i;
        int j = binarySearch(ints, size, nums[i]);
        result[i] = j;
        if (i != 0) {
          add(ints, j, size, nums[i]);
        }
      }
      List<Integer> list = new ArrayList<>(nums.length);
      for (int i : result) {
        list.add(i);
      }
      return list;
    }

    private void add(int[] ints, int j, int i, int num) {
      if (i - (j - 1) >= 0) {
        System.arraycopy(ints, j, ints, j + 1, i - (j - 1));
      }
      ints[j] = num;
    }

    private int binarySearch(int[] a, int toIndex,
        int key) {
      int low = 0;
      int high = toIndex - 1;

      while (low <= high) {
        int mid = (low + high) >>> 1;
        int midVal = a[mid];

        if (midVal < key) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      return low;
    }

  }


  class Solution1 {

    public List<Integer> countSmaller(int[] nums) {
      int[] result = new int[nums.length];
      int[] ints = new int[nums.length];
      for (int i = nums.length - 1; i >= 0; i--) {
        int j = binarySearch(ints, 0, nums.length - 1 - i, nums[i]);
        result[i] = j;
        if (i != 0) {
          add(ints, j, nums.length - 1 - i, nums[i]);
        }
      }
      List<Integer> list = new ArrayList<>(nums.length);
      for (int i : result) {
        list.add(i);
      }
      return list;
    }

    private void add(int[] ints, int j, int i, int num) {
      for (int k = i; k > j - 1; k--) {
        ints[k + 1] = ints[k];
      }
      ints[j] = num;
    }

    private int binarySearch(int[] a, int fromIndex, int toIndex,
        int key) {
      int low = fromIndex;
      int high = toIndex - 1;

      while (low <= high) {
        int mid = (low + high) >>> 1;
        int midVal = a[mid];

        if (midVal < key) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      return low;
    }


  }
}
