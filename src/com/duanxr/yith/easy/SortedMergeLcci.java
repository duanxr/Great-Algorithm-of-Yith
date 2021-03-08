package com.duanxr.yith.easy;

/**
 * @author Duanran 2020/3/3
 */
public class SortedMergeLcci {

  /**
   * You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold
   * B. Write a method to merge B into A in sorted order.
   *
   * Initially the number of elements in A and B are m and n respectively.
   *
   * Example:
   *
   * Input: A = [1,2,3,0,0,0], m = 3 B = [2,5,6],       n = 3
   *
   * Output: [1,2,2,3,5,6]
   *
   * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
   *
   * 初始化 A 和 B 的元素数量分别为 m 和 n。
   *
   * 示例:
   *
   * 输入:  A = [1,2,3,0,0,0], m = 3 B = [2,5,6],       n = 3
   *
   * 输出: [1,2,2,3,5,6]
   */
  class Solution {

    public void merge(int[] A, int m, int[] B, int n) {
      int ai = m - 1;
      int bi = n - 1;
      for (int i = A.length - 1; i >= 0; i--) {
        if (bi < 0) {
          A[i] = A[ai];
          ai--;
        } else if (ai < 0) {
          A[i] = B[bi];
          bi--;
        } else {
          if (A[ai] > B[bi]) {
            A[i] = A[ai];
            ai--;
          } else {
            A[i] = B[bi];
            bi--;
          }
        }
      }
    }
  }
}
