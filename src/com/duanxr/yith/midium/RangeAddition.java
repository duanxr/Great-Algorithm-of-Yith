package com.duanxr.yith.midium;

/**
 * @author 段然 2021/9/27
 */
public class RangeAddition {

  /**
   * You are given an integer length and an array updates where updates[i] = [startIdxi, endIdxi, inci].
   *
   * You have an array arr of length length with all zeros, and you have some operation to apply on arr. In the ith operation, you should increment all the elements arr[startIdxi], arr[startIdxi + 1], ..., arr[endIdxi] by inci.
   *
   * Return arr after applying all the updates.
   *
   *  
   *
   * Example 1:
   *
   *
   * Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
   * Output: [-2,0,3,5,3]
   * Example 2:
   *
   * Input: length = 10, updates = [[2,4,6],[5,6,8],[1,9,-4]]
   * Output: [0,-4,2,2,2,4,4,-4,-4,-4]
   *  
   *
   * Constraints:
   *
   * 1 <= length <= 105
   * 0 <= updates.length <= 104
   * 0 <= startIdxi <= endIdxi < length
   * -1000 <= inci <= 1000
   *
   * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k​​​​​​​ 个更新的操作。
   *
   * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
   *
   * 请你返回 k 次操作后的数组。
   *
   * 示例:
   *
   * 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
   * 输出: [-2,0,3,5,3]
   * 解释:
   *
   * 初始状态:
   * [0,0,0,0,0]
   *
   * 进行了操作 [1,3,2] 后的状态:
   * [0,2,2,2,0]
   *
   * 进行了操作 [2,4,3] 后的状态:
   * [0,2,5,5,3]
   *
   * 进行了操作 [0,2,-2] 后的状态:
   * [-2,0,3,5,3]
   *
   */
  class Solution {

    public int[] getModifiedArray(int length, int[][] updates) {
      int[] val = new int[length];
      for (int[] update : updates) {
        val[update[0]] += update[2];
        if (update[1] < length - 1) {
          val[update[1] + 1] -= update[2];
        }
      }
      int current = 0;
      for (int i = 0; i < length; i++) {
        val[i] = (current += val[i]);
      }
      return val;
    }
  }

  class Solution1 {

    public int[] getModifiedArray(int length, int[][] updates) {
      int[] val = new int[length];
      int[] rate = new int[length + 1];
      for (int[] update : updates) {
        rate[update[0]] += update[2];
        rate[update[1] + 1] -= update[2];
      }
      int current = 0;
      for (int i = 0; i < length; i++) {
        val[i] = (current += rate[i]);
      }

      return val;
    }
  }

}
