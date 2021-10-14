package com.duanxr.yith.hard;

/**
 * @author 段然 2021/10/14
 */
public class ShuZuZhongDeNiXuDuiLcof {

  /**
   * English description is not available for the problem. Please switch to Chinese.
   *
   * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
   *
   *  
   *
   * 示例 1:
   *
   * 输入: [7,5,6,4]
   * 输出: 5
   *  
   *
   * 限制：
   *
   * 0 <= 数组长度 <= 50000
   *
   */
  class Solution {

    public int reversePairs(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }
      int count = 0;
      int size = 1;
      int[] arr = new int[50001];
      arr[0] = nums[0];
      for (int i = 1, numsLength = nums.length; i < numsLength; i++) {
        int num = nums[i];
        int index = binarySearch(arr, 0, size++, num);
        count += index;
        if (size - index >= 0) {
          System.arraycopy(arr, index, arr, index + 1, size - index);
        }
        arr[index] = num;
      }

      return count;
    }

    private int binarySearch(int[] arr, int fromIndex, int toIndex,
        int key) {
      int low = fromIndex;
      int high = toIndex - 1;
      while (low <= high) {
        int mid = (low + high) >>> 1;
        long midVal = arr[mid];
        if (midVal > key) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      return low;
    }
  }
}
