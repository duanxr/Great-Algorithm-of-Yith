package com.duanxr.yith.easy;

import java.util.Arrays;

/**
 * @author 段然 2021/3/8
 */
public class RangeSumQueryImmutable {

  /**
   * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
   *
   * Implement the NumArray class:
   *
   * NumArray(int[] nums) Initializes the object with the integer array nums.
   * int sumRange(int i, int j) Return the sum of the elements of the nums array in the range [i, j] inclusive (i.e., sum(nums[i], nums[i + 1], ... , nums[j]))
   *  
   *
   * Example 1:
   *
   * Input
   * ["NumArray", "sumRange", "sumRange", "sumRange"]
   * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
   * Output
   * [null, 1, -1, -3]
   *
   * Explanation
   * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
   * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
   * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
   * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
   *  
   *
   * Constraints:
   *
   * 0 <= nums.length <= 104
   * -105 <= nums[i] <= 105
   * 0 <= i <= j < nums.length
   * At most 104 calls will be made to sumRange.
   *
   * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
   *
   * 实现 NumArray 类：
   *
   * NumArray(int[] nums) 使用数组 nums 初始化对象
   * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
   *  
   *
   * 示例：
   *
   * 输入：
   * ["NumArray", "sumRange", "sumRange", "sumRange"]
   * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
   * 输出：
   * [null, 1, -1, -3]
   *
   * 解释：
   * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
   * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
   * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
   * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
   *  
   *
   * 提示：
   *
   * 0 <= nums.length <= 104
   * -105 <= nums[i] <= 105
   * 0 <= i <= j < nums.length
   * 最多调用 104 次 sumRange 方法
   *
   */
  class NumArray {

    private static final int MAX_DEEP = 14;
    private static final int MAX_SIZE = 3;

    private NumArray leftNode;
    private NumArray rightNode;
    private int[] nums;
    private int left;
    private int right;
    private int sum;
    private int half;
    private boolean isLeaf;

    public NumArray(int[] nums) {
      this(nums, 0, 0, nums.length - 1);
    }

    public NumArray(int[] nums, int deep, int left, int right) {
      this.left = left;
      this.right = right;
      sum = 0;
      Arrays.stream(nums).forEach(n -> sum += n);
      isLeaf = nums.length <= MAX_SIZE || deep >= MAX_DEEP;
      if (isLeaf) {
        this.nums = nums;
      } else {
        half = nums.length / 2;
        leftNode = new NumArray(Arrays.copyOfRange(nums, 0, half), deep + 1, left, left + half - 1);
        rightNode = new NumArray(Arrays.copyOfRange(nums, half, nums.length), deep + 1,
            left + half, right);
        half += left - 1;
      }
    }

    public int sumRange(int i, int j) {
      if (i == left && j == right) {
        return sum;
      }
      if (isLeaf) {
        int r = 0;
        for (int k = i - left; k <= j - left; k++) {
          r += nums[k];
        }
        return r;
      } else {
        if (j <= half) {
          return leftNode.sumRange(i, j);
        }
        if (i > half) {
          return rightNode.sumRange(i, j);
        }
        return leftNode.sumRange(i, half) + rightNode.sumRange(half + 1, j);
      }
    }


  }
}
