package com.duanxr.yith.easy;

import java.util.Arrays;

/**
 * @author 段然 2021/3/18
 */
public class ZuiXiaoDeKGeShuLcof {

  /**
   * English description is not available for the problem.
   *
   * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：arr = [3,2,1], k = 2
   * 输出：[1,2] 或者 [2,1]
   * 示例 2：
   *
   * 输入：arr = [0,1,2,1], k = 1
   * 输出：[0]
   *  
   *
   * 限制：
   *
   * 0 <= k <= arr.length <= 10000
   * 0 <= arr[i] <= 10000
   *
   */
  class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
      int[] a = halfQuickSort(arr, 0, arr.length - 1, k);
      return Arrays.copyOf(a, k);
    }

    private int[] halfQuickSort(int[] arr, int left, int right, int k) {
      if (arr.length < 1 || left >= right) {
        return arr;
      }
      boolean formRight = true;
      int pivot = arr[left];
      int l = left;
      int r = right;
      while (l < r) {
        if (formRight) {
          if (arr[r] < pivot) {
            arr[l] = arr[r];
            l++;
            formRight = false;
          } else {
            r--;
          }
        } else {
          if (arr[l] > pivot) {
            arr[r] = arr[l];
            r--;
            formRight = true;
          } else {
            l++;
          }
        }

      }
      arr[formRight ? l : r] = pivot;
      halfQuickSort(arr, left, l - 1, k);
      if (l <= k) {
        halfQuickSort(arr, l + 1, right, k);
      }
      return arr;
    }
  }

  class Solution1 {

    public int[] getLeastNumbers(int[] arr, int k) {
      int[] a = quickSort(arr, 0, arr.length - 1);
      return Arrays.copyOf(a, k);
    }

    private int[] quickSort(int[] arr, int left, int right) {
      if (arr.length < 1 || left >= right) {
        return arr;
      }
      boolean formRight = true;
      int pivot = arr[left];
      int l = left;
      int r = right;
      while (l < r) {
        if (formRight) {
          if (arr[r] < pivot) {
            arr[l] = arr[r];
            l++;
            formRight = false;
          } else {
            r--;
          }
        } else {
          if (arr[l] > pivot) {
            arr[r] = arr[l];
            r--;
            formRight = true;
          } else {
            l++;
          }
        }

      }
      arr[formRight ? l : r] = pivot;
      quickSort(arr, left, l - 1);
      quickSort(arr, l + 1, right);
      return arr;
    }
  }

  class Solution2 {

    public int[] getLeastNumbers(int[] arr, int k) {
      Arrays.sort(arr);
      return Arrays.copyOf(arr, k);
    }

  }
}
