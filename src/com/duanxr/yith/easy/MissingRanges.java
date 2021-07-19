package com.duanxr.yith.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/7/19
 */
public class MissingRanges {

  /**
   * You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.
   *
   * A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
   *
   * Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.
   *
   * Each range [a,b] in the list should be output as:
   *
   * "a->b" if a != b
   * "a" if a == b
   *  
   *
   * Example 1:
   *
   * Input: nums = [0,1,3,50,75], lower = 0, upper = 99
   * Output: ["2","4->49","51->74","76->99"]
   * Explanation: The ranges are:
   * [2,2] --> "2"
   * [4,49] --> "4->49"
   * [51,74] --> "51->74"
   * [76,99] --> "76->99"
   * Example 2:
   *
   * Input: nums = [], lower = 1, upper = 1
   * Output: ["1"]
   * Explanation: The only missing range is [1,1], which becomes "1".
   * Example 3:
   *
   * Input: nums = [], lower = -3, upper = -1
   * Output: ["-3->-1"]
   * Explanation: The only missing range is [-3,-1], which becomes "-3->-1".
   * Example 4:
   *
   * Input: nums = [-1], lower = -1, upper = -1
   * Output: []
   * Explanation: There are no missing ranges since there are no missing numbers.
   * Example 5:
   *
   * Input: nums = [-1], lower = -2, upper = -1
   * Output: ["-2"]
   *  
   *
   * Constraints:
   *
   * -109 <= lower <= upper <= 109
   * 0 <= nums.length <= 100
   * lower <= nums[i] <= upper
   * All the values of nums are unique.
   *
   * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
   *
   * 示例：
   *
   * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
   * 输出: ["2", "4->49", "51->74", "76->99"]
   *
   */
  class Solution {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
      List<String> list = new ArrayList<>(nums.length);
      if (nums.length == 0) {
        list.add(lower == upper ? toStr(lower) : toStr(lower, upper));
        return list;
      }
      int last = lower;
      for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        if (i == 0) {
          if (num != lower) {
            int r = num - 1;
            list.add(last == r ? toStr(last) : toStr(last, r));
          }
        } else if (num != last + 1) {
          int r = num - 1;
          int l = last + 1;
          list.add(l == r ? toStr(l) : toStr(l, r));
        }
        last = num;
      }
      if (last != upper) {
        int l = last + 1;
        list.add(l == upper ? toStr(l) : toStr(l, upper));
      }

      return list;
    }

    public String toStr(int i) {
      return String.valueOf(i);
    }

    public String toStr(int l, int r) {
      return l + "->" + r;
    }
  }


  class Solution1 {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
      List<String> list = new ArrayList<>();
      if (nums.length == 0) {
        int r = upper;
        int l = lower;
        String str = l == r ? toStr(l) : toStr(l, r);
        list.add(str);
        return list;
      }
      int last = lower;
      for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        if (i == 0) {
          if (num != lower) {
            int r = num - 1;
            int l = last;
            String str = l == r ? toStr(l) : toStr(l, r);
            list.add(str);
          }
        } else if (num != last + 1) {
          int r = num - 1;
          int l = last + 1;
          String str = l == r ? toStr(l) : toStr(l, r);
          list.add(str);
        }
        last = num;
      }
      if (last != upper) {
        int r = upper;
        int l = last + 1;
        String str = l == r ? toStr(l) : toStr(l, r);
        list.add(str);
      }

      return list;
    }

    public String toStr(int i) {
      return String.valueOf(i);
    }

    public String toStr(int l, int r) {
      return l + "->" + r;
    }
  }
}
