package com.duanxr.yith.easy;

/**
 * @author 段然 2021/10/14
 */
public class B1IidL {

  /**
   * English description is not available for the problem. Please switch to Chinese.
   *
   * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
   *
   * arr.length >= 3
   * 存在 i（0 < i < arr.length - 1）使得：
   * arr[0] < arr[1] < ... arr[i-1] < arr[i]
   * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
   * 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：arr = [0,1,0]
   * 输出：1
   * 示例 2：
   *
   * 输入：arr = [1,3,5,4,2]
   * 输出：2
   * 示例 3：
   *
   * 输入：arr = [0,10,5,2]
   * 输出：1
   * 示例 4：
   *
   * 输入：arr = [3,4,5,1]
   * 输出：2
   * 示例 5：
   *
   * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
   * 输出：2
   *  
   *
   * 提示：
   *
   * 3 <= arr.length <= 104
   * 0 <= arr[i] <= 106
   * 题目数据保证 arr 是一个山脉数组
   *  
   *
   * 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
   *
   *  
   *
   * 注意：本题与主站 852 题相同：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
   *
   */
  class Solution {

    public int peakIndexInMountainArray(int[] arr) {

      int ls1 = arr.length - 1;

      int low = 0;
      int high = ls1;

      while (low <= high) {
        int mid = (low + high) >>> 1;
        int midVal = arr[mid];
        int leftVal = mid == 0 ? Integer.MIN_VALUE : arr[mid - 1];
        int rightVal = mid == ls1 ? Integer.MIN_VALUE : arr[mid + 1];
        if (leftVal < midVal && rightVal > midVal) {
          low = mid + 1;
        } else if (leftVal > midVal && rightVal < midVal) {
          high = mid - 1;
        } else {
          return mid;
        }
      }
      return -(low + 1);
    }
  }


  class Solution1 {

    public int peakIndexInMountainArray(int[] arr) {
      int last = Integer.MIN_VALUE;
      for (int i = 0, arrLength = arr.length; i < arrLength; i++) {
        int n = arr[i];
        if (last > n) {
          return i - 1;
        }
        last = n;
      }
      return 0;
    }
  }

}
