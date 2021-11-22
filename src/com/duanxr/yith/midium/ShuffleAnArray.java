package com.duanxr.yith.midium;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 段然 2021/11/16
 */
public class ShuffleAnArray {

  /**
   * Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.
   *
   * Implement the Solution class:
   *
   * Solution(int[] nums) Initializes the object with the integer array nums.
   * int[] reset() Resets the array to its original configuration and returns it.
   * int[] shuffle() Returns a random shuffling of the array.
   *  
   *
   * Example 1:
   *
   * Input
   * ["Solution", "shuffle", "reset", "shuffle"]
   * [[[1, 2, 3]], [], [], []]
   * Output
   * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
   *
   * Explanation
   * Solution solution = new Solution([1, 2, 3]);
   * solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
   *                        // Any permutation of [1,2,3] must be equally likely to be returned.
   *                        // Example: return [3, 1, 2]
   * solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
   * solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
   *
   *  
   *
   * Constraints:
   *
   * 1 <= nums.length <= 200
   * -106 <= nums[i] <= 106
   * All the elements of nums are unique.
   * At most 5 * 104 calls in total will be made to reset and shuffle.
   *
   * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
   *
   * 实现 Solution class:
   *
   * Solution(int[] nums) 使用整数数组 nums 初始化对象
   * int[] reset() 重设数组到它的初始状态并返回
   * int[] shuffle() 返回数组随机打乱后的结果
   *  
   *
   * 示例：
   *
   * 输入
   * ["Solution", "shuffle", "reset", "shuffle"]
   * [[[1, 2, 3]], [], [], []]
   * 输出
   * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
   *
   * 解释
   * Solution solution = new Solution([1, 2, 3]);
   * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
   * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
   * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
   *  
   *
   * 提示：
   *
   * 1 <= nums.length <= 200
   * -106 <= nums[i] <= 106
   * nums 中的所有元素都是 唯一的
   * 最多可以调用 5 * 104 次 reset 和 shuffle
   *
   */
  class Solution {

    private Random random;
    private int[] origin;
    private int[] current;

    public Solution(int[] nums) {
      this.random = new Random();
      this.origin = nums;
      this.current = Arrays.copyOf(origin, origin.length);
    }

    public int[] reset() {
      current = Arrays.copyOf(origin, origin.length);
      return current;
    }

    public int[] shuffle() {
      int length = current.length;
      int[] shuffled = new int[length];
      for (int i = length - 1; i > 0; i--) {
        int r = random.nextInt(i + 1);
        if (r != i) {
          int temp = current[r];
          current[r] = current[i];
          current[i] = temp;
        }
        shuffled[i] = current[i];
      }
      shuffled[0] = current[0];
      current = shuffled;
      return current;
    }
  }

}
