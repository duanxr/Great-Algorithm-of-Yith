package com.duanxr.yith.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 段然 2021/7/29
 */
public class DistantBarcodes {

  /**
   * In a warehouse, there is a row of barcodes, where the ith barcode is barcodes[i].
   *
   * Rearrange the barcodes so that no two adjacent barcodes are equal. You may return any answer, and it is guaranteed an answer exists.
   *
   *  
   *
   * Example 1:
   *
   * Input: barcodes = [1,1,1,2,2,2]
   * Output: [2,1,2,1,2,1]
   * Example 2:
   *
   * Input: barcodes = [1,1,1,1,2,2,3,3]
   * Output: [1,3,1,3,1,2,1,2]
   *  
   *
   * Constraints:
   *
   * 1 <= barcodes.length <= 10000
   * 1 <= barcodes[i] <= 10000
   *
   * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
   *
   * 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：[1,1,1,2,2,2]
   * 输出：[2,1,2,1,2,1]
   * 示例 2：
   *
   * 输入：[1,1,1,1,2,2,3,3]
   * 输出：[1,3,1,3,2,1,2,1]
   *  
   *
   * 提示：
   *
   * 1 <= barcodes.length <= 10000
   * 1 <= barcodes[i] <= 10000
   *  
   */
  class Solution {

    public int[] rearrangeBarcodes(int[] barcodes) {

      int[] nb = new int[barcodes.length];

      int[] times = new int[10001];

      for (int barcode : barcodes) {
        times[barcode]++;
      }

      List<int[]> list = new ArrayList<>();

      for (int i = 0; i < times.length; i++) {
        if (times[i] != 0) {
          int[] ints = new int[2];
          ints[0] = i;
          ints[1] = times[i];
          list.add(ints);
        }
      }

      list.sort((o1, o2) -> Integer.compare(o2[1], o1[1]));

      int l = -2;
      int r = -1;
      int bl = barcodes.length - 3;

      for (int[] ints : list) {
        for (int j = 0; j < ints[1]; j++) {
          int i = l > bl ? (r += 2) : (l += 2);
          barcodes[i] = ints[0];
        }
      }

      return barcodes;
    }
  }
}
