package com.duanxr.yith.middle;

/**
 * @author 段然 2021/3/15
 */
public class GouJianChengJiShuZuLcof {

  /**
   * English description is not available for the problem.
   *
   * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
   *
   *  
   *
   * 示例:
   *
   * 输入: [1,2,3,4,5]
   * 输出: [120,60,40,30,24]
   *  
   *
   * 提示：
   *
   * 所有元素乘积之和不会溢出 32 位整数
   * a.length <= 100000
   *
   */
  class Solution {

    public int[] constructArr(int[] a) {
      int[] leftSum = new int[a.length];
      int count = 1;
      for (int i = 0; i < a.length; i++) {
        count *= a[i];
        leftSum[i] = count;
      }
      int[] arr = new int[a.length];
      count = 1;
      for (int i = a.length - 1; i >= 0; i--) {
        arr[i] = count * (i > 0 ? leftSum[i - 1] : 1);
        count *= a[i];
      }
      return arr;
    }
  }
}
