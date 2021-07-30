package com.duanxr.yith.midium;

/**
 * @author 段然 2021/7/30
 */
public class MinimumIncrementToMakeArrayUnique {

  /**
   * Given an array of integers nums, a move consists of choosing any nums[i], and incrementing it by 1.
   *
   * Return the least number of moves to make every value in nums unique.
   *
   *  
   *
   * Example 1:
   *
   * Input: nums = [1,2,2]
   * Output: 1
   * Explanation:  After 1 move, the array could be [1, 2, 3].
   * Example 2:
   *
   * Input: nums = [3,2,1,2,1,7]
   * Output: 6
   * Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
   * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
   *  
   *
   * Note:
   *
   * 0 <= nums.length <= 40000
   * 0 <= nums[i] < 40000
   *  
   *
   * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
   *
   * 返回使 A 中的每个值都是唯一的最少操作次数。
   *
   * 示例 1:
   *
   * 输入：[1,2,2]
   * 输出：1
   * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
   * 示例 2:
   *
   * 输入：[3,2,1,2,1,7]
   * 输出：6
   * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
   * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
   * 提示：
   *
   * 0 <= A.length <= 40000
   * 0 <= A[i] < 40000
   *
   */
  class Solution {

    public int minIncrementForUnique(int[] nums) {
      int[] map = new int[40001];
      int move = 0;
      for (int num : nums) {
        map[num]++;
      }
      for (int val = 0; val < map.length; val++) {
        int count = map[val];
        if (count != 0) {
          int moved = count - 1;
          if (val != map.length - 1) {
            move += moved;
            map[val + 1] += moved;
          } else {
            for (int each = 1; each <= moved; each++) {
              move += each;
            }
          }
        }
      }
      return move;
    }
  }
}
