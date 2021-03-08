package com.duanxr.yith.easy;

import java.util.Arrays;
import java.util.SortedSet;

/**
 * @author Duanran 2020/3/3
 */
public class RelativeSortArray {

  /**
   * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
   *
   * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
   *
   * Example 1:
   *
   * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
   * Output: [2,2,2,1,4,3,3,9,6,7,19]
   *
   * Constraints:
   *
   * arr1.length, arr2.length <= 1000
   * 0 <= arr1[i], arr2[i] <= 1000
   * Each arr2[i] is distinct.
   * Each arr2[i] is in arr1.
   *
   * 给你两个数组，arr1 和 arr2，
   *
   * arr2 中的元素各不相同
   * arr2 中的每个元素都出现在 arr1 中
   * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
   *
   * 示例：
   *
   * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
   * 输出：[2,2,2,1,4,3,3,9,6,7,19]
   *  
   * 提示：
   *
   * arr1.length, arr2.length <= 1000
   * 0 <= arr1[i], arr2[i] <= 1000
   * arr2 中的元素 arr2[i] 各不相同
   * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
   */
  class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
      int max = 0;
      for (int i = 0; i < arr2.length; i++) {
        for (int j = max; j < arr1.length; j++) {
          if (arr1[j] == arr2[i]) {
            swap(arr1, max, j);
            max++;
          }
        }
      }
      Arrays.sort(arr1,max,arr1.length);
      return arr1;
    }

    private void swap(int[] array, int n1, int n2) {
      int temp = array[n1];
      array[n1] = array[n2];
      array[n2] = temp;
    }
  }
}
