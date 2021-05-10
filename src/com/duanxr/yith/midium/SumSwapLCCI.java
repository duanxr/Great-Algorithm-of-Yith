package com.duanxr.yith.midium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 段然 2021/5/10
 */
public class SumSwapLCCI {

  /**
   * Given two arrays of integers, find a pair of values (one value from each array) that you can swap to give the two arrays the same sum.
   *
   * Return an array, where the first element is the element in the first array that will be swapped, and the second element is another one in the second array. If there are more than one answers, return any one of them. If there is no answer, return an empty array.
   *
   * Example:
   *
   * Input: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
   * Output: [1, 3]
   * Example:
   *
   * Input: array1 = [1, 2, 3], array2 = [4, 5, 6]
   * Output: []
   * Note:
   *
   * 1 <= array1.length, array2.length <= 100000
   *
   * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
   *
   * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
   *
   * 示例:
   *
   * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
   * 输出: [1, 3]
   * 示例:
   *
   * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
   * 输出: []
   * 提示：
   *
   * 1 <= array1.length, array2.length <= 100000
   *
   */
  class Solution {

    public int[] findSwapValues(int[] array1, int[] array2) {
      Set<Integer> set1 = new HashSet<>();
      int count1 = 0;
      int count2 = 0;
      for (int i1 : array1) {
        count1 += i1;
        set1.add(i1);
      }
      for (int i2 : array2) {
        count2 += i2;
      }
      int diff = count2 - count1;
      if ((diff % 2) == 1) {
        return new int[0];
      }
      diff /= 2;
      for (int i2 : array2) {
        if (set1.contains(i2 - diff)) {
          int[] ints = new int[2];
          ints[0] = i2 - diff;
          ints[1] = i2;
          return ints;
        }
      }
      return new int[0];
    }
  }


  class Solution1 {

    public int[] findSwapValues(int[] array1, int[] array2) {
      Map<Integer, Integer> map = new HashMap<>();
      Set<Integer> set1 = new HashSet<>();
      Set<Integer> set2 = new HashSet<>();
      int count1 = 0;
      int count2 = 0;
      for (int i1 : array1) {
        count1 += i1;
        set1.add(i1);
      }
      for (int i2 : array2) {
        count2 += i2;
        if (!set2.contains(i2)) {
          set2.add(i2);
          for (Integer i1 : set1) {
            map.put(i2 - i1, i1);
          }
        }
      }
      int diff = count2 - count1;
      Integer integer = map.get(diff / 2);
      if (integer == null || (diff % 2) == 1) {
        return new int[0];
      }
      int[] ints = new int[2];
      ints[0] = integer;
      ints[1] = ints[0] + (diff / 2);
      return ints;
    }
  }
}
