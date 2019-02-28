package com.duanxr.yith.easy;

/**
 * @author Duanran 2019/2/13 0013
 */
public class SortArrayByParityII {

  /**
   * Given an array A of non-negative integers, half of the integers in A are odd, and half of the
   * integers are even.
   *
   * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
   *
   * You may return any answer array that satisfies this condition.
   *
   *
   *
   * Example 1:
   *
   * Input: [4,2,5,7]
   *
   * Output: [4,5,2,7]
   *
   * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
   *
   *
   * Note:
   *
   * 2 <= A.length <= 20000
   *
   * A.length % 2 == 0
   *
   * 0 <= A[i] <= 1000
   *
   * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
   *
   * 你可以返回任何满足上述条件的数组作为答案。
   *
   *
   *
   * 示例：
   *
   * 输入：[4,2,5,7]
   *
   * 输出：[4,5,2,7]
   *
   * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
   *
   *
   * 提示：
   *
   * 2 <= A.length <= 20000
   *
   * A.length % 2 == 0
   *
   * 0 <= A[i] <= 1000
   */
  class Solution {

    public int[] sortArrayByParityII(int[] A) {
      int[] result = new int[A.length];
      int odd = 1;
      int even = 0;
      for (int nowInt : A) {
        if (nowInt % 2 == 0) {
          result[even] = nowInt;
          even += 2;
        } else {
          result[odd] = nowInt;
          odd += 2;
        }
      }
      return result;
    }
  }
}
