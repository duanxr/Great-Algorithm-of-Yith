package com.duanxr.yith.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javafx.util.Pair;

/**
 * @author Duanran 2020/3/6
 */
public class HeWeiSDeLianXuZhengShuXuLieLcof {

  /**
   * English description is not available for the problem.
   *
   * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
   *
   * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
   *
   * 示例 1：
   *
   * 输入：target = 9
   * 输出：[[2,3,4],[4,5]]
   * 示例 2：
   *
   * 输入：target = 15
   * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
   *  
   *
   * 限制：
   *
   * 1 <= target <= 10^5
   *
   */
  class Solution {

    public int[][] findContinuousSequence(int target) {
      LinkedList<Integer> list = new LinkedList<>();
      int listCount = 0;
      List<int[]> result = new ArrayList<>();
      for (int i = 1; i <= (target + 1) / 2; i++) {
        list.addFirst(i);
        listCount += i;
        if (listCount == target) {
          int [] array = new int[list.size()];
          for (int ai = 0; ai < array.length; ai++) {
            array[ai]=list.getLast()+ai;
          }
          result.add(array);
        }
        while (listCount >= target) {
          listCount -= list.removeLast();
          if (listCount == target) {
            int [] array = new int[list.size()];
            for (int ai = 0; ai < array.length; ai++) {
              array[ai]=list.getLast()+ai;
            }
            result.add(array);
          }
        }
      }
      int[][] out = new int[result.size()][];
      return result.toArray(out);
    }
  }
}
