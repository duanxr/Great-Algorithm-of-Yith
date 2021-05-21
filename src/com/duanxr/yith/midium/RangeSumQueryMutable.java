package com.duanxr.yith.midium;

import java.util.Arrays;

/**
 * @author 段然 2021/5/19
 */
public class RangeSumQueryMutable {

  /**
   * Given an integer array nums, handle multiple queries of the following types:
   *
   * Update the value of an element in nums.
   * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
   * Implement the NumArray class:
   *
   * NumArray(int[] nums) Initializes the object with the integer array nums.
   * void update(int index, int val) Updates the value of nums[index] to be val.
   * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
   *  
   *
   * Example 1:
   *
   * Input
   * ["NumArray", "sumRange", "update", "sumRange"]
   * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
   * Output
   * [null, 9, null, 8]
   *
   * Explanation
   * NumArray numArray = new NumArray([1, 3, 5]);
   * numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
   * numArray.update(1, 2);   // nums = [1, 2, 5]
   * numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 3 * 104
   * -100 <= nums[i] <= 100
   * 0 <= index < nums.length
   * -100 <= val <= 100
   * 0 <= left <= right < nums.length
   * At most 3 * 104 calls will be made to update and sumRange.
   *
   * 给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。
   *
   * 实现 NumArray 类：
   *
   * NumArray(int[] nums) 用整数数组 nums 初始化对象
   * void update(int index, int val) 将 nums[index] 的值更新为 val
   * int sumRange(int left, int right) 返回子数组 nums[left, right] 的总和（即，nums[left] + nums[left + 1], ..., nums[right]）
   *  
   *
   * 示例：
   *
   * 输入：
   * ["NumArray", "sumRange", "update", "sumRange"]
   * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
   * 输出：
   * [null, 9, null, 8]
   *
   * 解释：
   * NumArray numArray = new NumArray([1, 3, 5]);
   * numArray.sumRange(0, 2); // 返回 9 ，sum([1,3,5]) = 9
   * numArray.update(1, 2);   // nums = [1,2,5]
   * numArray.sumRange(0, 2); // 返回 8 ，sum([1,2,5]) = 8
   *  
   *
   * 提示：
   *
   * 1 <= nums.length <= 3 * 104
   * -100 <= nums[i] <= 100
   * 0 <= index < nums.length
   * -100 <= val <= 100
   * 0 <= left <= right < nums.length
   * 最多调用 3 * 104 次 update 和 sumRange 方法
   *
   */
  class NumArray {

    int[] nums;

    public NumArray(int[] nums) {
      this.nums = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        int index = i;
        while (index < nums.length) {
          this.nums[index] += nums[i];
          index += getLowBit(index);
        }
      }
    }

    private int getLowBit(int n) {
      n += 1;
      return n & -n;
    }

    public void update(int i, int val) {
      int index = i;
      int addition = val - nums[index];
      while (index < nums.length) {
        this.nums[index] += addition;
        index += getLowBit(index);
      }
    }

    public int sumRange(int left, int right) {
      return getSum(right) - getSum(left - 1);
    }

    private int getSum(int i) {
      int sum = 0;
      while (i >= 0) {
        sum += nums[i];
        i -= getLowBit(i);
      }
      return sum;
    }
  }


  class NumArray2 {

    int[] nums;

    public NumArray2(int[] nums) {
      this.nums = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        int index = i;
        while (index < nums.length) {
          this.nums[index] += nums[i];
          index += lowbit(index);
        }
      }
    }

    private int lowbit(int n) {
      n++;
      return n & -n;
    }

    private int getVal(int i) {
      return sumRange(i, i);
    }

    public void update(int i, int val) {
      int index = i;
      int addition = val - getVal(index);
      while (index < nums.length) {
        this.nums[index] += addition;
        index += lowbit(index);
      }
    }

    public int sumRange(int left, int right) {
      return getSum(right) - getSum(left - 1);
    }

    private int getSum(int i) {
      int sum = 0;
      while (i >= 0) {
        sum += nums[i];
        i -= lowbit(i);
      }
      return sum;
    }
  }


  class NumArray1 {

    private int[] n;

    public NumArray1(int[] nums) {
      n = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        while (i < n.length) {
          n[i] += nums[i];
          i += getLowBit(i);
        }
      }
      System.out.println(Arrays.toString(Arrays.stream(n).toArray()));
    }

    public void update(int index, int val) {
      int presentVal = getVal(index);
      int addition = val - presentVal;
      while (index < n.length) {
        n[index] += addition;
        index += getLowBit(index);
        System.out.println(Arrays.toString(Arrays.stream(n).toArray()));

      }
    }

    public int sumRange(int left, int right) {
      return getVal(right) - getVal(left - 1);
    }

    private int getVal(int index) {
      int sum = 0;
      int lowbit = Integer.MAX_VALUE;
      while (index >= 0) {
        sum += n[index];
        index -= getLowBit(index);
      }
      return sum;
    }

    private int getLowBit(int index) {
      index++;
      return index & -index;
    }

  }
}
