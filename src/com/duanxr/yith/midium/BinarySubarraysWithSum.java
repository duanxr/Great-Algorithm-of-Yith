package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 段然 2021/7/8
 */
public class BinarySubarraysWithSum {

  /**
   * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
   *
   * A subarray is a contiguous part of the array.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [1,0,1,0,1], goal = 2
   * Output: 4
   * Explanation: The 4 subarrays are bolded and underlined below:
   * [1,0,1,0,1]
   * [1,0,1,0,1]
   * [1,0,1,0,1]
   * [1,0,1,0,1]
   * Example 2:
   *
   * Input: nums = [0,0,0,0,0], goal = 0
   * Output: 15
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 3 * 104
   * nums[i] is either 0 or 1.
   * 0 <= goal <= nums.length
   *
   * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
   *
   * 子数组 是数组的一段连续部分。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：nums = [1,0,1,0,1], goal = 2
   * 输出：4
   * 解释：
   * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
   * 示例 2：
   *
   * 输入：nums = [0,0,0,0,0], goal = 0
   * 输出：15
   *  
   *
   * 提示：
   *
   * 1 <= nums.length <= 3 * 104
   * nums[i] 不是 0 就是 1
   * 0 <= goal <= nums.length
   *
   */
  class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
      int count = 0;
      int sum = 0;
      int l = nums.length;
      int[] map = new int[l << 1 + 1];
      map[l] = 1;
      for (int n : nums) {
        sum += n;
        count += map[l + sum - goal];
        map[l + sum]++;
      }
      return count;
    }
  }

  class Solution3 {

    public int numSubarraysWithSum(int[] nums, int goal) {
      int count = 0;
      int sum = 0;
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);
      for (int i = 0; i < nums.length; i++) {
        int n = nums[i];
        sum += n;
        count += map.getOrDefault(sum - goal, 0);
        map.compute(sum, (k, v) -> v == null ? 1 : 1 + v);
      }
      return count;
    }
  }


  class Solution2 {

    public int numSubarraysWithSum(int[] nums, int goal) {
      int sum = 0;
      int[] array = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        int n = nums[i];
        for (int j = 0; j <= i; j++) {
          int c = array[j] + n;
          if (c == goal) {
            sum++;
          }
          array[j] = c;
        }
        System.out.println(Arrays.toString(array));
      }
      return sum;
    }
  }


  class Solution1 {

    public int numSubarraysWithSum(int[] nums, int goal) {
      int sum = 0;
      List<Integer> list = new ArrayList<>();
      for (int n : nums) {
        List<Integer> l = new ArrayList<>();
        for (Integer i : list) {
          l.add(n + i);
        }
        l.add(n);
        list = l;
        System.out.println(list);
        for (Integer integer : list) {
          if (integer == goal) {
            sum++;
          }
        }
      }
      return sum;
    }
  }
}
