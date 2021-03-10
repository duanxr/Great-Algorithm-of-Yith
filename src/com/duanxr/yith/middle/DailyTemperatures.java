package com.duanxr.yith.middle;

import java.util.Stack;
import javafx.util.Pair;

/**
 * @author 段然 2021/3/10
 */
public class DailyTemperatures {

  /**
   * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
   *
   * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
   *
   * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
   *
   * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
   *
   * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
   *
   * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
   *
   */
  class Solution {

    public int[] dailyTemperatures1(int[] T) {
      int[] result = new int[T.length];
      Stack<Pair<Integer, Integer>> stack = new Stack<>();
      for (int i = 0; i < T.length; i++) {
        while (!stack.isEmpty() && stack.peek().getKey() < T[i]) {
          Pair<Integer, Integer> pop = stack.pop();
          result[pop.getValue()] = i - pop.getValue();
        }
        stack.push(new Pair<>(T[i], i));
      }
      return result;
    }
  }
}
