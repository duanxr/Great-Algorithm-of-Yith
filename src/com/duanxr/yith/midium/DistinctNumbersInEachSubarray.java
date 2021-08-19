package com.duanxr.yith.midium;

/**
 * @author 段然 2021/8/19
 */
public class DistinctNumbersInEachSubarray {

  /**
   * Given an integer array nums and an integer k, you are asked to construct the array ans of size n-k+1 where ans[i] is the number of distinct numbers in the subarray nums[i:i+k-1] = [nums[i], nums[i+1], ..., nums[i+k-1]].
   *
   * Return the array ans.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [1,2,3,2,2,1,3], k = 3
   * Output: [3,2,2,2,3]
   * Explanation: The number of distinct elements in each subarray goes as follows:
   * - nums[0:2] = [1,2,3] so ans[0] = 3
   * - nums[1:3] = [2,3,2] so ans[1] = 2
   * - nums[2:4] = [3,2,2] so ans[2] = 2
   * - nums[3:5] = [2,2,1] so ans[3] = 2
   * - nums[4:6] = [2,1,3] so ans[4] = 3
   * Example 2:
   *
   * Input: nums = [1,1,1,1,2,3,4], k = 4
   * Output: [1,2,3,4]
   * Explanation: The number of distinct elements in each subarray goes as follows:
   * - nums[0:3] = [1,1,1,1] so ans[0] = 1
   * - nums[1:4] = [1,1,1,2] so ans[1] = 2
   * - nums[2:5] = [1,1,2,3] so ans[2] = 3
   * - nums[3:6] = [1,2,3,4] so ans[3] = 4
   *  
   *
   * Constraints:
   *
   * 1 <= k <= nums.length <= 105
   * 1 <= nums[i] <= 105
   *
   * 给你一个整数数组 nums与一个整数 k，请你构造一个长度 n-k+1 的数组 ans，这个数组第i个元素 ans[i] 是每个长度为k的子数组 nums[i:i+k-1] = [nums[i], nums[i+1], ..., nums[i+k-1]]中数字的种类数。
   *
   * 返回这个数组 ans。
   *
   * 示例 1:
   *
   * 输入: nums = [1,2,3,2,2,1,3], k = 3
   * 输出: [3,2,2,2,3]
   * 解释：每个子数组的数字种类计算方法如下：
   * - nums[0:2] = [1,2,3] 有'1','2','3'三种数字所以      ans[0] = 3
   * - nums[1:3] = [2,3,2] 有'2','3'两种数字所以          ans[1] = 2
   * - nums[2:4] = [3,2,2] 有'2','3'两种数字所以          ans[2] = 2
   * - nums[3:5] = [2,2,1] 有'1','2'两种数字所以          ans[3] = 2
   * - nums[4:6] = [2,1,3] 有'1','2','3'三种数字所以      ans[4] = 3
   * 示例 2:
   *
   * 输入: nums = [1,1,1,1,2,3,4], k = 4
   * 输出: [1,2,3,4]
   * 解释: 每个子数组的数字种类计算方法如下：
   * - nums[0:3] = [1,1,1,1] 只有'1'这一种数字所以         ans[0] = 1
   * - nums[1:4] = [1,1,1,2] 有'1','2'两种数字所以         ans[1] = 2
   * - nums[2:5] = [1,1,2,3] 有'1','2','3'三种数字所以     ans[2] = 3
   * - nums[3:6] = [1,2,3,4] 有'1','2','3','4'四种数字所以 ans[3] = 4
   *  
   *
   * 提示:
   *
   * 1 <= k <= nums.length <= 105
   * 1 <= nums[i] <= 105
   *
   */
  class Solution {

    public int[] distinctNumbers(int[] nums, int k) {
      int length = nums.length;
      int[] result = new int[length - k + 1];
      int[] map = new int[100001];
      int type = 0;
      for (int i = 0; i < length; i++) {
        int n = nums[i];
        int mn = map[n];
        if (mn == 0) {
          type++;
        }
        map[n] = mn + 1;
        int k1 = k - 1;
        if (i >= k1) {
          if (i >= k) {
            int sn = nums[i - k];
            int sm = map[sn];
            if (sm == 1) {
              type--;
            }
            map[sn] = sm - 1;
          }
          result[i - k1] = type;
        }
      }
      return result;
    }
  }

  class Solution1 {

    public int[] distinctNumbers(int[] nums, int k) {
      int[] result = new int[nums.length - k + 1];
      int[] map = new int[100001];
      int type = 0;
      for (int i = 0; i < nums.length; i++) {
        int n = nums[i];
        int mn = map[n];
        if (mn == 0) {
          type++;
        }
        map[n] = mn + 1;
        if (i >= k) {
          int sn = nums[i - k];
          int sm = map[sn];
          if (sm == 1) {
            type--;
          }
          map[sn] = sm - 1;
        }
        if (i >= k - 1) {
          result[i - k + 1] = type;
        }
      }
      return result;
    }
  }
}
