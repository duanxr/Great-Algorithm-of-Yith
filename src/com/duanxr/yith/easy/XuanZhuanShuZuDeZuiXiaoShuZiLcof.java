package com.duanxr.yith.easy;

import java.util.Stack;
import javafx.util.Pair;

/**
 * @author 段然 2021/3/17
 */
public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {

  /**
   * English description is not available for the problem.
   *
   * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
   *
   * 示例 1：
   *
   * 输入：[3,4,5,1,2]
   * 输出：1
   * 示例 2：
   *
   * 输入：[2,2,2,0,1]
   * 输出：0
   * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
   *
   */
  class Solution {

    public int minArray(int[] numbers) {
      int min = numbers[0];
      int n = numbers[0];
      Stack<Pair<Integer, Integer>> stack = new Stack<>();
      stack.push(new Pair<>(0, numbers.length - 1));
      while (!stack.isEmpty()) {
        Pair<Integer, Integer> pop = stack.pop();
        int l = pop.getKey();
        int r = pop.getValue();
        int i = l + ((r - l) / 2);
        min = Math.min(min, numbers[i]);
        if (numbers[i] > n) {
          l = i + 1;
          pushToStack(stack, l, r);
        } else if (numbers[i] < n) {
          r = i - 1;
          pushToStack(stack, l, r);
        } else {
          int ll = i + 1;
          int rr = i - 1;
          pushToStack(stack, ll, r);
          pushToStack(stack, l, rr);
        }

      }
      return min;
    }

    private void pushToStack(Stack<Pair<Integer, Integer>> stack, int l, int r) {
      if (l <= r) {
        stack.push(new Pair<>(l, r));
      }
    }
  }
}
