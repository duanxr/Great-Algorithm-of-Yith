package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/7/15
 */
public class FrequencyOfTheMostFrequentElement {

  /**
   * The frequency of an element is the number of times it occurs in an array.
   *
   * You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
   *
   * Return the maximum possible frequency of an element after performing at most k operations.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [1,2,4], k = 5
   * Output: 3
   * Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
   * 4 has a frequency of 3.
   * Example 2:
   *
   * Input: nums = [1,4,8,13], k = 5
   * Output: 2
   * Explanation: There are multiple optimal solutions:
   * - Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
   * - Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
   * - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
   * Example 3:
   *
   * Input: nums = [3,9,6], k = 2
   * Output: 1
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 105
   * 1 <= nums[i] <= 105
   * 1 <= k <= 105
   *
   * 元素的 频数 是该元素在一个数组中出现的次数。
   *
   * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
   *
   * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：nums = [1,2,4], k = 5
   * 输出：3
   * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
   * 4 是数组中最高频元素，频数是 3 。
   * 示例 2：
   *
   * 输入：nums = [1,4,8,13], k = 5
   * 输出：2
   * 解释：存在多种最优解决方案：
   * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
   * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
   * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
   * 示例 3：
   *
   * 输入：nums = [3,9,6], k = 2
   * 输出：1
   *  
   *
   * 提示：
   *
   * 1 <= nums.length <= 105
   * 1 <= nums[i] <= 105
   * 1 <= k <= 105
   *
   */
  class Solution {

    public int maxFrequency(int[] nums, int k) {
      int[] ints = new int[100001];
      for (int num : nums) {
        ints[num]++;
      }
      List<Integer> stack = new ArrayList<>(100001);
      int max = 0;
      for (int i = 0; i < ints.length; i++) {
        int n = ints[i];
        if (n != 0) {
          int cm = n;
          int ck = k;

          for (int li = stack.size() - 1; li >= 0; li--) {
            Integer j = stack.get(li);
            int nj = ints[j];
            int ss = i - j;
            int s = ck / ss;
            if (s <= 0) {
              break;
            }
            s = Math.min(s, nj);
            cm += s;
            ck -= s * ss;
          }

          if (cm > max) {
            max = cm;
          }
          stack.add(i);
        }
      }
      return max;
    }
  }


  class Solution1 {

    public int maxFrequency(int[] nums, int k) {
      int[] ints = new int[100001];
      for (int num : nums) {
        ints[num]++;
      }
      int max = 0;
      for (int i = 0; i < ints.length; i++) {
        int n = ints[i];
        if (n != 0) {
          int cm = n;
          int ck = k;
          for (int j = i - 1; j >= 0; j--) {
            int nj = ints[j];
            if (nj != 0) {
              int s = ck / (i - j);
              if (s <= 0) {
                break;
              }
              s = Math.min(s, nj);
              cm += s;
              ck -= s * (i - j);
            }
          }

          if (cm > max) {
            max = cm;
          }
        }
      }
      return max;
    }
  }
}
