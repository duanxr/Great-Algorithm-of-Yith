package com.duanxr.yith.easy;

/**
 * @author 段然 2021/4/27
 */
public class DivingBoardLCCI {

  /**
   * You are building a diving board by placing a bunch of planks of wood end-to-end. There are two types of planks, one of length shorter and one of length longer. You must use exactly K planks of wood. Write a method to generate all possible lengths for the diving board.
   *
   * return all lengths in non-decreasing order.
   *
   * Example:
   *
   * Input:
   * shorter = 1
   * longer = 2
   * k = 3
   * Output:  {3,4,5,6}
   * Note:
   *
   * 0 < shorter <= longer
   * 0 <= k <= 100000
   *
   * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
   *
   * 返回的长度需要从小到大排列。
   *
   * 示例 1
   *
   * 输入：
   * shorter = 1
   * longer = 2
   * k = 3
   * 输出： [3,4,5,6]
   * 解释：
   * 可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。
   * 提示：
   *
   * 0 < shorter <= longer
   * 0 <= k <= 100000
   *
   */
  class Solution {

    public int[] divingBoard(int shorter, int longer, int k) {
      if (k == 0) {
        return new int[0];
      }
      if (shorter == longer) {
        int[] ints = new int[1];
        ints[0] = shorter * k;
        return ints;
      }
      int min = k * shorter;
      int max = k * longer;
      int sub = longer - shorter;
      int size = (max - min) / sub;
      int[] result = new int[size + 1];
      for (int i = 0; i <= size; i++) {
        result[i] = min;
        min += sub;
      }
      return result;
    }
  }
}
