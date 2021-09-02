package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/9/1
 */
public class NumberOfSubarraysWithBoundedMaximum {

  /**
   * Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays such that the value of the maximum array element in that subarray is in the range [left, right].
   *
   * The test cases are generated so that the answer will fit in a 32-bit integer.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [2,1,4,3], left = 2, right = 3
   * Output: 3
   * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
   * Example 2:
   *
   * Input: nums = [2,9,2,5,6], left = 2, right = 8
   * Output: 7
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 105
   * 0 <= nums[i] <= 109
   * 0 <= left <= right <= 109
   *
   * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
   *
   * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
   *
   * 例如 :
   * 输入:
   * A = [2, 1, 4, 3]
   * L = 2
   * R = 3
   * 输出: 3
   * 解释: 满足条件的子数组: [2], [2, 1], [3].
   * 注意:
   *
   * L, R  和 A[i] 都是整数，范围在 [0, 10^9]。
   * 数组 A 的长度范围在[1, 50000]。
   *
   */
  class Solution {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
      int be = 0;
      int ne = 0;
      int count = 0;
      for (int num : nums) {
        if (num <= right) {
          if (num >= left) {
            be += ne + 1;
            ne = 0;
          } else {
            ne += 1;
          }
          count += be;
        } else {
          be = 0;
          ne = 0;
        }
      }
      return count;
    }

  }


  class Solution1 {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
      List<Integer> list = new ArrayList<>();
      int count = 0;
      for (int num : nums) {
        if (num > right) {
          list.clear();
          continue;
        }
        list.add(num);
        for (int i = 0; i < list.size(); i++) {
          int n = list.get(i);
          if (n >= left) {
            count++;
          } else if (num >= left) {
            count++;
            list.set(i, num);
          }

        }
      }
      return count;
    }

    private boolean isLegal(int n, int left, int right) {
      return n >= left && n <= right;
    }

  }
}
